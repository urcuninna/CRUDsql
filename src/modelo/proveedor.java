/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Angie
 */
public class proveedor {
    private int prov_id;
    private String prov_nombre;
    private String prov_direccion;
    private String prov_telefono;
    
    public proveedor() {
    this.prov_id = 0;
    this.prov_nombre = "";
    this.prov_direccion = "";
    this.prov_telefono = "";
    }
    
    public proveedor(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        this.prov_id = prov_id;
        this.prov_nombre = prov_nombre;
        this.prov_direccion = prov_direccion;
        this.prov_telefono = prov_telefono;
    }

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }

    public String getProv_nombre() {
        return prov_nombre;
    }

    public void setProv_nombre(String prov_nombre) {
        this.prov_nombre = prov_nombre;
    }

    public String getProv_direccion() {
        return prov_direccion;
    }

    public void setProv_direccion(String prov_direccion) {
        this.prov_direccion = prov_direccion;
    }

    public String getProv_telefono() {
        return prov_telefono;
    }

    public void setProv_telefono(String prov_telefono) {
        this.prov_telefono = prov_telefono;
    }
    
    
    
}
