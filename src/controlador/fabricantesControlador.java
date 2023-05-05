/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import acceso.ClientesDAO;
import java.util.ArrayList;
import java.util.Scanner;
import acceso.fabricantesDAO;
import modelo.*;

public class fabricantesControlador {
    Scanner sc=new Scanner(System.in);
    
    public void gestionfabricantes(){
        int opcion;
        do{
            System.out.println("GESTION DE FABRICANTES".toUpperCase());
            System.out.println("1. Agregar Fabricantes");
            System.out.println("2. Consultar Fabricantes");
            System.out.println("3. Eliminar Fabricantes");
            System.out.println("4. Listar Fabricantes");
            System.out.println("Salir");
            System.out.println("DIGITE UNA OPCION: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:addFabricantes();break;
                case 2:getFabricantes();break;
                case 3:deleteFabricantes();break;  
                case 4:listFabricantes();break;
            }
            
        }while(opcion!=6);
    }
    
    private void addFabricantes(){
        
        String fabricante;
        
        do{
            System.out.println("AGREGAR FABRICANTE");
            System.out.println("INGRESE FABRICANTE: ");
            
            
            fabricante=sc.nextLine();
            if(fabricante!=""){
               fabricantesDAO FabricantesDao=new fabricantesDAO();
               ArrayList<fabricantes>Fabricantes=FabricantesDao.getListfabricante(fabricante);
               if(Fabricantes.size()>0){
                   System.out.println("Fabricante ya registrado");
               }else{
                   fabricantes NFabricantes=new fabricantes(fabricante);
                   
                    if(FabricantesDao.savefabricantes(NFabricantes)==1){
                        System.out.println("Fabricante grabado con exito");
                    }else{
                        System.out.println("Error al grabar el fabricante");
                    }
               }
    int opcion;          
    System.out.println("Presione 0 para salir:");
    opcion=sc.nextInt();
    sc.nextLine();
        if(opcion==0){
            gestionfabricantes();
        }
    
            }
        }while(fabricante!="");
        
    }
    
    private void getFabricantes(){
        
        System.out.println("CONSULTA FABRICANTES");
        System.out.println("Fabricante = ");
        String fabricante=sc.nextLine();
        
        fabricantesDAO FabricantesDao=new fabricantesDAO();
        ArrayList<fabricantes>listfabricantes=FabricantesDao.getListfabricante(fabricante);

        if(listfabricantes.size()>0){
            
            System.out.println("FABRICANTE");
            for(fabricantes Fabricantes:listfabricantes){
                System.out.println(Fabricantes.getFabricante());
            }
        }else{
            System.out.println("Fabricante no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
        
    }
    
    
    private void deleteFabricantes(){
        
        String fabricante;
        do{
            System.out.println("BORRAR UN FABRICANTE");
            System.out.println("INGRESE FABRICANTE: ");
            fabricante=sc.nextLine();
            
            if(fabricante!=""){
                
                fabricantesDAO FabricantesDao=new fabricantesDAO();
                ArrayList<fabricantes>Fabricantes=FabricantesDao.getListfabricante(fabricante);
                
                    if(FabricantesDao.deletefabricantes(fabricante)==1){
                            System.out.println("Fabricante borrado con exito");
                    }else{
                            System.out.println("Error al borrar el Fabricante");
                    }
            }
    int opcion;          
    System.out.println("Presione 0 para salir:");
    opcion=sc.nextInt();
    sc.nextLine();
        if(opcion==0){
            gestionfabricantes();
        }        

        }while(fabricante!="");
        
    }
    
    private void listFabricantes(){
        
        fabricantesDAO FabricantesDao=new fabricantesDAO();
        ArrayList<fabricantes>listfabricantes=FabricantesDao.getListfabricante("");
        
        System.out.println("LISTADO FABRICANTES");
        System.out.println("FABRICANTE");
        for(fabricantes Fabricantes:listfabricantes){
            System.out.println(Fabricantes.getFabricante());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
    }
}
