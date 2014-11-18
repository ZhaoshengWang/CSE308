/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**This Servlet is used when a user enter all the required field of creating a class
 * and click on the "create course" button, then all the input will create a new course in the database
 * 
 *
 * @author Guoliang Zhong
 */
@WebServlet(name = "CreateCourseServlet", urlPatterns = {"/CreateCourse"})
public class CreateCourseServlet extends HttpServlet {

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
        try  (PrintWriter out = response.getWriter()){
            //Get the user input of course code and course name
            String code = (String) request.getParameter("code");
            String name = (String) request.getParameter("name");
            String instructor_id = (String) request.getParameter("instructor_id");
            
            
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet result = null;
            //query
            try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                String dbURL = "jdbc:derby://localhost:1527/sun-appserv-samples";//;create=true"
                Properties property = new Properties();
                property.put("create", "true");

                conn = DriverManager.getConnection(dbURL, property); //Properties property = new Properties(); property.put("create", "true"); "user" "root"
                if (conn!=null){
                    String query;
            
         
                    //Set instructor to new Course
                    
            
                    /*
                    To import roster, not sure how to do it. Do we check the database to find students who register
                    this new course and add all of them to the roster of this course?
                    */
            
                
                    //Set roster to new Course
                    
            
            
                    //Add newCouse to database
                    query = "INSERT INTO Course VALUES('" + code + "','" + name + "','" 
                            + instructor_id+"')";
                  
                    
                    stmt = conn.prepareStatement(query);
                    result = stmt.executeQuery();
                    
                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                   
                }
            }
            catch (SQLException ex) {
                    ex.printStackTrace();
            }
            
        }
        catch (Exception ex) {
            throw new ServletException(ex);
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
