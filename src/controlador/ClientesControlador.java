/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import acceso.ClientesDAO;
import modelo.*;

public class ClientesControlador {
    
    Scanner sc=new Scanner(System.in);
    
    public void gestionClientes(){
        int opcion;
        do{
            System.out.println("Gestion de clientes".toUpperCase());
            System.out.println("1. Agregar cliente");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Listar cliente");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addClientes();break;
                case 2:getClientes();break;
                case 3:updateClientes();break;
                case 4:deleteClientes();break;  
                case 5:listClientes();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addClientes(){
        
        String alias;
        
        do{
            System.out.println("AGREGAR CLIENTES");
            System.out.println("INGRESE ALIAS: ");
            
            
            alias=sc.nextLine();
            if(alias!=""){
               ClientesDAO clientesDao=new ClientesDAO();
               ArrayList<Clientes>clientes=clientesDao.getListCliente(alias);
               if(clientes.size()>0){
                   System.out.println("Alias ya registrado");
               }else{
                   System.out.println("Nombre: ");
                   String clnt__nombre=sc.nextLine();
                   System.out.println("Apellidos: ");
                   String clnt_apellidos=sc.nextLine();
                   System.out.println("Email: ");
                   String clnt_email=sc.nextLine();
                   System.out.println("Celular: ");
                   String clnt_celular=sc.nextLine();
                   System.out.println("Fecha de nacimiento: ");
                   String clnt_fNacimiento=sc.nextLine();
                   System.out.println("Contraseña: ");
                   int clnt_contraseña=sc.nextInt();
                   sc.nextLine();
                   Clientes Nclientes=new Clientes(alias, clnt__nombre, clnt_apellidos,
                   clnt_email, clnt_celular, clnt_fNacimiento, clnt_contraseña);
                   
                    if(clientesDao.saveClientes(Nclientes)==1){
                        System.out.println("Cliente grabado con exito");
                    }else{
                        System.out.println("Error al grabar el cliente");
                    }
               }
    int opcion;          
    System.out.println("Presione 0 para salir:");
    opcion=sc.nextInt();
    sc.nextLine();
        if(opcion==0){
            gestionClientes();
        }
    
            }
        }while(alias!="");
        
    }
    
    private void getClientes(){
        
        System.out.println("CONSULTA CLIENTES");
        System.out.println("Alias = ");
        String alias=sc.nextLine();
        ClientesDAO clientesDao=new ClientesDAO();
        ArrayList<Clientes>listClientes=clientesDao.getListCliente(alias);

        if(listClientes.size()>0){
            
            System.out.println("ALIAS\tNOMBRE\tAPELLIDOS\tEMAIL\tCELULAR\tFECHA "
                    + "NACIMIENTO\tCONTRASEÑA");
            for(Clientes clientes:listClientes){
                System.out.println(clientes.getAlias()+"\t"+
                    clientes.getClnt_nombre()+"\t"+
                    clientes.getClnt_apellidos()+"\t"+
                    clientes.getClnt_email()+"\t"+
                    clientes.getClnt_celular()+"\t"+
                    clientes.getClnt_fNacimiento()+"\t"+
                    clientes.getClnt_contraseña());
            }
        }else{
            System.out.println("Alias de cliente no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    private void updateClientes(){
        
        String alias;
        do{
            System.out.println("ACTUALLIZAR DATOS DEL CLIENTE");
            System.out.println("INGRESE ALIAS: ");
            alias=sc.nextLine();
            
            if(alias!=""){
                
                ClientesDAO clientesDao=new ClientesDAO();
                ArrayList<Clientes>clientes=clientesDao.getListCliente(alias);
                
                   System.out.println("Nombre: ");
                   String clnt__nombre=sc.nextLine();
                   System.out.println("Apellidos: ");
                   String clnt_apellidos=sc.nextLine();
                   System.out.println("Email: ");
                   String clnt_email=sc.nextLine();
                   System.out.println("Celular: ");
                   String clnt_celular=sc.nextLine();
                   System.out.println("Fecha de nacimiento: ");
                   String clnt_fNacimiento=sc.nextLine();
                   System.out.println("Contraseña: ");
                   int clnt_contraseña=sc.nextInt();
                   sc.nextLine();
                   Clientes NvClientes=new Clientes(alias, clnt__nombre, clnt_apellidos,
                   clnt_email, clnt_celular, clnt_fNacimiento, clnt_contraseña);
                

                    if(clientesDao.updateClientes(NvClientes)==1){
                            System.out.println("Cliente actualizado con exito");
                    }else{
                            System.out.println("Error al actualizar el Cliente");
                    }
            }
    int opcion;          
    System.out.println("Presione 0 para salir:");
    opcion=sc.nextInt();
    sc.nextLine();
        if(opcion==0){
            gestionClientes();
        }        
            
        }while(alias!="");
        
    }
    
    private void deleteClientes(){
        
        String alias;
        do{
            System.out.println("BORRAR UN CLIENTE");
            System.out.println("INGRESE ALIAS: ");
            alias=sc.nextLine();
            
            if(alias!=""){
                
                ClientesDAO clientesDao=new ClientesDAO();
                ArrayList<Clientes>clientes=clientesDao.getListCliente(alias);
                
                    if(clientesDao.deleteClientes(alias)==1){
                            System.out.println("Proveedor borrado con exito");
                    }else{
                            System.out.println("Error al borrar el proveedor");
                    }
            }
    int opcion;          
    System.out.println("Presione 0 para salir:");
    opcion=sc.nextInt();
    sc.nextLine();
        if(opcion==0){
            gestionClientes();
        }        

        }while(alias!="");
        
    }
    
    private void listClientes(){
        ClientesDAO clientesDao=new ClientesDAO();
        ArrayList<Clientes>listClientes=clientesDao.getListCliente("");
        
        System.out.println("LISTADO CLIENTES");
        System.out.println("ALIAS\tNOMBRE\tAPELLIDOS\tEMAIL\tCELULAR\tFECHA "
                    + "NACIMIENTO\tCONTRASEÑA");
        for(Clientes clientes:listClientes){
            System.out.println(clientes.getAlias()+"\t"+
                    clientes.getClnt_nombre()+"\t"+
                    clientes.getClnt_apellidos()+"\t"+
                    clientes.getClnt_email()+"\t"+
                    clientes.getClnt_celular()+"\t"+
                    clientes.getClnt_fNacimiento()+"\t"+
                    clientes.getClnt_contraseña());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
    }
}
