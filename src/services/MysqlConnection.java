package services;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "quan_ly_nhan_khau";
        String userName = "root";
        String password = "";
        return getMysqlConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password) 
        throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
