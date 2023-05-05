/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import acceso.bicicletasDAO;
import modelo.*;

public class bicicletasControlador {
    
    Scanner sc=new Scanner(System.in);
    
    public void gestionBicicletas(){
        int opcion;
        do{
            System.out.println("Gestion de bicicletas".toUpperCase());
            System.out.println("1. Agregar bicicletas");
            System.out.println("2. Consultar bicicletas");
            System.out.println("3. Actualizar bicicletas");
            System.out.println("4. Eliminar bicicletas");
            System.out.println("5. Listar bicicletas");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addBicicletas();break;
                case 2:getBicicletas();break;
                case 3:updateBicicletas();break;
                case 4:deleteBicicletas();break;  
                case 5:listBicicletas();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addBicicletas(){
        
        int bici_id;
        
        do{
            System.out.println("AGREGAR BICICLETAS");
            System.out.println("Ingrese id de bicicleta: ");
            
            
            bici_id=sc.nextInt();
            sc.nextLine();
            if(bici_id!=0){
               bicicletasDAO BicicletasDao=new bicicletasDAO();
               ArrayList<bicicletas>Bicicletas=BicicletasDao.getListbicicleta(bici_id);
               if(Bicicletas.size()>0){
                   System.out.println("ID de bicicleta ya registrado");
               }else{
                   System.out.println("Fabricante: ");
                   String fabricante=sc.nextLine();
                   System.out.println("Precio: ");
                   int bici_precio=sc.nextInt();
                   sc.nextLine();
                   System.out.println("Año: ");
                   String bici_año=sc.nextLine();
                   
                   bicicletas NBicicletas=new bicicletas(bici_id, fabricante,
                           bici_precio, bici_año);
                   
                    if(BicicletasDao.savebicicletas(NBicicletas)==1){
                        System.out.println("Bicicleta grabada con exito");
                    }else{
                        System.out.println("Error al grabar la bicicleta");
                    }
               }
               int opcion;          
               System.out.println("Presione 0 para salir:");
               opcion=sc.nextInt();
               sc.nextLine();
               if(opcion==0){
                   gestionBicicletas();
        }
            }
        }while(bici_id!=0);
        
    }
    
    private void getBicicletas(){
        
        System.out.println("CONSULTA BICICLETAS");
        System.out.println("ID bicicleta = ");
        int bici_id=sc.nextInt();
        sc.nextLine();
        bicicletasDAO BicicletasDao=new bicicletasDAO();
        ArrayList<bicicletas>listbicicletas=BicicletasDao.getListbicicleta(bici_id);

        if(listbicicletas.size()>0){
            
            System.out.println("ID BICI\tFABRICANTE\tPRECIO BICI\tAÑO BICI");
            for(bicicletas Bicicletas:listbicicletas){
                System.out.println(Bicicletas.getBici_id()+"\t"+
                    Bicicletas.getFabricante()+"\t"+
                    Bicicletas.getBici_precio()+"\t"+
                    Bicicletas.getBici_año());
            }
        }else{
            System.out.println("ID de bicicleta no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    private void updateBicicletas(){
        
        int bici_id;
        do{
            System.out.println("ACTUALIZAR DATOS DE BICICLETAS");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            bici_id=sc.nextInt();
            sc.nextLine();
            
            if(bici_id!=0){
                bicicletasDAO BicicletasDao=new bicicletasDAO();
                ArrayList<bicicletas>Bicicletas=BicicletasDao.getListbicicleta(bici_id);
                
                    System.out.println("Fabricante: ");
                    String fabricante=sc.nextLine();
                    System.out.println("bici_precio: ");
                    int bici_precio=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Año: ");
                    String bici_año=sc.nextLine();
                   
                   bicicletas NvBicicletas=new bicicletas(bici_id, fabricante,
                           bici_precio, bici_año);

                    if(BicicletasDao.updatebicicletas(NvBicicletas)==1){
                            System.out.println("Bicicleta actualizada con exito");
                    }else{
                            System.out.println("Error al actualizar los datos de la bicicleta");
                    }
            }
            
        }while(bici_id!=0);
    }
    
    private void deleteBicicletas(){
        
        int bici_id;
        do{
            System.out.println("BORRAR DATOS DE UNA BICICLETA");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            bici_id=sc.nextInt();
            sc.nextLine();
            
            if(bici_id!=0){
                bicicletasDAO BicicletasDao=new bicicletasDAO();
                ArrayList<bicicletas>Bicicletas=BicicletasDao.getListbicicleta(bici_id);
                    
                    if(BicicletasDao.deletebicicletas(bici_id)==1){
                            System.out.println("Datos de bicicleta borrados con exito");
                    }else{
                            System.out.println("Error al borrar datos de la bicicleta");
                    }
            }
       
            
        }while(bici_id!=0);
        
    }
    
    private void listBicicletas(){
        bicicletasDAO BicicletasDao=new bicicletasDAO();
        ArrayList<bicicletas>listbicicletas=BicicletasDao.getListbicicleta(0);
        System.out.println("LISTADO BICICLETAS");
        System.out.println("ID\tFABRICANTE\tPRECIO BICI\tAÑO BICI");
        for(bicicletas Bicicletas:listbicicletas){
            System.out.println(Bicicletas.getBici_id()+"\t"+
                    Bicicletas.getFabricante()+"\t"+
                    Bicicletas.getBici_precio()+"\t"+
                    Bicicletas.getBici_año());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
}
