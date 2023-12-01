package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FiltroPrecioActions {

    public boolean validarNombre(String nombreDesplegado, String usuario) {
        for (int i = 0; i < 10; i++) {
            if (nombreDesplegado.charAt(i) == ',') {
                String nombreEnPantalla = nombreDesplegado.substring(i + 2, nombreDesplegado.length());
                try {
                    Assert.assertEquals(nombreEnPantalla, usuario.toUpperCase());
                    return nombreEnPantalla.equals(usuario.toUpperCase());
                } catch (AssertionError ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
        return false;
    }

    public void borrarPrecio(WebElement progressBar) {
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

    public void escribirPrecio(int precio, WebElement progressBar) throws InterruptedException {
        progressBar.clear();
        borrarPrecio(progressBar);
        for (int i = 0; i < 5; i++) {
            try {
                progressBar.sendKeys(String.valueOf(String.valueOf(precio).charAt(i)));
                Thread.sleep(300);
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public boolean validatePrices(List<WebElement> prices, int precio) {
        for (int i = 0; i < prices.size(); i++) {
            String number = prices.get(i).getText().substring(1, 4);
            if (Integer.parseInt(number.replace(".", ",")) > precio) {
                return false;
            }
        }
        return true;
    }

}
