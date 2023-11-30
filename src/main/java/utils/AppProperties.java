package utils;

public class AppProperties {

    private AppProperties() {
    }

    static ConfigFileReader reader = new ConfigFileReader("src/main/resources/configs/config.properties");

    // Credenciales

    public static String getSpreadSheetId() {
        return reader.getPropertyByKey("SPREADSHEET_IDS");
    }

    //    CARRITO
    public static String getNameHoja() {
        return reader.getPropertyByKey("NAME_HOJA");
    }

    public static String getRange() {
        return reader.getPropertyByKey("RANGE");
    }

    public static String getRangeEmail() {
        return reader.getPropertyByKey("RANGE_EMAIL");
    }

    public static String getRangeSecuryNumber() {
        return reader.getPropertyByKey("RANGE_SECURYNUMBER");
    }

    public static String getRangePhone() {
        return reader.getPropertyByKey("RANGE_PHONE");
    }

    //    LOGIN
    public static String getNameHojaLogin() {
        return reader.getPropertyByKey("NAME_HOJA_LOGIN");
    }
    public static String getRangeLoginUsuario() {
        return reader.getPropertyByKey("RANGE_USUARIO");
    }
    public static String getRangeLoginPassword() {
        return reader.getPropertyByKey("RANGE_PASSWORD");
    }


    // Conexion BD
    public static String getMySqlUrl() {
        return reader.getPropertyByKey("MYSQL_URL");
    }

    public static String getMySqlUser() {
        return reader.getPropertyByKey("MYSQL_USER");
    }

    public static String getMySqlPassword() {
        return reader.getPropertyByKey("MYSQL_PASSWORD");
    }

}
