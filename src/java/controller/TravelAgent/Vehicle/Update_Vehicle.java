/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.TravelAgent.Vehicle;

import dal.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

@WebServlet(name = "Update_Vehicle", urlPatterns = {"/Update_Vehicle"})
public class Update_Vehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("vid"));
        VehicleDAO dao = new VehicleDAO();
        Vehicle v = dao.getOne(id);
        request.setAttribute("update", v);
        request.getRequestDispatcher("UpdateVehicle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
            String vehicle_name = request.getParameter("vehicle_name");
            int service_category_id = Integer.parseInt(request.getParameter("service_category_id"));
            String vehicle_type = request.getParameter("vehicle_type");
            int number_seat = Integer.parseInt(request.getParameter("number_seat"));
            String phone = request.getParameter("phone");

            // Create Tour object
            
            Vehicle v = new Vehicle();
            
                        v.setVehicle_id(vehicle_id);

            
            v.setVehicle_name(vehicle_name);
            v.setNumber_seat(number_seat);
            v.setPhone(phone);
            v.setService_category_id(service_category_id);
            v.setVehicle_type(vehicle_type);
            VehicleDAO vehicle = new VehicleDAO();
            vehicle.editVehicle(v);
            response.sendRedirect("List_Vehicle_TravelAgent");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
