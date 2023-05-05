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


public class ClientesDAO {
    
    public int saveClientes(Clientes clientes){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="INSERT INTO Clientes VALUES(?,?,?,?,?,?,?)";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1, clientes.getAlias());
            pstm.setString(2, clientes.getClnt_nombre());
            pstm.setString(3, clientes.getClnt_apellidos());
            pstm.setString(4, clientes.getClnt_email());
            pstm.setString(5, clientes.getClnt_celular());
            pstm.setString(6, clientes.getClnt_fNacimiento());
            pstm.setInt(7, clientes.getClnt_contraseña());
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public int deleteClientes(String alias){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql="DELETE FROM Clientes WHERE alias=?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1, alias);
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public int updateClientes(Clientes clientes){
        Connection conexion=null;
        PreparedStatement pstm;
        int resultado;
        resultado=0;
        
        try {
            conexion=fachada.getConnection();
            String sql=" UPDATE Clientes"+
                    " SET clnt_nombre= ?,"
                    + "clnt_apellidos= ?, clnt_email= ?, clnt_celular= ?,"
                    + "clnt_fNacimiento= ?, clnt_contraseña= ? WHERE alias= ?";
        
            pstm=conexion.prepareStatement(sql);
            
            pstm.setString(1,clientes.getClnt_nombre());
            pstm.setString(2,clientes.getClnt_apellidos());
            pstm.setString(3,clientes.getClnt_email());
            pstm.setString(4,clientes.getClnt_celular());
            pstm.setString(5,clientes.getClnt_fNacimiento());
            pstm.setInt(6, clientes.getClnt_contraseña());
            pstm.setString(7,clientes.getAlias());
            
            
            resultado=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<Clientes>getListCliente(String alias){
        
        Connection conexion=null;
        PreparedStatement pstm;
        ResultSet rs=null;
        ArrayList<Clientes>listClientes=new ArrayList();
        String sql=" ";
        conexion=fachada.getConnection();
        if(alias==""){
            sql=" SELECT * FROM Clientes ORDER BY alias";
          
        }else{
            sql=" SELECT * FROM Clientes"+
                    " WHERE alias = ?";
        }
        try {
            pstm=conexion.prepareStatement(sql);
            if(alias!=""){
                pstm.setString(1, alias);
            }
            rs=pstm.executeQuery();
            
            Clientes clientes=null;
            while(rs.next()){
                clientes=new Clientes();
                clientes.setAlias(rs.getString("alias"));
                clientes.setClnt_nombre(rs.getString("clnt_nombre"));
                clientes.setClnt_apellidos(rs.getString("clnt_apellidos"));
                clientes.setClnt_email(rs.getString("clnt_email"));
                clientes.setClnt_celular(rs.getString("clnt_celular"));
                clientes.setClnt_fNacimiento(rs.getString("clnt_fNacimiento"));
                clientes.setClnt_contraseña(rs.getInt("clnt_contraseña"));
                listClientes.add(clientes);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        return listClientes;
    }
    
}
