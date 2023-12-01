package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import utils.UtilConstants;

import static stepDefinitions.Hooks.filtroPrecioPage;
import static stepDefinitions.Hooks.readExcel;

public class FiltroPrecioStepDefinitions {

    @And("Seleccionar el precio {int}")
    public void seleccionarElPrecio(int row) throws InterruptedException {
        filtroPrecioPage.borrarPrecio();
        filtroPrecioPage.escribirPrecio(Integer.parseInt(readExcel(UtilConstants.NAME_HOJA_FILTRO, UtilConstants.RANGE_FILTRO_PRECIO, row)));
        filtroPrecioPage.sendKeysProgressBar(Keys.ENTER);
    }

    @Then("Validar que los planetas listados sean de precio menor a {int}")
    public void validarQueLosPlanetasListadosSeanDePrecioMenorA(int row) {
        Assert.assertTrue(filtroPrecioPage.comparePrices(Integer.parseInt(readExcel(UtilConstants.NAME_HOJA_FILTRO, UtilConstants.RANGE_FILTRO_PRECIO, row))));
    }

}
