/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import servicios.fachada;


public class bicicletasDAO {
    
    public int savebicicletas(bicicletas Bicicletas){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="INSERT INTO bicicletas VALUES(?,(SELECT fabricante FROM fabricantes WHERE fabricante= ?),?,?)";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, Bicicletas.getBici_id());
            pstm.setString(2, Bicicletas.getFabricante());
            pstm.setInt(3, Bicicletas.getBici_precio());
            pstm.setString(4, Bicicletas.getBici_año());
           
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deletebicicletas(int bici_id){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="DELETE FROM bicicletas WHERE bici_id=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, bici_id);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public int updatebicicletas(bicicletas Bicicletas){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" UPDATE bicicletas"+
                    " SET fabricante= ?, bici_precio= ?,"
                    + "bici_año= ? WHERE bici_id= ?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1,Bicicletas.getFabricante());
            pstm.setInt(2,Bicicletas.getBici_precio());
            pstm.setString(3,Bicicletas.getBici_año());
            pstm.setInt(4, Bicicletas.getBici_id());
           //revisar esta parte
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<bicicletas>getListbicicleta(int bici_id){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<bicicletas> listbicicletas=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(bici_id==0){
            sql=" SELECT * FROM bicicletas ORDER BY bici_id";
          
        }else{
            sql=" SELECT * FROM bicicletas"+
                    " WHERE bici_id = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(bici_id!=0){
                pstm.setInt(1, bici_id);
            }
            rs=pstm.executeQuery();
            
            bicicletas Bicicletas=null;
            while(rs.next()){
                Bicicletas=new bicicletas();
                Bicicletas.setBici_id(rs.getInt("bici_id"));
                Bicicletas.setFabricante(rs.getString("fabricante"));
                Bicicletas.setBici_precio(rs.getInt("bici_precio"));
                Bicicletas.setBici_año(rs.getString("bici_año"));
                listbicicletas.add(Bicicletas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listbicicletas;
    }
}
