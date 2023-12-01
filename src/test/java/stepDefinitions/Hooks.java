package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import pages.BasePage;
import pages.CarritoPage;
import pages.FiltroPrecioPage;
import utils.GoogleSheetsReader;
import utils.UtilConstants;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class Hooks {

    private static WebDriver driver;
    protected static BasePage basePage;
    protected static FiltroPrecioPage filtroPrecioPage;
    protected static CarritoPage carritoPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void seNavegaHacia() {
        System.setProperty("webdriver.http.factory", "jdk-http-client"); // Due to 403 forbidden msgs besides to another maven dependency
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("inprivate");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.testim.io");

        basePage = new BasePage(driver);
        filtroPrecioPage = new FiltroPrecioPage(driver);
        carritoPage = new CarritoPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public static String readExcel(String sheetName, String sheetRange, int row) {
        String range = sheetName + "!" + sheetRange;
        List<List<Object>> values;
        try {
            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS, range);
            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: " + e.getMessage());
        }
        try {
            return String.valueOf((values).get(row).get(0));
        } catch (Exception e) {
            throw new RuntimeException("registro(s) vacio(s), error: " + e.getMessage());
        }
    }

}