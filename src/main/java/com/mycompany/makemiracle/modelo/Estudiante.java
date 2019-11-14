package com.mycompany.makemiracle.modelo;

public class Estudiante {
    private int est_cod;
    private String est_dni;
    private String est_apellidos;
    private String est_nombres;
    private String est_sexo;
    private String est_fecnac;
    private String est_direccion;
    private String est_telefono;
    private String est_correo;
    private int dist_id;
    private String estado;

    public Estudiante() {
    }

    public Estudiante(int est_cod, String est_dni, String est_apellidos, String est_nombres, String est_sexo, String est_fecnac, String est_direccion, String est_telefono, String est_correo, int dist_id, String estado) {
        this.est_cod = est_cod;
        this.est_dni = est_dni;
        this.est_apellidos = est_apellidos;
        this.est_nombres = est_nombres;
        this.est_sexo = est_sexo;
        this.est_fecnac = est_fecnac;
        this.est_direccion = est_direccion;
        this.est_telefono = est_telefono;
        this.est_correo = est_correo;
        this.dist_id = dist_id;
        this.estado = estado;
    }

    public Estudiante(String est_dni, String est_apellidos, String est_nombres, String est_sexo, String est_fecnac, String est_direccion, String est_telefono, String est_correo, int dist_id, String estado) {
        this.est_dni = est_dni;
        this.est_apellidos = est_apellidos;
        this.est_nombres = est_nombres;
        this.est_sexo = est_sexo;
        this.est_fecnac = est_fecnac;
        this.est_direccion = est_direccion;
        this.est_telefono = est_telefono;
        this.est_correo = est_correo;
        this.dist_id = dist_id;
        this.estado = estado;
    }
    

    public int getEst_cod() {
        return est_cod;
    }

    public void setEst_cod(int est_cod) {
        this.est_cod = est_cod;
    }

    public String getEst_dni() {
        return est_dni;
    }

    public void setEst_dni(String est_dni) {
        this.est_dni = est_dni;
    }

    public String getEst_apellidos() {
        return est_apellidos;
    }

    public void setEst_apellidos(String est_apellidos) {
        this.est_apellidos = est_apellidos;
    }

    public String getEst_nombres() {
        return est_nombres;
    }

    public void setEst_nombres(String est_nombres) {
        this.est_nombres = est_nombres;
    }

    public String getEst_sexo() {
        return est_sexo;
    }

    public void setEst_sexo(String est_sexo) {
        this.est_sexo = est_sexo;
    }

    public String getEst_fecnac() {
        return est_fecnac;
    }

    public void setEst_fecnac(String est_fecnac) {
        this.est_fecnac = est_fecnac;
    }

    public String getEst_direccion() {
        return est_direccion;
    }

    public void setEst_direccion(String est_direccion) {
        this.est_direccion = est_direccion;
    }

    public String getEst_telefono() {
        return est_telefono;
    }

    public void setEst_telefono(String est_telefono) {
        this.est_telefono = est_telefono;
    }

    public String getEst_correo() {
        return est_correo;
    }

    public void setEst_correo(String est_correo) {
        this.est_correo = est_correo;
    }

    public int getDist_id() {
        return dist_id;
    }

    public void setDist_id(int dist_id) {
        this.dist_id = dist_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}
