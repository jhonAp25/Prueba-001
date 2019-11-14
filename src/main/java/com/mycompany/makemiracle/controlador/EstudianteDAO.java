package com.mycompany.makemiracle.controlador;

import com.mycompany.makemiracle.interfaces.IEstudiante;
import com.mycompany.makemiracle.modelo.Estudiante;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUSTINIANO-PC
 */
public class EstudianteDAO implements IEstudiante {

    Connection con = Conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public ArrayList<Estudiante> listar() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String sql = "select* from estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante p = new Estudiante();
                p.setEst_cod(rs.getInt(1));
                p.setEst_dni(rs.getString(2));
                p.setEst_apellidos(rs.getString(3));
                p.setEst_nombres(rs.getString(4));
                p.setEst_sexo(rs.getString(5));
                p.setEst_fecnac(rs.getString(6));
                p.setEst_direccion(rs.getString(7));
                p.setEst_telefono(rs.getString(8));
                p.setEst_correo(rs.getString(9));
                p.setDist_id(rs.getInt(10));
                p.setEstado(rs.getString(11));
                lista.add(p);
            }
        } catch (Exception e) {
        }

        return lista;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) {
        try {
            String sql = "update  Estudiante set estado='INACTIVO'  WHERE est_cod =" + id;
            boolean f;
            int fila;

            ps = con.prepareStatement(sql);

            fila = ps.executeUpdate();
            if (fila == 1) {
                f = true;
            } else {
                f = false;
            }

            return f;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

        }

    }
//        public static void main(String[] args) {
//        EstudianteDAO d = new EstudianteDAO();
//        
//        
//       if( d.Eliminar(2)){
//            System.out.println("exito");
//       }
//       else{
//            System.out.println("ERROR");}
//       }
//        

    @Override
    public int Actualizar(Estudiante est) {

        try {
            String sql = "UPDATE `bd_becas1`.`estudiante` SET `est_dni` = ?,`est_apellidos` = ?,`est_nombres` = ?,`est_sexo` = ?,`est_fecnac` =?,`est_direccion` =?,`est_telefono` =?,`est_correo` = ?,`dist_id` =?,`estado` = ? WHERE `est_cod` = ?";
            int filas;

            ps = con.prepareStatement(sql);
            ps.setString(1, est.getEst_dni());
            ps.setString(2, est.getEst_apellidos());
            ps.setString(3, est.getEst_nombres());
            ps.setString(4, est.getEst_sexo());
            ps.setString(5, est.getEst_fecnac());
            ps.setString(6, est.getEst_direccion());
            ps.setString(7, est.getEst_telefono());
            ps.setString(8, est.getEst_correo());
            ps.setInt(9, est.getDist_id());
            ps.setString(10, est.getEstado());
            ps.setInt(11, est.getEst_cod());

            filas = ps.executeUpdate();

            return filas;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            
        }
    }

    @Override
    public int Agregar(Estudiante est) {
            try {
            String sql = "insert into estudiante values(null,?,?,?,?,?,?,?,?,?,?)";
            int filas;
           
            ps = con.prepareStatement(sql);
            
            ps.setString(1, est.getEst_dni());
            ps.setString(2, est.getEst_apellidos());
            ps.setString(3, est.getEst_nombres());
            ps.setString(4, est.getEst_sexo());
            ps.setString(5, est.getEst_fecnac());
            ps.setString(6, est.getEst_direccion());
            ps.setString(7, est.getEst_telefono());
            ps.setString(8, est.getEst_correo());
            ps.setInt(9, est.getDist_id());
            ps.setString(10, est.getEstado());

            filas = ps.executeUpdate();
            
            return filas;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
           
        }
         }

//    public static void main(String[] args) {
//        EstudianteDAO d = new EstudianteDAO();
//        Estudiante m = new Estudiante( 1,"75680099", "gaaaa", "gaaa", "M", "2000-05-05", "mariscal caceres", "986548756", "apza@gmail.com", 1, "ACTIVO");
//        
//        d.Actualizar(m);
//        System.out.println("Exito");
//    }
    
    @Override
    public ArrayList<Estudiante> listarId(int id) {
        try {
            ArrayList<Estudiante> lista = new ArrayList<>();
            String sql = "SELECT * FROM Estudiante WHERE est_cod = " + id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante p = new Estudiante();
                p.setEst_cod(rs.getInt(1));
                p.setEst_dni(rs.getString(2));
                p.setEst_apellidos(rs.getString(3));
                p.setEst_nombres(rs.getString(4));
                p.setEst_sexo(rs.getString(5));
                p.setEst_fecnac(rs.getString(6));
                p.setEst_direccion(rs.getString(7));
                p.setEst_telefono(rs.getString(8));
                p.setEst_correo(rs.getString(9));
                p.setDist_id(rs.getInt(10));
                p.setEstado(rs.getString(11));
                lista.add(p);
            } return lista;
        } catch (Exception e) {
        }
        return null;

       
    }

}
