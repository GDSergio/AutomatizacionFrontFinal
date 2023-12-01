package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    WebElement loginButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new LoginPage(driver);
    }
}
