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

public class moto_electricasDAO {
    
    public int savemoto_electricas(moto_electricas Moto_electricas){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" INSERT INTO motocicletas_electricas VALUES(?,(SELECT "
                    + "fabricante FROM fabricantes WHERE fabricante= ?),?,?,(SELECT "
                    + "prov_id FROM proveedor WHERE prov_id= ?))";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, Moto_electricas.getMoto_id());
            pstm.setString(2, Moto_electricas.getMoto_fabricante());
            pstm.setInt(3, Moto_electricas.getMoto_precio());
            pstm.setString(4, Moto_electricas.getMoto_autonomia());
            pstm.setInt(5, Moto_electricas.getProv_id());
           
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deletemoto_electricas(int moto_id){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="DELETE FROM motocicletas_electricas WHERE moto_id=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, moto_id);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public int updatemoto_electricas(moto_electricas Moto_electricas){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" UPDATE motocicletas_electricas"+
                    " SET moto_fabricante= ?, moto_precio= ?,"
                    + "moto_autonomia= ?,prov_id= ? WHERE moto_id= ?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1, Moto_electricas.getMoto_fabricante());
            pstm.setInt(2, Moto_electricas.getMoto_precio());
            pstm.setString(3, Moto_electricas.getMoto_autonomia());
            pstm.setInt(4, Moto_electricas.getProv_id());
            pstm.setInt(5, Moto_electricas.getMoto_id());
            
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<moto_electricas>getListmotoelectricas(int moto_id){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<moto_electricas> listmoto_electricas=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(moto_id==0){
            sql=" SELECT * FROM motocicletas_electricas ORDER BY moto_id";
          
        }else{
            sql=" SELECT * FROM motocicletas_electricas"+
                    " WHERE moto_id = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(moto_id!=0){
                pstm.setInt(1, moto_id);
            }
            rs=pstm.executeQuery();
            
            moto_electricas Moto_electricas=null;
            while(rs.next()){
                Moto_electricas=new moto_electricas();
                Moto_electricas.setMoto_id(rs.getInt("moto_id"));
                Moto_electricas.setMoto_fabricante(rs.getString("moto_fabricante"));
                Moto_electricas.setMoto_precio(rs.getInt("moto_precio"));
                Moto_electricas.setMoto_autonomia(rs.getString("moto_autonomia"));
                Moto_electricas.setProv_id(rs.getInt("prov_id"));
                listmoto_electricas.add(Moto_electricas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listmoto_electricas;
    }
    
}
