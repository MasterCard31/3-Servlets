/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tecsup.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author carlo
 */
@WebServlet(name = "ServletMostrar", urlPatterns = {"/ServletMostrar"})
public class ServletMostrar extends HttpServlet {

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
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "tecsup";
        
        response.setContentType("text/html;charset=UTF-8");
        
        try 
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            
            // Consulta SQL para obtener los datos
            String sql = "SELECT * FROM areas";

            // Ejecutar la consulta SQL y obtener los resultados
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Procesar los resultados y mostrarlos en la página web
            PrintWriter out = response.getWriter();
            
            //Desplegar los datos del registro actual en el navegador
            out.println(" </FONT> </b> <br> </center> ");
            out.println("<br> ");
            out.println("<table align='center' width='60%' border='1' cellpadding='0' cellspacing='0'>  ");
            out.println("<tr> ");
            out.println("<td> ");
            out.println("<table width='100%' align='center' border='0' cellpadding='0' cellspacing='0'> ");
            out.println(" <tr bgcolor='#CCFF66' >");
            //Columnas de la tabla de la BD
            out.println("<td align='center width='20%' > <b> Código </b> </td>  ");
            out.println("<td align='left' width='35%' > <b> Nombre </b> </td> ");
            out.println("<td align='center' width='35%' > <b> Est. </b> </td>  ");
            out.println(" </tr>");
            while (rs.next()) {
                //Mostrar los datos del registro actual en el navegador
                out.println(" <td>"+ rs.getString("cod")+" </td>");
                out.println(" <td>"+ rs.getString("nom")+"</td>");
                out.println(" <td>"+ rs.getString("est")+"</td>");
                out.println(" </tr>");
            }
            out.println("</table>");
            out.println("</td> ");
            out.println("</tr> ");
            out.println("</table>");
            out.println("<br><br>");
            out.println("</body>");
            out.println("</html>");
            
            // Cerrar la conexión a la base de datos
            rs.close();
            stmt.close();
            conn.close();
        
        
        }catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
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
