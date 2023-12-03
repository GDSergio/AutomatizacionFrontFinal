package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.UtilConstants;

import static stepDefinitions.Hooks.carritoPage;
import static stepDefinitions.Hooks.readExcel;

public class CarritoStepDefinitions {

    @And("Dar Clic en el enlace del book")
    public void darClicEnElEnlaceDelBook() {
        carritoPage.clickBookLink();
    }

    @And("Leer desde el Excel {int}")
    public void completarConElNombreConElCorreoConElSecurynumberConElTelefono(int row) {
        carritoPage.sendKeysNameField(readExcel(UtilConstants.NAME_HOJA, UtilConstants.RANGE, row));
        carritoPage.sendKeysEmailField(readExcel(UtilConstants.NAME_HOJA, UtilConstants.RANGE_EMAIL, row));
        carritoPage.sendKeysSecurityField(readExcel(UtilConstants.NAME_HOJA, UtilConstants.RANGE_SECURYNUMBER, row));
        carritoPage.sendKeysPhoneField(readExcel(UtilConstants.NAME_HOJA, UtilConstants.RANGE_PHONE, row));
//        carritoPage.sendKeysImgField("C:\\Users\\Alexis\\Documents\\especializacion\\AutomatizacionFrontFinal\\src\\test\\resources\\img\\valorant.png");
//        image.sendKeys("C://Users//Santi//Downloads//AutomatizacionDePruebas-master//AutomatizacionDePruebas-master//src//test//resources//img//valorant.png");
        carritoPage.sendKeysImgField("C:\\Users\\guzma\\Documents\\automatizacion\\AutomatizacionDePruebas\\src\\test\\resources\\img\\valorant.png");
//        carritoPage.sendKeysImgField("C:\\Users\\junio\\OneDrive\\Documentos\\especializacion\\AutomatizacionFrontFinal\\src\\test\\resources\\img\\valorant.png");
    }

    @And("pongo un codigo de descuento")
    public void pongoUnCodigoDeDescuento() {
        carritoPage.sendKeysCodeField("12345");
        carritoPage.clickApplyButton();
        carritoPage.clickCheckbox();
    }

    @Then("El carrito aparecerá con tu compra")
    public void elCarritoApareceraConTuCompra() {
    }

}
