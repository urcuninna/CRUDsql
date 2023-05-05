/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class moto_electricas {
    private int moto_id;
    private String moto_fabricante;
    private int moto_precio;
    private String moto_autonomia;
    private int prov_id;
    
    public moto_electricas() {
        this.moto_id = 0;
        this.moto_fabricante = "";
        this.moto_precio = 0;
        this.moto_autonomia = "";
        this.prov_id = 0;
    }

    public moto_electricas(int moto_id, String moto_fabricante, int moto_precio, String moto_autonomia, int prov_id) {
        this.moto_id = moto_id;
        this.moto_fabricante = moto_fabricante;
        this.moto_precio = moto_precio;
        this.moto_autonomia = moto_autonomia;
        this.prov_id = prov_id;
    }

    public int getMoto_id() {
        return moto_id;
    }

    public void setMoto_id(int moto_id) {
        this.moto_id = moto_id;
    }

    public String getMoto_fabricante() {
        return moto_fabricante;
    }

    public void setMoto_fabricante(String moto_fabricante) {
        this.moto_fabricante = moto_fabricante;
    }

    public int getMoto_precio() {
        return moto_precio;
    }

    public void setMoto_precio(int moto_precio) {
        this.moto_precio = moto_precio;
    }

    public String getMoto_autonomia() {
        return moto_autonomia;
    }

    public void setMoto_autonomia(String moto_autonomia) {
        this.moto_autonomia = moto_autonomia;
    }

    public int getProv_id() {
        return prov_id;
    }

    public void setProv_id(int prov_id) {
        this.prov_id = prov_id;
    }
    
    
    
}
