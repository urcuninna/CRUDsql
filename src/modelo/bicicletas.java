/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class bicicletas {
    private int bici_id;
    private String fabricante;
    private int bici_precio;
    private String bici_año;
    
    public bicicletas() {
        this.bici_id = 0;
        this.fabricante = "";
        this.bici_precio = 0;
        this.bici_año = "";
    }
    
    public bicicletas(int bici_id, String fabricante, int bici_precio, String bici_año) {
        this.bici_id = bici_id;
        this.fabricante = fabricante;
        this.bici_precio = bici_precio;
        this.bici_año = bici_año;
    }

    public int getBici_id() {
        return bici_id;
    }

    public void setBici_id(int bici_id) {
        this.bici_id = bici_id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getBici_precio() {
        return bici_precio;
    }

    public void setBici_precio(int bici_precio) {
        this.bici_precio = bici_precio;
    }

    public String getBici_año() {
        return bici_año;
    }

    public void setBici_año(String bici_año) {
        this.bici_año = bici_año;
    }
    
}
