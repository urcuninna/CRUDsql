/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;


public class fachada {
    private static String bdUrl="jdbc:mysql://127.0.0.1:3306/reto4";//este es el nombre de la base de datos
    private static String user="root";
    private static String password="000123hiruzen_";
    private static Connection conexion=null;
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection(){
        try {
            if(conexion==null){
                Class.forName(driver);
                conexion=DriverManager.getConnection(bdUrl,user,password);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
            
        }
        return conexion;
    }
    
}
