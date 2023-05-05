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

public class proveedorDAO {
    public int saveproveedor(proveedor Proveedor){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="INSERT INTO proveedor VALUES(?,?,?,?)";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, Proveedor.getProv_id());
            pstm.setString(2,Proveedor.getProv_nombre());
            pstm.setString(3,Proveedor.getProv_direccion());
            pstm.setString(4, Proveedor.getProv_telefono());
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deleteproveedor(int prov_id){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="DELETE FROM proveedor WHERE prov_id=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, prov_id);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public int updateproveedor(proveedor Proveedor){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" UPDATE proveedor"+
                    " SET prov_nombre= ?, prov_direccion= ?,"
                    + "prov_telefono= ? WHERE prov_id= ?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1,Proveedor.getProv_nombre());
            pstm.setString(2,Proveedor.getProv_direccion());
            pstm.setString(3,Proveedor.getProv_telefono());
            pstm.setInt(4, Proveedor.getProv_id());
           //revisar esta parte
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<proveedor>getListproveedores(int prov_id){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<proveedor> listproveedor=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(prov_id==0){
            sql=" SELECT * FROM proveedor ORDER BY prov_id";
          
        }else{
            sql=" SELECT * FROM proveedor"+
                    " WHERE prov_id = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(prov_id!=0){
                pstm.setInt(1, prov_id);
            }
            rs=pstm.executeQuery();
            
            proveedor Proveedor=null;
            while(rs.next()){
                Proveedor=new proveedor();
                Proveedor.setProv_id(rs.getInt("prov_id"));
                Proveedor.setProv_nombre(rs.getString("prov_nombre"));
                Proveedor.setProv_direccion(rs.getString("prov_direccion"));
                Proveedor.setProv_telefono(rs.getString("prov_telefono"));
                listproveedor.add(Proveedor);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listproveedor;
    }
}
