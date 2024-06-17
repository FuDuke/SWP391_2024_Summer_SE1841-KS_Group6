/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Admin;

import dal.TourDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tour;

/**
 *
 * @author tuanj
 */
@WebServlet(name="Add_One_Tour", urlPatterns={"/Add_One_Tour"})
public class Add_One_Tour extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add_One_Tour</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add_One_Tour at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String tour_name = request.getParameter("tour_name");
        String description = request.getParameter("description");
        float deposit = Float.parseFloat(request.getParameter("deposit"));
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String min_child = request.getParameter("min_child");
        String max_child = request.getParameter("max_child");
        String min_adult = request.getParameter("min_adult");
        String max_adult = request.getParameter("max_adult");
        int total_price = Integer.parseInt(request.getParameter("total_price"));
        String number_day = request.getParameter("number_day");
        int tour_category_id = Integer.parseInt(request.getParameter("tour_category_id"));

        // Create Tour object
        Tour tour = new Tour();
        tour.setTour_name(tour_name);
        tour.setDescription(description);
        tour.setDeposit(deposit);
        tour.setStart_date(start_date);
        tour.setEnd_date(end_date);
        tour.setMin_child(min_child);
        tour.setMax_child(max_child);
        tour.setMin_adult(min_adult);
        tour.setMax_adult(max_adult);
        tour.setTotal_price(total_price);
        tour.setNumber_day(number_day);
        
        tour.setTour_catetgory_id(tour_category_id);

        // Add tour to the database
        TourDAO tourDAO = new TourDAO();
        boolean isSuccess = tourDAO.addTour(tour);

        // Forward to a success page or show an error message
        if (isSuccess) {
            request.setAttribute("message", "Tour added successfully!");
            
        } else {
            request.setAttribute("message", "Failed to add tour. Please try again.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
