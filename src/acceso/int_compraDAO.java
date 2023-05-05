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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class int_compraDAO {
    
    public int saveint_compra(int_compra Int_compra){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="INSERT INTO int_compra VALUES(?,(SELECT alias FROM Clientes WHERE alias= ?)"
                    + ",(SELECT fabricante FROM fabricantes WHERE fabricante= ?),?)";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, Int_compra.getCompra_id());
            pstm.setString(2, Int_compra.getAlias());
            pstm.setString(3, Int_compra.getFabricante());
            pstm.setString(4, Int_compra.getFecha_hora());
           
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deleteint_compra(int compra_id){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="DELETE FROM int_compra WHERE compra_id=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setInt(1, compra_id);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public int updateint_compra(int_compra Int_compra){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            
            String sql=" UPDATE int_compra SET alias= (SELECT alias FROM Clientes WHERE alias=?),"
                    + " fabricante= (SELECT fabricante FROM fabricantes WHERE fabricante= ?), "
                    + "fecha_hora= ? WHERE compra_id= ?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1,Int_compra.getAlias());
            pstm.setString(2,Int_compra.getFabricante());
            pstm.setString(3,Int_compra.getFecha_hora());
            pstm.setInt(4, Int_compra.getCompra_id());
           
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<int_compra>getListint_compras(int compra_id){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<int_compra> listint_compra=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(compra_id==0){
            sql=" SELECT * FROM int_compra ORDER BY compra_id";
          
        }else{
            sql=" SELECT * FROM int_compra"+
                    " WHERE compra_id = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(compra_id!=0){
                pstm.setInt(1, compra_id);
            }
            rs=pstm.executeQuery();
            
            int_compra Int_compra=null;
            while(rs.next()){
                Int_compra=new int_compra();
                Int_compra.setCompra_id(rs.getInt("compra_id"));
                Int_compra.setAlias(rs.getString("alias"));
                Int_compra.setFabricante(rs.getString("fabricante"));
                Int_compra.setFecha_hora(rs.getString("fecha_hora"));
                listint_compra.add(Int_compra);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listint_compra;
    }
    
}
