package utils.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManagerDB {

    Logger logger=Logger.getLogger(ConnectionManagerDB.class.getName());
    private Connection connection;


    public static ConnectionManagerDB util(){return new ConnectionManagerDB();}

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection con) {
        connection = con;
    }


    public Connection crearConexionMySql(String strCon, String usr, String pwd) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(strCon, usr, pwd);
            logger.log(Level.FINE, "Connection successful");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Falló la creación de la conexión con la BD de MySQL, error: "+ ex.getMessage());
        }
    }

    public void closeConnection( Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,() ->"CONNECTION_NOT_CLOSED " + e.getMessage());
        }
    }
}
