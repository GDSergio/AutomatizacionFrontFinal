package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarritoPage extends BasePage {

    @FindBy(xpath = "(//button)[3]")
    WebElement bookLink;

    @FindBy(xpath = "(//input)[9]")
    WebElement nameField;

    @FindBy(xpath = "(//input)[10]")
    WebElement emailField;

    @FindBy(xpath = "(//input)[11]")
    WebElement securityNumberField;

    @FindBy(xpath = "(//input)[12]")
    WebElement phoneField;

    @FindBy(css = "input[type='file']")
    WebElement imgField;

    @FindBy(xpath = "(//input)[15]")
    WebElement codeField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/section[1]/div[3]/div[2]/div[4]/div[2]/button")
    WebElement applyButton;

    @FindBy(css = "div[Class*='theme__check___2B20W']")
    WebElement checkbox;

    public CarritoPage(WebDriver driver) {
        super(driver);
    }

    public void clickBookLink() {
        wait.until(ExpectedConditions.visibilityOf(bookLink));
        bookLink.click();
    }

    public void sendKeysNameField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(charSequences);
    }

    public void sendKeysEmailField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(charSequences);
    }

    public void sendKeysSecurityField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(securityNumberField));
        securityNumberField.sendKeys(charSequences);
    }

    public void sendKeysPhoneField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(charSequences);
    }

    public void sendKeysImgField(CharSequence... charSequences) {
        imgField.sendKeys(charSequences);
    }

    public void sendKeysCodeField(CharSequence... charSequences) {
        wait.until(ExpectedConditions.visibilityOf(codeField));
        codeField.sendKeys(charSequences);
    }

    public void clickApplyButton() {
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
    }

    public void clickCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
    }

}
