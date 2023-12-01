package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import utils.GoogleSheetsReader;
import utils.UtilConstants;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class StepDefinitions {

    private WebDriver driver;

    @Given("Se navega hacia {string}")
    public void seNavegaHacia(String url) {
        //initilizeWait();
        System.setProperty("webdriver.http.factory", "jdk-http-client"); // Due to 403 forbidden msgs besides to another maven dependency

        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        //driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("La página ha cargado completamente")
    public void la_página_ha_cargado_completamente() {

    }

    @When("Dar Clic en el enlace del LOGIN")
    public void dar_clic_en_el_enlace_del_login() {
        this.driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

    }

    @And("Llenar el campo de usuario como {int}")
    public void llenarElCampoDeUsuarioComo(int row) {
//        this.driver.findElement(By.cssSelector("#login input")).sendKeys(usuario);

        // TEST DE LECTURA EXCEL
        String valueToSearch;
        String range = UtilConstants.NAME_HOJA_LOGIN + "!" + UtilConstants.RANGE_USUARIO;
        List<List<Object>> values = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            //valueToSearch = String.valueOf((values).get(rowNumber).get(0));
            valueToSearch = String.valueOf((values).get(row).get(0));
        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }

        this.driver.findElement(By.cssSelector("#login input")).sendKeys(valueToSearch);

    }

    @And("Llenar el campo contraseña como {int}")
    public void llenarElCampoContraseñaComo(int row) {


        // TEST DE LECTURA EXCEL
        String valueToSearch;
        String range = UtilConstants.NAME_HOJA_LOGIN + "!" + UtilConstants.RANGE_PASSWORD;
        List<List<Object>> values = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            //valueToSearch = String.valueOf((values).get(rowNumber).get(0));
            valueToSearch = String.valueOf((values).get(row).get(0));
        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }
        this.driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(valueToSearch);
    }

    @When("Dar Clic en el botón LOGIN")
    public void dar_clic_en_el_botón_login() throws InterruptedException {
        Thread.sleep(500);
        this.driver.findElement(By.cssSelector("button[form='login']")).click();
    }

    @Then("Validar que el {int} aparezca en la parte superior derecha")
    public void validarQueElAparezcaEnLaParteSuperiorDerecha(int row) throws InterruptedException {

        // TEST DE LECTURA EXCEL
        String valueToSearch;
        String range = UtilConstants.NAME_HOJA_LOGIN + "!" + UtilConstants.RANGE_USUARIO;
        List<List<Object>> values = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            //valueToSearch = String.valueOf((values).get(rowNumber).get(0));
            valueToSearch = String.valueOf((values).get(row).get(0));
        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }

        Thread.sleep(500);
        String nombreDesplegado = this.driver.findElement(By.cssSelector("ul div button span")).getText();
        validarNombre(nombreDesplegado, valueToSearch);
//        this.driver.findElement(By.cssSelector("#login input")).sendKeys(valueToSearch);
    }

    private void validarNombre(String nombreDesplegado, String usuario) {
        for (int i = 0; i < 10; i++) {
            if (nombreDesplegado.charAt(i) == ',') {
                String nombreEnPantalla = nombreDesplegado.substring(i + 2, nombreDesplegado.length());
                try {
                    Assert.assertEquals(nombreEnPantalla, usuario.toUpperCase());
                } catch (AssertionError ex) {
                    ex.printStackTrace();
                    this.driver.quit();
                    Assert.fail();
                }
                break;
            }
        }
    }

    @Given("Se navega hacia “https:\\/\\/demo.testim.io\\/destinations”")
    public void seNavegaHaciaHttpsDemoTestimIoDestinations() {
    }


    @And("Dar Clic en el enlace del book")
    public void darClicEnElEnlaceDelBook() throws InterruptedException {
        Thread.sleep(3000);
        WebElement bicho = driver.findElement(By.xpath("(//button)[3]"));
        bicho.click();
    }

    @And("pongo un codigo de descuento")
    public void pongoUnCodigoDeDescuento() throws InterruptedException {
        Thread.sleep(1500);

        //se pone codigo promocional
        WebElement code = driver.findElement(By.xpath("(//input)[15]"));
        code.sendKeys("12345");

        //se da click en el botton apply
        WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[4]/div[2]/button"));
        applyButton.click();

        // se pone check div[Class*='theme__check___2B20W ']
        WebElement check = driver.findElement(By.cssSelector("div[Class*='theme__check___2B20W']"));
        check.click();

    }

    @Then("El carrito aparecerá con tu compra")
    public void elCarritoApareceraConTuCompra() {
    }

    @And("Seleccionar el precio {int}")
    public void seleccionarElPrecio(int row) throws InterruptedException {
        Thread.sleep(800); // Esto es un timeout

        int valueToSearch;

        String range = UtilConstants.NAME_HOJA_FILTRO + "!" + UtilConstants.RANGE_FILTRO_PRECIO;
        List<List<Object>> values = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }


        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            // esto es para que lea las filas que se le mandan en el feature
            valueToSearch = Integer.parseInt(String.valueOf((values).get(row).get(0)));

        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }

        WebElement progressBar = driver.findElement(By.xpath("(//input)[8]"));
        Thread.sleep(500);
        borrarPrecio();

        escribirPrecio(valueToSearch);
        progressBar.sendKeys(Keys.ENTER);
    }

    private void borrarPrecio() {
        WebElement progressBar = driver.findElement(By.xpath("(//input)[8]"));
        progressBar.click();
        progressBar.sendKeys(Keys.BACK_SPACE);
        progressBar.click();
        progressBar.sendKeys(Keys.BACK_SPACE);
        progressBar.click();
        progressBar.sendKeys(Keys.BACK_SPACE);
        progressBar.click();
        progressBar.sendKeys(Keys.DELETE);
        progressBar.click();
        progressBar.sendKeys(Keys.DELETE);
    }

    public void escribirPrecio(int bichoxd) throws InterruptedException {
        WebElement progressBar = driver.findElement(By.xpath("(//input)[8]"));
        progressBar.clear();
        borrarPrecio();
        for (int i = 0; i < 5; i++) {
            try {
                String bichoCaracter = String.valueOf(String.valueOf(bichoxd).charAt(i));
                progressBar.sendKeys(bichoCaracter);
                Thread.sleep(300);
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
    }


    @Then("Validar que los planetas listados sean de precio menor a {int}")
    public void validarQueLosPlanetasListadosSeanDePrecioMenorA(int row) {


        int valueToSearch;

        String range = UtilConstants.NAME_HOJA_FILTRO + "!" + UtilConstants.RANGE_FILTRO_PRECIO;
        List<List<Object>> values = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }


        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            // esto es para que lea las filas que se le mandan en el feature
            valueToSearch = Integer.parseInt(String.valueOf((values).get(row).get(0)));

        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }



        List<WebElement> prices = driver.findElements(By.cssSelector("span[Class*='price']"));
        for (int i = 0; i < prices.size(); i++) {
            String number = prices.get(i).getText().substring(1, 4);
            int number2 = Integer.parseInt(number.replace(".", ","));
            Assert.assertTrue(number2 < valueToSearch);
        }
    }

    @AfterTest
    @Then("Cerrar navegador")
    public void cerrarNavegador() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }

    @And("Leer desde el Excel {int}")
//    son los parametros que recibe desde el feature
    public void completarConElNombreConElCorreoConElSecurynumberConElTelefono(int row) throws InterruptedException {
        Thread.sleep(1500);


        String valueToSearch;
        String valueToSearch_email;
        String valueToSearch_securyNumber;
        String valueToSearch_phone;

        String range = UtilConstants.NAME_HOJA + "!" + UtilConstants.RANGE;
        String range_email = UtilConstants.NAME_HOJA + "!" + UtilConstants.RANGE_EMAIL;
        String range_securyNumber = UtilConstants.NAME_HOJA + "!" + UtilConstants.RANGE_SECURYNUMBER;
        String range_phone = UtilConstants.NAME_HOJA + "!" + UtilConstants.RANGE_PHONE;

        List<List<Object>> values = null;
        List<List<Object>> values_email = null;
        List<List<Object>> values_securyNumber = null;
        List<List<Object>> values_phone = null;

        try {

            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);
            values_email = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS, range_email);
            values_securyNumber = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS, range_securyNumber);
            values_phone = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS, range_phone);

            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }


        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            // esto es para que lea las filas que se le mandan en el feature
            valueToSearch = String.valueOf((values).get(row).get(0));
            valueToSearch_email = String.valueOf((values_email).get(row).get(0));
            valueToSearch_securyNumber = String.valueOf((values_securyNumber).get(row).get(0));
            valueToSearch_phone = String.valueOf((values_phone).get(row).get(0));


        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }


        //se escribe el nombre
        WebElement name = driver.findElement(By.xpath("(//input)[9]"));
        // el valueToSearch trae el valor del excel y esto es lo que va a escribir en el campo nombre o name
        name.sendKeys(valueToSearch);

        //se escribe el email
        WebElement email = driver.findElement(By.xpath("(//input)[10]"));
        email.sendKeys(valueToSearch_email);

        //se escribe el securityNumber
        WebElement securityNumber = driver.findElement(By.xpath("(//input)[11]"));
        securityNumber.sendKeys(valueToSearch_securyNumber);

        //se escribe el phone
        WebElement phone = driver.findElement(By.xpath("(//input)[12]"));
        phone.sendKeys(valueToSearch_phone);

        //se seleciona el archivo
        WebElement image = driver.findElement(By.cssSelector("input[type='file']"));
//        image.sendKeys("C://Users//Santi//Downloads//AutomatizacionDePruebas-master//AutomatizacionDePruebas-master//src//test//resources//img//valorant.png");
        image.sendKeys("C:\\Users\\guzma\\Documents\\automatizacion\\AutomatizacionDePruebas\\src\\test\\resources\\img\\valorant.png");
    }
}
