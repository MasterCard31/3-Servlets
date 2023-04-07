/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecsup.datos;

import java.sql.*;

/**
 *
 * @author carlo
 */
public class cBaseDatos {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/test";
    String usuario = "root";
    String clave = "tecsup";

    public Connection Conectar() {
        try {
            Class.forName(driver);
            Connection xcon = DriverManager.getConnection(url, usuario, clave);
            return xcon;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public boolean validarUsuario(String xcod, String xcla) {
        try {
            Connection xcon = this.Conectar();
            String sql = "select count(*) from t_usuarios where codigo=? AND clave=?";
            PreparedStatement ps = xcon.prepareStatement(sql);
            ps.setString(1, xcod);
            ps.setString(2, xcla);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt(cantidad);
            if (xcant > 0) {
                return true;
            }
            xcon.close();
            return false;
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    } 
    
    
    
    
}
