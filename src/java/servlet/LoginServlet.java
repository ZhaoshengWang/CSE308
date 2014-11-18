/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String id = request.getParameter("id");
                String pw = request.getParameter("pw");
                /*for (Cookie cookie : cookies) {
                 if (cookie.getName().equals("id")) {
                 id = cookie.getValue();
                 } else if (cookie.getName().equals("pw")) {
                 pw = cookie.getValue();
                 }
                 }*/
                if (id == null || pw == null) {
                       
                }
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet result = null;
                try {
                    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                    String dbURL = "jdbc:derby://localhost:1527/sun-appserv-samples";//;create=true"
                    Properties property = new Properties();
                    property.put("create", "true");
        
                    conn = DriverManager.getConnection(dbURL, property); //Properties property = new Properties(); property.put("create", "true"); "user" "root"
                      
                    if (conn != null) {
                        out.println("Connected");
                        String query = "select * from users where users.ID=? and users.PASSWORD=?";
                        stmt = conn.prepareStatement(query);
                        stmt.setString(1, id);
                        stmt.setString(2, pw);
                        
                        result = stmt.executeQuery();
                        if (result != null) {
                            response.addCookie(new Cookie("user", id));
                            response.addCookie(new Cookie("password", pw));
                            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                            rd.forward(request, response);
                            
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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

}
