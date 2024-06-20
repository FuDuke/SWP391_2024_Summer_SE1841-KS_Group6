/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.repo.RestaurantRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hotel;
import model.Restaurant;

/**
 *
 * @author tuanj
 */
public class RestaurantDAO extends DBContext implements RestaurantRepo {

    @Override
    public ArrayList<Restaurant> getList() {
        ArrayList<Restaurant> list = new ArrayList<>();
        try {
            String sql = "select * from Restaurant";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Restaurant t = new Restaurant();
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setRestaurant_name(rs.getString("restaurant_name"));
                t.setTime_close(rs.getString("time_close"));
                t.setTime_open(rs.getString("time_open"));
                t.setDescription(rs.getString("description"));
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Restaurant getOne(String name) {
        try {
            String sql = "SELECT * FROM [dbo].[Restaurant]\n"
                    + "      WHERE restaurant_name = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant t = new Restaurant();
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setRestaurant_name(rs.getString("restaurant_name"));
                t.setTime_close(rs.getString("time_close"));
                t.setTime_open(rs.getString("time_open"));
                t.setDescription(rs.getString("description"));

                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addTour(Restaurant r) {
        boolean isSuccess = false;
        String sql = "INSERT INTO [dbo].[Restaurant]\n"
                + "           ([service_category_id]\n"
                + "           ,[restaurant_name]\n"
                + "           ,[time_close]\n"
                + "           ,[time_open]\n"
                + "           ,[description])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, r.getService_category_id());
            stm.setString(2, r.getRestaurant_name());
            stm.setString(3, r.getTime_close());
            stm.setString(4, r.getTime_open());
            stm.setString(5, r.getDescription());

            isSuccess = stm.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean editTour(Restaurant r) {
        boolean isSuccess = false;
        String sql = "UPDATE [dbo].[Restaurant]\n"
                + "   SET [service_category_id] = ?\n"
                + "      ,[restaurant_name] = ?\n"
                + "      ,[time_close] = ?\n"
                + "      ,[time_open] = ?\n"
                + "      ,[description] = ?\n"
                + " WHERE restaurant_name = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, r.getService_category_id());
            stm.setString(2, r.getRestaurant_name());
            stm.setString(3, r.getTime_close());
            stm.setString(4, r.getTime_open());
            stm.setString(5, r.getDescription());
            stm.setString(6, r.getRestaurant_name());
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccess;
    }

    @Override
    public boolean deleteTour(String name) {
         boolean isSuccess = false;
        String sql = """
                 DELETE FROM [dbo].[Restaurant]
                 WHERE hotel_name = ?""";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, name);
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }

        return isSuccess;
    }
    
     public static void main(String[] args) {
        RestaurantDAO tt = new RestaurantDAO();
        Restaurant r = new Restaurant(2, "Bia Viet Ha", "21:00", "7:00", "bia nhu lon");
        System.out.println(tt.addTour(r));
    }
}
