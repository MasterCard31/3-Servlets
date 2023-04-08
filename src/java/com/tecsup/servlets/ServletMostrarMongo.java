/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tecsup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
/**
 *
 * @author carlo
 */
@WebServlet(name = "ServletMostrarMongo", urlPatterns = {"/ServletMostrarMongo"})
public class ServletMostrarMongo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            // Conexión a la base de datos
            MongoClient m = new  MongoClient("localhost",27017);
            DB db = m.getDB("test");
            DBCollection tabla = db.getCollection("cargos");
            DBCursor cursor = tabla.find();
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        try
        { 
            // Procesar los resultados y mostrarlos en la página web
            PrintWriter out = response.getWriter();
            
            /* TODO output your page here. You may use following sample code. */
            //Desplegar los datos del registro actual en el navegador
            out.println(" </FONT> </b> <br> </center> ");
            out.println("<br> ");
            out.println("<table align='center' width='60%' border='1' cellpadding='0' cellspacing='0'>  ");
            out.println("<tr> ");
            out.println("<td> ");
            out.println("<table width='100%' align='center' border='0' cellpadding='0' cellspacing='0'> ");
            out.println(" <tr bgcolor='#CCFF66' >");
            //Columnas de la tabla cargos de la BD
            out.println(" </tr>");
            while (cursor.hasNext()) {
                //Mostrar los datos del registro actual en el navegador
                out.println(" <td>"+ cursor.next()+" </td>");
            }
            out.println("</table>");
            out.println("</td> ");
            out.println("</tr> ");
            out.println("</table>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
        }catch (IOException e) {
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

}
