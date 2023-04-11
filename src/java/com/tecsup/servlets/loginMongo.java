package com.tecsup.servlets;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginMongo extends HttpServlet {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> usersCollection;

    @Override
    public void init() throws ServletException {
        
        // Inicializar la conexión a la base de datos
        mongoClient = new MongoClient("localhost", 27017);
        mongoDatabase = mongoClient.getDatabase("user");
        usersCollection = mongoDatabase.getCollection("users");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Buscar al usuario en la base de datos
        Document user = usersCollection.find(Filters.eq("username", username)).first();

        if (user != null && user.getString("password").equals(password)) {
            // Inicio de sesión exitoso
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/WebApp03/dashboard.jsp");
        } else {
            // Credenciales incorrectas
            response.sendRedirect("loginMongo.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Mostrar el formulario de inicio de sesión
        request.getRequestDispatcher("/WebApp03/loginMongo.jsp").forward(request, response);
    }
}
