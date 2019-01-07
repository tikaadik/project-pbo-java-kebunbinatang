package javakb.config;

    import com.mysql.jdbc.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
/**
 *
 * @author LITTLEnstein
 */
public class Koneksi {
    private static String url = "jdbc:mysql://localhost:3306/db_kebunbinatang";
    private static String user ="root";
    private static String pass = "";    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null) {            
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);            
            } catch (SQLException ex) {
                throw ex;
            }            
        }
        return connection;
    }
}