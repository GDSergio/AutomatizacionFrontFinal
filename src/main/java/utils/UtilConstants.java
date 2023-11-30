package utils;

public class UtilConstants {

//    Archivo credenciales mision match
    public static final String SPREADSHEET_IDS = AppProperties.getSpreadSheetId();

    // CARRITO
    public static final String NAME_HOJA = AppProperties.getNameHoja();
    public static final String RANGE = AppProperties.getRange();
    public static final String RANGE_EMAIL = AppProperties.getRangeEmail();
    public static final String RANGE_SECURYNUMBER = AppProperties.getRangeSecuryNumber();
    public static final String RANGE_PHONE = AppProperties.getRangePhone();

    //LOGIN
    public static final String NAME_HOJA_LOGIN = AppProperties.getNameHojaLogin();
    public static final String RANGE_USUARIO = AppProperties.getRangeLoginUsuario();
    public static final String RANGE_PASSWORD = AppProperties.getRangeLoginPassword();

//    Conexion BD

    public static final String MYSQL_URL = AppProperties.getMySqlUrl();
    public static final String MYSQL_USER = AppProperties.getMySqlUser();
    public static final String MYSQL_PASSWORD = AppProperties.getMySqlPassword();

}
