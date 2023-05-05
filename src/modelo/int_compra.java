/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class int_compra {
    
    private int compra_id;
    private String alias;
    private String fabricante;
    private String fecha_hora;

    public int_compra() {
        this.compra_id = 0;
        this.alias = "";
        this.fabricante = "";
        this.fecha_hora = "";
    }
    
    public int_compra(int compra_id, String alias, String fabricante, String fecha_hora) {
        this.compra_id = compra_id;
        this.alias = alias;
        this.fabricante = fabricante;
        this.fecha_hora = fecha_hora;
    }

    public int getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(int compra_id) {
        this.compra_id = compra_id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    
    
}
