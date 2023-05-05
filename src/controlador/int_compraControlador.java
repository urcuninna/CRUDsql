/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import acceso.int_compraDAO;
import modelo.*;
        
public class int_compraControlador {
    
    Scanner sc=new Scanner(System.in);
    
    public void gestionInt_compra(){
        int opcion;
        do{
            System.out.println("Gestion de intencion de compra".toUpperCase());
            System.out.println("1. Agregar intencion de compra");
            System.out.println("2. Consultar intencion de compra");
            System.out.println("3. Actualizar intencion de compra");
            System.out.println("4. Eliminar intencion de compra");
            System.out.println("5. Listar intencion de compra");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addInt_compra();break;
                case 2:getInt_compra();break;
                case 3:updateInt_compra();break;
                case 4:deleteInt_compra();break;  
                case 5:listInt_compra();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addInt_compra(){
        
        int compra_id;
        
        do{
            System.out.println("AGREGAR INTENCION DE COMRPRA");
            System.out.println("Ingrese id de intencion de compra: ");
            
            
            compra_id=sc.nextInt();
            sc.nextLine();
            if(compra_id!=0){
               int_compraDAO Int_compraDao=new int_compraDAO();
               ArrayList<int_compra>Int_compra=Int_compraDao.getListint_compras(compra_id);
               if(Int_compra.size()>0){
                   System.out.println("ID de intencion de compra ya registrado");
               }else{
                   System.out.println("Alias: ");
                   String alias=sc.nextLine();
                   System.out.println("Fabricante: ");
                   String fabricante= sc.nextLine();
                   System.out.println("Fecha y hora: ");
                   String fecha_hora=sc.nextLine();
                   
                   int_compra NInt_compra=new int_compra(compra_id, alias,
                           fabricante, fecha_hora);
                   
                    if(Int_compraDao.saveint_compra(NInt_compra)==1){
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
                   gestionInt_compra();
        }
            }
        }while(compra_id!=0);
        
    }
    
    private void getInt_compra(){
        
        System.out.println("CONSULTA INTECION DE COMPRA");
        System.out.println("ID intencion de compra = ");
        int compra_id=sc.nextInt();
        sc.nextLine();
        int_compraDAO Int_compraDao=new int_compraDAO();
        ArrayList<int_compra>listint_compra=Int_compraDao.getListint_compras(compra_id);

        if(listint_compra.size()>0){
            
            System.out.println("ID INTENCION COMPRA\tALIAS\tFABRICANTE\tFECHA Y HORA");
            for(int_compra Int_compra:listint_compra){
                System.out.println(Int_compra.getCompra_id()+"\t"+
                    Int_compra.getAlias()+"\t"+
                    Int_compra.getFabricante()+"\t"+
                    Int_compra.getFecha_hora());
            }
        }else{
            System.out.println("ID de intencion de compra no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    private void updateInt_compra(){
        
        int compra_id;
        do{
            System.out.println("ACTUALIZAR DATOS DE INTENCION DE COMPRA");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            compra_id=sc.nextInt();
            sc.nextLine();
            
            if(compra_id!=0){
                int_compraDAO Int_compraDao=new int_compraDAO();
                ArrayList<int_compra>Int_compra=Int_compraDao.getListint_compras(compra_id);
                
                   System.out.println("Alias: ");
                   String alias=sc.nextLine();
                   System.out.println("Fabricante: ");
                   String fabricante= sc.nextLine();
                   System.out.println("Fecha y hora: ");
                   String fecha_hora=sc.nextLine();
                   
                   int_compra NvInt_compra=new int_compra(compra_id, alias,
                           fabricante, fecha_hora);

                    if(Int_compraDao.updateint_compra(NvInt_compra)==1){
                            System.out.println("Intencion de compra actualizada con exito");
                    }else{
                            System.out.println("Error al actualizar los datos de la intencion de compra");
                    }
            }
            
        }while(compra_id!=0);
    }
    
    private void deleteInt_compra(){
        
        int compra_id;
        do{
            System.out.println("BORRAR DATOS DE UNA INTENCION DE COMPRA");
            System.out.println("[Para finalizar proceso presione 0]"
                    + " ó INGRESE ID: ");
            compra_id=sc.nextInt();
            sc.nextLine();
            
            if(compra_id!=0){
                int_compraDAO Int_compraDao=new int_compraDAO();
                ArrayList<int_compra>Int_compra=Int_compraDao.getListint_compras(compra_id);
                    
                    if(Int_compraDao.deleteint_compra(compra_id)==1){
                            System.out.println("Datos de intencion de compra borrados con exito");
                    }else{
                            System.out.println("Error al borrar datos de la intencion de compra");
                    }
            }
       
            
        }while(compra_id!=0);
        
    }
    
    private void listInt_compra(){
        int_compraDAO Int_compraDao=new int_compraDAO();
        ArrayList<int_compra>listint_compra=Int_compraDao.getListint_compras(0);
        System.out.println("LISTADO INTENCION DE COMPRA");
        System.out.println("ID\tALIAS\tFABRICANTE\tFECHA Y HORA");
        for(int_compra Int_compra:listint_compra){
            System.out.println(Int_compra.getCompra_id()+"\t"+
                    Int_compra.getAlias()+"\t"+
                    Int_compra.getFabricante()+"\t"+
                    Int_compra.getFecha_hora());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
}
