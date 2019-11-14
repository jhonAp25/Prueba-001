package config;

import java.sql.*;

public class Conexion {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    private Conexion(){

         url = "jdbc:mysql://localhost:3306/BD_BECAS1";
         driver = "com.mysql.jdbc.Driver";
         usuario = "root";
         password = "12345678";
        
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    } // Fin constructor

    // Métodos
    public static Connection getConnection() {

        if (conn == null) {
            new Conexion();
        }

        return conn;
    } // Fin getConnection
    
//    
//    public static void main(String[] args) {
//        Connection cn = Conexion.getConnection();
//        System.out.println("Exito");
//    }

}
