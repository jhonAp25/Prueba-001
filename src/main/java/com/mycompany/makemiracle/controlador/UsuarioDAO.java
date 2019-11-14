/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makemiracle.controlador;

import com.mycompany.makemiracle.interfaces.IUsuario;
import com.mycompany.makemiracle.modelo.Estudiante;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements IUsuario{
     Connection con = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public int autenticacion(String user, String pass ) {
       
       
           PreparedStatement ps=null;
        ResultSet rs = null;
        
        try {
//            String s="SELECT * from usuario WHERE usu_usuario=? and  (aes_decrypt(CLAVE_CLI,'aes')) =?";
         String s="SELECT * from usuario WHERE usu_usuario=? and usu_contraseña =?";
            ps  = con.prepareStatement(s);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery(); //Guardo mi consulta en el resultset            
            if(rs.absolute(1)){ //Si existe un registro retorname true;
                return 1;
            }            
        } catch (Exception e) {
            System.err.println("Error"+e);
        } finally{
            try {
                if (con!=null);
                if(ps!=null)ps.close();
                if(rs!=null)rs.close();
            } catch (Exception e) {
                System.err.println("Error"+e);
            }
        }        
        return 0;
    }

   

}
