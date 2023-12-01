package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FiltroPrecioPage;
import pages.LoginPage;
import utils.UtilConstants;

import static stepDefinitions.Hooks.*;

public class LoginStepDefinitions {

    private LoginPage loginPage;

    @When("Dar Clic en el enlace del LOGIN")
    public void dar_clic_en_el_enlace_del_login() {
        loginPage = basePage.goToLoginPage();
    }

    @And("Llenar el campo de usuario como {int}")
    public void llenarElCampoDeUsuarioComo(int row) {
        loginPage.sendKeysUserField(readExcel(UtilConstants.NAME_HOJA_LOGIN, UtilConstants.RANGE_USUARIO, row));
    }

    @And("Llenar el campo contraseña como {int}")
    public void llenarElCampoContrasenaComo(int row) {
        loginPage.sendKeysPasswordField(readExcel(UtilConstants.NAME_HOJA_LOGIN, UtilConstants.RANGE_PASSWORD, row));
    }

    @When("Dar Clic en el botón LOGIN")
    public void dar_clic_en_el_boton_login() {
        filtroPrecioPage = loginPage.clickLoginButton();
    }

    @Then("Validar que el {int} aparezca en la parte superior derecha")
    public void validarQueElAparezcaEnLaParteSuperiorDerecha(int row) {
        Assert.assertTrue(filtroPrecioPage.validateDisplayedName(readExcel(UtilConstants.NAME_HOJA_LOGIN, UtilConstants.RANGE_USUARIO, row)));
    }
}
