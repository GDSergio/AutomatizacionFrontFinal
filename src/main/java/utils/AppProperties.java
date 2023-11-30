package utils;

public class AppProperties {

    private AppProperties(){}

    static ConfigFileReader reader = new ConfigFileReader("src/main/resources/configs/config.properties");

    // Credenciales

    public static String getSpreadSheetId(){ return reader.getPropertyByKey("SPREADSHEET_IDS"); }
    public static String getNameHoja(){ return reader.getPropertyByKey("NAME_HOJA"); }
    public static String getRange(){
        return reader.getPropertyByKey("RANGE");
    }

    public static String getRange2(){
        return reader.getPropertyByKey("RANGE2");
    }

    // Conexion BD
    public static String getMySqlUrl(){
        return  reader.getPropertyByKey("MYSQL_URL");
    }
    public static String getMySqlUser(){ return  reader.getPropertyByKey("MYSQL_USER"); }
    public static String getMySqlPassword(){ return  reader.getPropertyByKey("MYSQL_PASSWORD"); }

}
