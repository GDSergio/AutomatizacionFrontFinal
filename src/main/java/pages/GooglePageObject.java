/*package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utils.GoogleSheetsReader;
import utils.UtilConstants;
import utils.data.AppDB;
import utils.data.ConnectionManagerDB;
import utils.data.QueriesConstants;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.UtilConstants.*;

@DefaultUrl("https:/www.google.com.co")
public class GooglePageObject extends PageObject {

    @FindBy(name = "q")
    WebElementFacade SEARCH_FIELD;

    public void writeOnSearchField(String string){
        enter(string).into(SEARCH_FIELD);
    }

    public void readSheetAndWriteOnSearchField(Integer rowNumber){
        String valueToSearch;
        String range = UtilConstants.NAME_HOJA + "!" + UtilConstants.RANGE;
        List<List<Object>> values = null;
        try {
            values = GoogleSheetsReader.read(UtilConstants.SPREADSHEET_IDS,range);
            if (values == null || values.isEmpty()) {
                throw new RuntimeException("No hay datos en el documento.");
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("No se leyo el documento, error: "+ e.getMessage());
        }
        try {
            valueToSearch = String.valueOf((values).get(rowNumber).get(0));
        }catch (Exception e){
            throw new RuntimeException("registro(s) vacio(s), error: "+e.getMessage());
        }
        enter(valueToSearch).into(SEARCH_FIELD);
    }

    public void readDBAndWriteOnSearchField(Integer id){

        ResultSet resultSet;
        HashMap<String,String> hashMap;
        try {
            Connection connection = ConnectionManagerDB.util().crearConexionMySql(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
            resultSet = AppDB.executeSelect(String.format(QueriesConstants.SELECT_DATA_SEARCH_VALUES_BY_ID,id),connection);
            hashMap = (HashMap<String, String>) AppDB.fillHashWithResultSetRecord(resultSet);
            ConnectionManagerDB.util().closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException("error obteniendo valor de la base de datos, mensaje: " + e.getMessage());
        }
        enter(hashMap.get("value")).into(SEARCH_FIELD);
    }

    public void pressEnterOnSearchField(){
//        enter(Keys.ENTER).into(SEARCH_FIELD);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(SEARCH_FIELD,Keys.ENTER).perform();
        enter(Keys.ENTER).into(SEARCH_FIELD);
    }

    public void assertContent(){
     //  waitForRenderedElements(By.xpath("//*[contains(text(),\"Online Courses\")]"));
     //   assertThat(getDriver().getPageSource().contains("Online Courses"),equalTo(true));

    }
}
*/