package pages;

import actions.FiltroPrecioActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FiltroPrecioPage extends BasePage {

    private FiltroPrecioActions filtroPrecioActions;

    @FindBy(css = "ul div button span")
    WebElement displayedName;

    @FindBy(xpath = "(//input)[8]")
    WebElement progressBar;

    @FindBy(css = "span[Class*='price']")
    List<WebElement> prices;

    public FiltroPrecioPage(WebDriver driver) {
        super(driver);
        filtroPrecioActions = new FiltroPrecioActions();
    }

    public boolean validateDisplayedName(String expectedName) {
        wait.until(ExpectedConditions.visibilityOf(displayedName));
        return filtroPrecioActions.validarNombre(displayedName.getText(), expectedName);
    }

    public void borrarPrecio() {
        wait.until(ExpectedConditions.visibilityOf(progressBar));
        filtroPrecioActions.borrarPrecio(progressBar);
    }

    public void escribirPrecio(int precio) throws InterruptedException {
        filtroPrecioActions.escribirPrecio(precio, progressBar);
    }

    public void sendKeysProgressBar(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(progressBar));
        progressBar.sendKeys(charSequences);
    }

    public boolean comparePrices(int price) {
        return filtroPrecioActions.validatePrices(prices, price);
    }

}
