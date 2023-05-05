/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import acceso.moto_electricasDAO;
import modelo.*;

public class moto_electricasControlador {
    
    Scanner sc=new Scanner(System.in);
    
    public void gestionMoto_electricas(){
        int opcion;
        do{
            System.out.println("Gestion de motocicletas electricas".toUpperCase());
            System.out.println("1. Agregar motocicletas electricas");
            System.out.println("2. Consultar motocicletas electricas");
            System.out.println("3. Actualizar motocicletas electricas");
            System.out.println("4. Eliminar motocicletas electricas");
            System.out.println("5. Listar motocicletas electricas");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addMoto_electricas();break;
                case 2:getMoto_electricas();break;
                case 3:updateMoto_electricas();break;
                case 4:deleteMoto_electricas();break;  
                case 5:listMoto_electricas();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addMoto_electricas(){
        
        int moto_id;
        
        do{
            System.out.println("AGREGAR MOTOCICLETAS ELECTRICAS");
            System.out.println("Ingrese id de motocicleta electrica: ");
            
            
            moto_id=sc.nextInt();
            sc.nextLine();
            if(moto_id!=0){
               moto_electricasDAO Moto_electricasDao=new moto_electricasDAO();
               ArrayList<moto_electricas>Moto_electricas=Moto_electricasDao.getListmotoelectricas(moto_id);
               if(Moto_electricas.size()>0){
                   System.out.println("ID de motocicleta electrica ya registrado");
               }else{
                   System.out.println("Fabricante: ");
                   String moto_fabricante=sc.nextLine();
                   System.out.println("Precio: ");
                   int moto_precio=sc.nextInt();
                   sc.nextLine();
                   System.out.println("Autonomia: ");
                   String moto_autonomia=sc.nextLine();
                   System.out.println("id de proveedor: ");
                   int prov_id=sc.nextInt();
                   sc.nextLine();
                   
                   moto_electricas NMoto_electricas=new moto_electricas(moto_id, moto_fabricante,
                           moto_precio, moto_autonomia, prov_id);
                   
                    if(Moto_electricasDao.savemoto_electricas(NMoto_electricas)==1){
                        System.out.println("Motocicleta electrica grabada con exito");
                    }else{
                        System.out.println("Error al grabar la motocicleta electrica");
                    }
               }
               int opcion;          
               System.out.println("Presione 0 para salir:");
               opcion=sc.nextInt();
               sc.nextLine();
               if(opcion==0){
                   gestionMoto_electricas();
        }
            }
        }while(moto_id!=0);
        
        
    }
    
    private void getMoto_electricas(){
        
        System.out.println("CONSULTA MOTOCICLETAS");
        System.out.println("ID motocicleta = ");
        int moto_id=sc.nextInt();
        sc.nextLine();
        moto_electricasDAO Moto_electricasDao=new moto_electricasDAO();
        ArrayList<moto_electricas>listmoto_electricas=Moto_electricasDao.getListmotoelectricas(moto_id);

        if(listmoto_electricas.size()>0){
            
            System.out.println("ID\tFABRICANTE\tPRECIO\tAUTONOMIA\tID PROVEEDOR");
            for(moto_electricas Moto_electricas:listmoto_electricas){
                System.out.println(Moto_electricas.getMoto_id()+"\t"+
                    Moto_electricas.getMoto_fabricante()+"\t"+
                    Moto_electricas.getMoto_precio()+"\t"+
                    Moto_electricas.getMoto_autonomia()+"\t"+
                    Moto_electricas.getProv_id());
            }
        }else{
            System.out.println("ID de motocicleta electrica no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    private void updateMoto_electricas(){
        
        int moto_id;
        do{
            System.out.println("ACTUALIZAR DATOS DE MOTOCICLETA");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            moto_id=sc.nextInt();
            sc.nextLine();
            
            if(moto_id!=0){
               moto_electricasDAO Moto_electricasDao=new moto_electricasDAO();
               ArrayList<moto_electricas>Moto_electricas=Moto_electricasDao.getListmotoelectricas(moto_id);
              
                   System.out.println("Fabricante: ");
                   String moto_fabricante=sc.nextLine();
                   System.out.println("Precio: ");
                   int moto_precio=sc.nextInt();
                   sc.nextLine();
                   System.out.println("Autonomia: ");
                   String moto_autonomia=sc.nextLine();
                   System.out.println("id de proveedor: ");
                   int prov_id=sc.nextInt();
                   sc.nextLine();
                   
                   moto_electricas NvMoto_electricas=new moto_electricas(moto_id, moto_fabricante,
                           moto_precio, moto_autonomia, prov_id);
                   
                    if(Moto_electricasDao.updatemoto_electricas(NvMoto_electricas)==1){
                            System.out.println("Motocicleta actualizada con exito");
                    }else{
                            System.out.println("Error al actualizar los datos de la motocicleta");
                    }
            }
            
        }while(moto_id!=0);
    }
    
    private void deleteMoto_electricas(){
        
        int moto_id;
        do{
            System.out.println("BORRAR DATOS DE UNA MOTOCICLETA");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            moto_id=sc.nextInt();
            sc.nextLine();
            
            if(moto_id!=0){
                
                moto_electricasDAO Moto_electricasDao=new moto_electricasDAO();
                ArrayList<moto_electricas>Moto_electricas=Moto_electricasDao.getListmotoelectricas(moto_id);
                    
                    if(Moto_electricasDao.deletemoto_electricas(moto_id)==1){
                            System.out.println("Datos de motocicleta borrados con exito");
                    }else{
                            System.out.println("Error al borrar datos de la motocicleta");
                    }
            }
       
            
        }while(moto_id!=0);
        
    }
    
    private void listMoto_electricas(){
        moto_electricasDAO Moto_electricasDao=new moto_electricasDAO();
        ArrayList<moto_electricas>listmoto_electricas=Moto_electricasDao.getListmotoelectricas(0);
        System.out.println("LISTADO BICICLETAS");
        System.out.println("ID\tFABRICANTE\tPRECIO\tAUTONOMIA\tID PROVEEDOR");
        for(moto_electricas Moto_electricas:listmoto_electricas){
            System.out.println(Moto_electricas.getMoto_id()+"\t"+
                    Moto_electricas.getMoto_fabricante()+"\t"+
                    Moto_electricas.getMoto_precio()+"\t"+
                    Moto_electricas.getMoto_autonomia()+"\t"+
                    Moto_electricas.getProv_id());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
}
