package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import utils.GoogleSheetsReader;
import utils.UtilConstants;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class StepDefinitions {

    private WebDriver driver;

    @When("La página ha cargado completamente")
    public void la_página_ha_cargado_completamente() {
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
//        image.sendKeys("C:\\Users\\guzma\\Documents\\automatizacion\\AutomatizacionDePruebas\\src\\test\\resources\\img\\valorant.png");
        image.sendKeys("C:\\Users\\Alexis\\Documents\\especializacion\\AutomatizacionFrontFinal\\src\\test\\resources\\img\\valorant.png");
    }
}
