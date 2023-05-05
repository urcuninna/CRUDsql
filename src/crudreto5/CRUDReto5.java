/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudreto5;

import java.util.ArrayList;
import acceso.*;
import controlador.*;
import java.util.Scanner;
import modelo.*;

public class CRUDReto5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion;
        System.out.println("A CONTINUACION SELECCIONE UNA DE LAS TABLAS");
        System.out.println("1.PROVEEDOR");
        System.out.println("2.CLIENTES");
        System.out.println("3.FABRICANTES");
        System.out.println("4.BICICLETAS");
        System.out.println("5.MOTOCICLETAS ELECTRICAS");
        System.out.println("6.INTENCION DE COMPRA");
        System.out.println("DE ACUERDO AL NUMERO QUE CORRESPONDA INGRESE LA OPCION: ");
        opcion=sc.nextInt();
        sc.nextLine();
        
        if(opcion==1){
            proveedorControlador pc=new proveedorControlador();
            pc.gestionProveedor();
        }else if(opcion==2){
            ClientesControlador cc=new ClientesControlador();
            cc.gestionClientes();
        }else if(opcion==3){
            fabricantesControlador fc=new fabricantesControlador();
            fc.gestionfabricantes();
        }else if(opcion==4){
            bicicletasControlador bc=new bicicletasControlador();
            bc.gestionBicicletas();
        }else if(opcion==5){
            moto_electricasControlador ec=new moto_electricasControlador();
            ec.gestionMoto_electricas();
        }else if(opcion==6){
            int_compraControlador ic=new int_compraControlador();
            ic.gestionInt_compra();
        }
            
    }   
   
}
