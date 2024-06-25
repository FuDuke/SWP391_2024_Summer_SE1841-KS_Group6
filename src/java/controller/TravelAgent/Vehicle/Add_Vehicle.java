/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.TravelAgent.Vehicle;

import dal.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author ASUS
 */
//@WebServlet(name = "Add_Vehicle", urlPatterns = {"/Add_Vehicle"})
//public class Add_Vehicle extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Add_Vehicle</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Add_Vehicle at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String vehicle_name = request.getParameter("vehicle_name");
//        int service_category_id = Integer.parseInt(request.getParameter("service_category_id"));
//        String vehicle_type = request.getParameter("vehicle_type");
//        int number_seat = Integer.parseInt(request.getParameter("number_seat"));
//        String phone = request.getParameter("phone");
//
//        // Create Tour object
//        Vehicle v = new Vehicle();
//        v.setVehicle_name(vehicle_name);
//        v.setService_category_id(service_category_id);
//        v.setNumber_seat(number_seat);
//        v.setVehicle_type(vehicle_type);
//        v.setPhone(phone);
//        // Add tour to the database
//        VehicleDAO vehicleDAO = new VehicleDAO();
//        boolean isSuccess = vehicleDAO.addVehicle(v);
//
//        // Forward to a success page or show an error message
////        if (isSuccess) {
////            request.setAttribute("message", "Tour added successfully!");
////
////        } else {
////            request.setAttribute("message", "Failed to add tour. Please try again.");
////        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("travel agent/Vehicle.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}


@WebServlet(name = "Add_Vehicle", urlPatterns = {"/Add_Vehicle"})
public class Add_Vehicle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add_Vehicle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add_Vehicle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vehicle_name = request.getParameter("vehicle_name");
        int service_category_id = Integer.parseInt(request.getParameter("service_category_id"));
        String vehicle_type = request.getParameter("vehicle_type");
        int number_seat = Integer.parseInt(request.getParameter("number_seat"));
        String phone = request.getParameter("phone");

        // Tạo đối tượng Vehicle
        Vehicle v = new Vehicle();
        v.setVehicle_name(vehicle_name);
        v.setService_category_id(service_category_id);
        v.setNumber_seat(number_seat);
        v.setVehicle_type(vehicle_type);
        v.setPhone(phone);

        // Thêm vehicle vào cơ sở dữ liệu
        VehicleDAO vehicleDAO = new VehicleDAO();
        boolean isSuccess = vehicleDAO.addVehicle(v);

        // Thiết lập thông điệp kết quả
        if (isSuccess) {
            request.setAttribute("message", "Vehicle added successfully!");
        } else {
            request.setAttribute("message", "Failed to add vehicle. Please try again.");
        }

        // Chuyển tiếp yêu cầu đến trang kết quả
        RequestDispatcher dispatcher = request.getRequestDispatcher("List_Vehicle_TravelAgent");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
