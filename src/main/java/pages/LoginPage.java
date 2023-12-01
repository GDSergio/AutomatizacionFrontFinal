package pages;

import actions.LoginActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private LoginActions loginActions;

    @FindBy(css = "#login input")
    WebElement userField;

    @FindBy(css = "input[type=\"password\"]")
    WebElement passwordField;

    @FindBy(css = "button[form='login']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysUserField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(userField));
        userField.sendKeys(charSequences);
    }

    public void sendKeysPasswordField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(charSequences);
    }

    public FiltroPrecioPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new FiltroPrecioPage(driver);
    }

}
