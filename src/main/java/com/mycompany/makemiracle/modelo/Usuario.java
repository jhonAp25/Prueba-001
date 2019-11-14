    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makemiracle.modelo;

public class Usuario {

 private int usu_Id;
    private String usu_nombre;
    private String usu_apellido;
    private String usu_dni;
    private String usu_usuario;
    private String usu_contraseña;
    private String usu_correo;
    private String usu_telefono;
    private String usu_sexo;
    private String ciu_id;
    private String idTipoEm;

    public Usuario(int usu_Id, String usu_nombre, String usu_apellido, String usu_dni, String usu_usuario, String usu_contraseña, String usu_correo, String usu_telefono, String usu_sexo, String ciu_id, String idTipoEm) {
        this.usu_Id = usu_Id;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_dni = usu_dni;
        this.usu_usuario = usu_usuario;
        this.usu_contraseña = usu_contraseña;
        this.usu_correo = usu_correo;
        this.usu_telefono = usu_telefono;
        this.usu_sexo = usu_sexo;
        this.ciu_id = ciu_id;
        this.idTipoEm = idTipoEm;
    }

    public Usuario() {
    }

    public Usuario(String usu_usuario, String usu_contraseña) {
        this.usu_usuario = usu_usuario;
        this.usu_contraseña = usu_contraseña;
    }
    

    public int getUsu_Id() {
        return usu_Id;
    }

    public void setUsu_Id(int usu_Id) {
        this.usu_Id = usu_Id;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public String getUsu_dni() {
        return usu_dni;
    }

    public void setUsu_dni(String usu_dni) {
        this.usu_dni = usu_dni;
    }

    public String getUsu_usuario() {
        return usu_usuario;
    }

    public void setUsu_usuario(String usu_usuario) {
        this.usu_usuario = usu_usuario;
    }

    public String getUsu_contraseña() {
        return usu_contraseña;
    }

    public void setUsu_contraseña(String usu_contraseña) {
        this.usu_contraseña = usu_contraseña;
    }

    public String getUsu_correo() {
        return usu_correo;
    }

    public void setUsu_correo(String usu_correo) {
        this.usu_correo = usu_correo;
    }

    public String getUsu_telefono() {
        return usu_telefono;
    }

    public void setUsu_telefono(String usu_telefono) {
        this.usu_telefono = usu_telefono;
    }

    public String getUsu_sexo() {
        return usu_sexo;
    }

    public void setUsu_sexo(String usu_sexo) {
        this.usu_sexo = usu_sexo;
    }

    public String getCiu_id() {
        return ciu_id;
    }

    public void setCiu_id(String ciu_id) {
        this.ciu_id = ciu_id;
    }

    public String getIdTipoEm() {
        return idTipoEm;
    }

    public void setIdTipoEm(String idTipoEm) {
        this.idTipoEm = idTipoEm;
    }

}