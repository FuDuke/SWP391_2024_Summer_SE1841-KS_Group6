package controller.Admin;

import dal.TourDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.Tour;

@WebServlet(name = "Update_One_Tour", urlPatterns = {"/Update_One_Tour"})
public class Update_One_Tour extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update_One_Tour</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update_One_Tour at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("tname");

        TourDAO dao = new TourDAO();
        Tour t = dao.getOne(name);
        
        request.setAttribute("update", t);
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tour_name = request.getParameter("tour_name");
            String description = request.getParameter("description");
            float deposit = Float.parseFloat(request.getParameter("deposit"));
            String startDate = request.getParameter("start_date");
            String endDate = request.getParameter("end_date");
            String min_child = request.getParameter("min_child");
            String max_child = request.getParameter("max_child");
            String min_adult = request.getParameter("min_adult");
            String max_adult = request.getParameter("max_adult");
            int total_price = Integer.parseInt(request.getParameter("total_price"));
            String number_day = request.getParameter("number_day");
            int tour_category_id = Integer.parseInt(request.getParameter("tour_category_id"));
            String image = request.getParameter("image");
            
            Tour tour = new Tour();
            tour.setTour_name(tour_name);
            tour.setDescription(description);
            tour.setDeposit(deposit);
            tour.setStart_date(startDate);
            tour.setEnd_date(endDate);
            tour.setMin_child(min_child);
            tour.setMax_child(max_child);
            tour.setMin_adult(min_adult);
            tour.setMax_adult(max_adult);
            tour.setTotal_price(total_price);
            tour.setNumber_day(number_day);
            tour.setTour_catetgory_id(tour_category_id);
            tour.setImage(image);
            TourDAO tourDB = new TourDAO();
            tourDB.editTour(tour);
            
            response.sendRedirect("List_Tour_Admin");
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
