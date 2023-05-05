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

public class fabricantesDAO {
    
    public int savefabricantes(fabricantes Fabricantes){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" INSERT INTO fabricantes VALUES(?)";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1,Fabricantes.getFabricante());
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deletefabricantes(String fabricante){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" DELETE FROM fabricantes WHERE fabricante=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1, fabricante);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
   
    
    public ArrayList<fabricantes>getListfabricante(String fabricante){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<fabricantes> listfabricantes=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(fabricante==""){
            sql=" SELECT * FROM fabricantes ORDER BY fabricante";
          
        }else{
            sql=" SELECT * FROM fabricantes"+
                    " WHERE fabricante = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(fabricante!=""){
                pstm.setString(1, fabricante);
            }
            rs=pstm.executeQuery();
            
            fabricantes Fabricantes=null;
            while(rs.next()){
                Fabricantes=new fabricantes();
                Fabricantes.setFabricante(rs.getString("fabricante"));
      
                listfabricantes.add(Fabricantes);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listfabricantes;
    }
    
}
