/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.TravelAgent.Restaurant;

import dal.RestaurantDAO;
import dal.TourDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Restaurant;
import model.Tour;

/**
 *
 * @author tuanj
 */
@WebServlet(name = "Update_One_Restaurant", urlPatterns = {"/Update_One_Restaurant"})
public class Update_One_Restaurant extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update_One_Restaurant</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update_One_Restaurant at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String name = request.getParameter("rname");

        RestaurantDAO dao = new RestaurantDAO();
        Restaurant t = dao.getOne(name);

        request.setAttribute("update_restaurant", t);
        request.getRequestDispatcher("updateRes.jsp").forward(request, response);
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
        try {
            String restaurant_name = request.getParameter("restaurant_name");
            int service_category_id = Integer.parseInt(request.getParameter("service_category_id"));
            String time_open = request.getParameter("time_open");
            String time_close = request.getParameter("time_close");
            String description = request.getParameter("description");
            String image = request.getParameter("image");

            Restaurant res = new Restaurant();
            res.setRestaurant_name(restaurant_name);
            res.setService_category_id(service_category_id);
            res.setTime_open(time_open);
            res.setTime_close(time_close);
            res.setDescription(description);
            res.setImage(image);

            RestaurantDAO restaurantDAO = new RestaurantDAO();
            boolean isSuccess = restaurantDAO.editRestaurant(res);

            response.sendRedirect("List_Restaurant_TravelAgent");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
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
