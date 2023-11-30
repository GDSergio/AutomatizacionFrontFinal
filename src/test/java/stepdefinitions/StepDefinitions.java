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

    @And("Llenar el campo de usuario como {string}")
    public void llenarElCampoDeUsuarioComo(String usuario) {
        this.driver.findElement(By.cssSelector("#login input")).sendKeys(usuario);
    }

    @And("Llenar el campo contraseña como {string}")
    public void llenarElCampoContraseñaComo(String contrasena) {
        this.driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(contrasena);
    }

    @When("Dar Clic en el botón LOGIN")
    public void dar_clic_en_el_botón_login() throws InterruptedException {
        Thread.sleep(500);
        this.driver.findElement(By.cssSelector("button[form='login']")).click();
    }

    @Then("Validar que el {string} aparezca en la parte superior derecha")
    public void validarQueElAparezcaEnLaParteSuperiorDerecha(String usuario) throws InterruptedException {
        Thread.sleep(500);
        String nombreDesplegado = this.driver.findElement(By.cssSelector("ul div button span")).getText();
        validarNombre(nombreDesplegado, usuario);
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
        WebElement applyButton = driver.findElement(By.xpath("(//button)[10]"));
        applyButton.click();

        // se pone check div[Class*='theme__check___2B20W ']
        WebElement check = driver.findElement(By.cssSelector("div[Class*='theme__check___2B20W']"));
        check.click();

    }

    @Then("El carrito aparecerá con tu compra")
    public void elCarritoApareceraConTuCompra() {
    }

    @And("Seleccionar el precio “{int}”")
    public void seleccionarElPrecio(int precio) throws InterruptedException {
        Thread.sleep(800); // Esto es un timeout
        WebElement progressBar = driver.findElement(By.xpath("(//input)[8]"));
        Thread.sleep(500);
        borrarPrecio();

        escribirPrecio(precio);
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


    @Then("Validar que los planetas listados sean de precio menor a “{int}”")
    public void validarQueLosPlanetasListadosSeanDePrecioMenorA(int valor) {
        List<WebElement> prices = driver.findElements(By.cssSelector("span[Class*='price']"));
        for (int i = 0; i < prices.size(); i++) {
            String number = prices.get(i).getText().substring(1, 4);
            int number2 = Integer.parseInt(number.replace(".", ","));
            Assert.assertTrue(number2 < valor);
        }
    }

    @AfterTest
    @Then("Cerrar navegador")
    public void cerrarNavegador() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }

    @And("completar con {string} el nombre, con {string} el correo,con {string} el securynumber,con {string} el telefono")
    public void completarConElNombreConElCorreoConElSecurynumberConElTelefono(String namee, String eemail, String security, String phonee) throws InterruptedException {
        Thread.sleep(1500);

        //se escribe el nombre
        WebElement name = driver.findElement(By.xpath("(//input)[9]"));
        name.sendKeys(namee);

        //se escribe el email
        WebElement email = driver.findElement(By.xpath("(//input)[10]"));
        email.sendKeys(eemail);

        //se escribe el securityNumber
        WebElement securityNumber = driver.findElement(By.xpath("(//input)[11]"));
        securityNumber.sendKeys(security);

        //se escribe el phone
        WebElement phone = driver.findElement(By.xpath("(//input)[12]"));
        phone.sendKeys(phonee);

        //se seleciona el archivo
        WebElement image = driver.findElement(By.cssSelector("input[type='file']"));
//        image.sendKeys("C://Users//Santi//Downloads//AutomatizacionDePruebas-master//AutomatizacionDePruebas-master//src//test//resources//img//valorant.png");
        image.sendKeys("C:\\Users\\guzma\\Documents\\automatizacion\\AutomatizacionDePruebas\\src\\test\\resources\\img\\valorant.png");
    }
}
