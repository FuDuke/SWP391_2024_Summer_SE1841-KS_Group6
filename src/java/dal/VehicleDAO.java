/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import dal.repo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author tuanj
 */
public class VehicleDAO extends DBContext implements VehecleRepo {

    @Override
    public ArrayList<Vehicle> getList() {
        ArrayList<Vehicle> list = new ArrayList<>();
        try {
            String sql = "select * from Vehicle";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle t = new Vehicle();
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setVehicle_type(rs.getString("vehicle_type"));
                t.setVehicle_name(rs.getString("vehicle_name"));
                t.setNumber_seat(rs.getInt("number_seat"));
                t.setPhone(rs.getString("phone"));
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addVehicle(Vehicle t) {
        boolean isSuccess = false;
        String sql = "INSERT INTO [dbo].[Vehicle] "
                + "([service_category_id]\n"
                + "           ,[vehicle_type]\n"
                + "           ,[vehicle_name]\n"
                + "           ,[number_seat]\n"
                + "           ,[phone]) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(2, t.getVehicle_type());
            stm.setInt(1, t.getService_category_id());
            stm.setString(3, t.getVehicle_name());
            stm.setInt(4, t.getNumber_seat());
            stm.setString(5, t.getPhone());
            isSuccess = stm.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean editVehicle(Vehicle t) {
        boolean isSuccess = false;
//        String sql = "UPDATE [dbo].[Hotel]\n"
//                + "   SET [hotel_name] = ?\n"
//                + "      ,[service_category_id] = ?\n"
//                + "      ,[daily_price] = ?\n"
//                + "      ,[holiday_price] = ?\n"
//                + "      ,[number_room] = ?\n"
//                + "      ,[number_people] = ?\n"
//                + "	  ,[description] = ?\n"
//                + "      ,[phone] = ?\n"
//                + " WHERE hotel_name = ?";
//
//        try (PreparedStatement stm = connection.prepareStatement(sql)) {
//            stm.setString(1, t.getHotel_name());
//            stm.setInt(2, t.getService_category_id());
//            stm.setFloat(3, t.getDaily_price());
//            stm.setFloat(4, t.getHoliday_price());
//            stm.setString(5, t.getNumber_room());
//            stm.setString(6, t.getNumber_people());
//            stm.setString(7, t.getDescription());
//            stm.setString(8, t.getPhone());
//            stm.setString(9, t.getHotel_name());
//            isSuccess = stm.executeUpdate() == 1;
//        } catch (SQLException ex) {
//            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return isSuccess;
    }

    @Override
    public boolean deleteVehicle(int id) {
        boolean isSuccess = false;
        String sql = "DELETE FROM [dbo].[Vehicle]\n" +
"      WHERE vehicle_id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }

        return isSuccess;
    }

    public static void main(String[] args) {
        HotelDAO tt = new HotelDAO();
        Hotel h = new Hotel("Hoang DInh", 1, 2000, 3000, "2", "2", "o quy hop nghe an", "555-1000");
        System.out.println(tt.deleteHotel("korea"));
    }
}
