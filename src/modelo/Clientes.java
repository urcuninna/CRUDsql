/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Clientes {
    private String alias;
    private String clnt_nombre;
    private String clnt_apellidos;
    private String clnt_email;
    private String clnt_celular;
    private String clnt_fNacimiento;
    private int clnt_contraseña;
    
    public Clientes( ) {
        this.alias = "";
        this.clnt_nombre = "";
        this.clnt_apellidos = "";
        this.clnt_email = "";
        this.clnt_celular = "";
        this.clnt_fNacimiento = "";
        this.clnt_contraseña = 0;
    }
    
    public Clientes(String alias, String clnt_nombre, String clnt_apellidos, String clnt_email, String clnt_celular, String clnt_fNacimiento, int clnt_contraseña) {
        this.alias = alias;
        this.clnt_nombre = clnt_nombre;
        this.clnt_apellidos = clnt_apellidos;
        this.clnt_email = clnt_email;
        this.clnt_celular = clnt_celular;
        this.clnt_fNacimiento = clnt_fNacimiento;
        this.clnt_contraseña = clnt_contraseña;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClnt_nombre() {
        return clnt_nombre;
    }

    public void setClnt_nombre(String clnt_nombre) {
        this.clnt_nombre = clnt_nombre;
    }

    public String getClnt_apellidos() {
        return clnt_apellidos;
    }

    public void setClnt_apellidos(String clnt_apellidos) {
        this.clnt_apellidos = clnt_apellidos;
    }

    public String getClnt_email() {
        return clnt_email;
    }

    public void setClnt_email(String clnt_email) {
        this.clnt_email = clnt_email;
    }

    public String getClnt_celular() {
        return clnt_celular;
    }

    public void setClnt_celular(String clnt_celular) {
        this.clnt_celular = clnt_celular;
    }

    public String getClnt_fNacimiento() {
        return clnt_fNacimiento;
    }

    public void setClnt_fNacimiento(String clnt_fNacimiento) {
        this.clnt_fNacimiento = clnt_fNacimiento;
    }

    public int getClnt_contraseña() {
        return clnt_contraseña;
    }

    public void setClnt_contraseña(int clnt_contraseña) {
        this.clnt_contraseña = clnt_contraseña;
    }
    
    
    
}
