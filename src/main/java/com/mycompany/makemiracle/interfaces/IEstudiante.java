/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makemiracle.interfaces;

import com.mycompany.makemiracle.modelo.Estudiante;
import java.util.ArrayList;


/**
 *
 * @author JUSTINIANO-PC
 */
public interface IEstudiante {
    
    public ArrayList<Estudiante> listar();
    public boolean Eliminar(int id);
    public int Actualizar(Estudiante est);
    public int Agregar(Estudiante est);
    public ArrayList<Estudiante> listarId(int id);
    
}
