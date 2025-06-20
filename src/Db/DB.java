package Db;

import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Properties props = LoadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }


    private static Properties LoadProperties() {
        try (InputStream is = DB.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (is == null) {
                throw new DbException("Arquivo db.properties não encontrado no classpath. ");
            }
            Properties props = new Properties();
            props.load(is);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}
