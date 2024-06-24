/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.TravelAgent.Hotel;

import dal.HotelDAO;
import dal.TourDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Hotel;
import model.Tour;

/**
 *
 * @author tuanj
 */
@WebServlet(name = "Update_One_Hotel", urlPatterns = {"/Update_One_Hotel"})
public class Update_One_Hotel extends HttpServlet {

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
            out.println("<title>Servlet Update_One_Hotel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update_One_Hotel at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("hname");

        HotelDAO dao = new HotelDAO();
        Hotel h = dao.getOne(name);
        
        request.setAttribute("update", h);
        request.getRequestDispatcher("updateHotel.jsp").forward(request, response);

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
            String hotel_name = request.getParameter("hotel_name");
            int service_category_id = Integer.parseInt(request.getParameter("service_category_id"));
            float daily_price = Float.parseFloat(request.getParameter("daily_price"));
            float holiday_price = Float.parseFloat(request.getParameter("holiday_price"));

            String number_room = request.getParameter("number_room");
            String number_people = request.getParameter("number_people");
            String description = request.getParameter("description");
            String phone = request.getParameter("phone");
            String image = request.getParameter("image");

            // Create Tour object
            Hotel h = new Hotel();
            h.setHotel_name(hotel_name);
            h.setService_category_id(service_category_id);
            h.setDaily_price(daily_price);
            h.setHoliday_price(holiday_price);
            h.setNumber_room(number_room);
            h.setNumber_people(number_people);
            h.setDescription(description);
            h.setPhone(phone);
            h.setImage(image);
            HotelDAO hotel = new HotelDAO();
            hotel.editHotel(h);
            response.sendRedirect("List_Hotel_TravelAgent");

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
