/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makemiracle.Servlet;

import com.mycompany.makemiracle.controlador.EstudianteDAO;
import com.mycompany.makemiracle.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author JUSTINIANO-PC
 */
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    EstudianteDAO model = new EstudianteDAO();
    Estudiante est = new Estudiante();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        {
            PrintWriter out = response.getWriter();
            try {
                String operacion = request.getParameter("op");

                switch (operacion) {
                    case "listar":
                        Listar(request, response);
                        break;
                    case "listarID":
                        ListarID(request, response);
                        break;
                    case "insertar":
                        Insertar(request, response);
                        break;
                    case "actualizar":
                        Actualizar(request, response);
                        break;
                    case "eliminar":
                        Eliminar(request, response);
                        break;
                }
            } finally {
                out.close();
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void Listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
   PrintWriter out = response.getWriter();
        try {
         

            JSONArray array = new JSONArray();
            for (Estudiante est : model.listar()) {
                JSONObject json = new JSONObject();
                json.put("id", est.getEst_cod());
                json.put("dni", est.getEst_dni());
                json.put("apellido", est.getEst_apellidos());
                json.put("nombres", est.getEst_nombres());
                json.put("sexo", est.getEst_sexo());
                json.put("fechaNac", est.getEst_fecnac());
                json.put("direc", est.getEst_direccion());
                json.put("telefono", est.getEst_telefono());
                json.put("correo", est.getEst_correo());
                json.put("idDist", est.getDist_id());
                json.put("estado", est.getEstado());
                array.add(json);
            };

            out.print(array);
        } catch (Exception ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void Insertar(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
//
//            int isEst = Integer.parseInt(request.getParameter("idEstado"));
            String dni = request.getParameter("dni");
            String apellido = request.getParameter("apellidos");
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            String fechaNac = request.getParameter("fechaNac");
            String direc = request.getParameter("direccion");
            String telef = request.getParameter("telefono");
            String correo = request.getParameter("correo");

            int distId = Integer.parseInt(request.getParameter("idDist"));
            String estado = request.getParameter("estado");

            est = new Estudiante( dni, apellido, nombre, sexo, fechaNac, direc, telef, correo, distId, estado);
            
//             est = new Estudiante("75680099", "apaza", "jhon", "M", "2000-05-05", "mariscal caceres", "986548756", "apza@gmail.com", 1, "ACTIVO");


            int filas = model.Agregar(est);

            if (filas != 0) { //EXITO
                out.print("EXITO");
            } else {
                out.print("ERROR");
            }

        } catch (Exception ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);

            out.print(ex.getMessage());
        }
    }

    private void Actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
          PrintWriter out = response.getWriter();
        try { 
         
           int isEst = Integer.parseInt(request.getParameter("id"));
            String dni = request.getParameter("dni");
            String apellido = request.getParameter("apellidos");
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            String fechaNac = request.getParameter("fechaNac");
            String direc = request.getParameter("direccion");
            String telef = request.getParameter("telefono");
            String correo = request.getParameter("correo");

            int distId = Integer.parseInt(request.getParameter("idDist"));
            String estado = request.getParameter("estado");

           Estudiante est = new Estudiante(isEst, dni, apellido, nombre, sexo, fechaNac, direc, telef, correo, distId, estado);
         
        // est = new Estudiante( 1,"75680099", "apaza", "jhon", "M", "2000-05-05", "mariscal caceres", "986548756", "apza@gmail.com", 1, "ACTIVO");


            int filas = model.Actualizar(est);

            if (filas != 0) { //EXITO
                out.print("EXITO");
            } else {
                out.print("ERROR");
            }

        } catch (Exception ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
      
            out.print(ex.getMessage());
        }
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response) {

        try {
            PrintWriter out = response.getWriter();

            int id = Integer.parseInt(request.getParameter("id"));

            boolean filas = model.Eliminar(id);

            if (filas == true) { //EXITO

                out.print("EXITO");
            } else {
                out.print("ERROR");
            }

        } catch (Exception ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ListarID(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));

            JSONArray array = new JSONArray();
            for (Estudiante est : model.listarId(id)) {
                JSONObject json = new JSONObject();
                json.put("id", est.getEst_cod());
                json.put("dni", est.getEst_dni());
                json.put("apellido", est.getEst_apellidos());
                json.put("nombres", est.getEst_nombres());
                json.put("sexo", est.getEst_sexo());
                json.put("fechaNac", est.getEst_fecnac());
                json.put("direc", est.getEst_direccion());
                json.put("telefono", est.getEst_telefono());
                json.put("correo", est.getEst_correo());
                json.put("idDist", est.getDist_id());
                json.put("estado", est.getEstado());
                array.add(json);
            };

            out.print(array);
        } catch (Exception ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
