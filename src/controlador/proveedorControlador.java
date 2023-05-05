/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import acceso.proveedorDAO;
import modelo.*;

public class proveedorControlador {
    
    Scanner sc=new Scanner(System.in);
    
    public void gestionProveedor(){
        int opcion;
        do{
            System.out.println("Gestion de proveedores".toUpperCase());
            System.out.println("1.Agregar proveedor");
            System.out.println("2.Consultar proveedor");
            System.out.println("3.Actualizar proveedor");
            System.out.println("4. Eliminar proveedor");
            System.out.println("5. Listar proveedor");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addProveedor();break;
                case 2:getProveedor();break;
                case 3:updateProveedor();break;
                case 4:deleteProveedor();break;  
                case 5:listProveedor();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addProveedor(){
        
        int prov_id;
        do{
            System.out.println("Agregar proveedor");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE CODIGO: ");
            
            prov_id=sc.nextInt();
            sc.nextLine();
            if(prov_id!=0){
               proveedorDAO ProveedorDao=new proveedorDAO();
               ArrayList<proveedor>Proveedor=ProveedorDao.getListproveedores(prov_id);
               if(Proveedor.size()>0){
                   System.out.println("Codigo de proveedor ya registrado");
               }else{
                   System.out.println("Nombre: ");
                   String prov_nombre=sc.nextLine();
                   System.out.println("Direccion: ");
                   String prov_direccion=sc.nextLine();
                   System.out.println("Telefono: ");
                   String prov_telefono=sc.nextLine();
                   proveedor nProveedor=new proveedor(prov_id, prov_nombre,
                           prov_direccion,prov_telefono);
                   
                    if(ProveedorDao.saveproveedor(nProveedor)==1){
                        System.out.println("Proveedor grabado con exito");
                    }else{
                        System.out.println("Error al grabar el proveedor");
                    }
               }
                System.out.println("Presione cualquier tecla para salir");
                sc.nextLine();
            }
        }while(prov_id!=0);
        
    }
    
    private void getProveedor(){
        
        System.out.println("CONSULTA PROVEEDORES");
        System.out.println("Codigo = ");
        int codigo=sc.nextInt();
        sc.nextLine();
        proveedorDAO ProveedorDao=new proveedorDAO();
        ArrayList<proveedor>listproveedor=ProveedorDao.getListproveedores(codigo);
        if(listproveedor.size()>0){
            
            System.out.println("CODIGO\tNOMBRE\tDIRECCION\tTELEFONO");
            for(proveedor Proveedor:listproveedor){
                System.out.println(Proveedor.getProv_id()+"\t"+
                    Proveedor.getProv_nombre()+"\t"+
                    Proveedor.getProv_direccion()+"\t"+
                    Proveedor.getProv_telefono());
            }
        }else{
            System.out.println("Codigo de proveedor no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    private void updateProveedor(){
        
        int prov_id;
        do{
            System.out.println("Actualizar datos del proveedor");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE CODIGO: ");
            prov_id=sc.nextInt();
            sc.nextLine();
            
            if(prov_id!=0){
              
                proveedorDAO ProveedorDao=new proveedorDAO();
                    ArrayList<proveedor>Proveedor=ProveedorDao.getListproveedores(prov_id);
                    System.out.println("Nombre: ");
                    String prov_nombre=sc.nextLine();
                    System.out.println("Direccion: ");
                    String prov_direccion=sc.nextLine();
                    System.out.println("Telefono: ");
                    String prov_telefono=sc.nextLine();
                    proveedor NVProveedor=new proveedor(prov_id, prov_nombre,
                    prov_direccion,prov_telefono);

                    if(ProveedorDao.updateproveedor(NVProveedor)==1){
                            System.out.println("Proveedor actualizado con exito");
                    }else{
                            System.out.println("Error al actualizar el proveedor");
                    }
            }
            
        }while(prov_id!=0);
        
    }
    
    private void deleteProveedor(){
        
        int prov_id;
        do{
            System.out.println("Borrar un proveedor");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE CODIGO: ");
            prov_id=sc.nextInt();
            sc.nextLine();
            
            if(prov_id!=0){
              
                proveedorDAO ProveedorDao=new proveedorDAO();
                ArrayList<proveedor>Proveedor=ProveedorDao.getListproveedores(prov_id);
                    

                    if(ProveedorDao.deleteproveedor(prov_id)==1){
                            System.out.println("Proveedor borrado con exito");
                    }else{
                            System.out.println("Error al borrar el proveedor");
                    }
            }
       
            
        }while(prov_id!=0);
        
    }
    
    private void listProveedor(){
        proveedorDAO ProveedorDao=new proveedorDAO();
        ArrayList<proveedor>listproveedor=ProveedorDao.getListproveedores(0);
        System.out.println("LISTADO PROVEEDORES");
        System.out.println("CODIGO\tNOMBRE\tDIRECCION\tTELEFONO");
        for(proveedor Proveedor:listproveedor){
            System.out.println(Proveedor.getProv_id()+"\t"+
                    Proveedor.getProv_nombre()+"\t"+
                    Proveedor.getProv_direccion()+"\t"+
                    Proveedor.getProv_telefono());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
    }
}
