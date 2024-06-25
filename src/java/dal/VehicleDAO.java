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
                t.setVehicle_id(rs.getInt("vehicle_id"));
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
        String sql = "UPDATE [dbo].[Vehicle]\n"
                + "   SET [service_category_id] = ?\n"
                + "      ,[vehicle_type] = ?\n"
                + "      ,[vehicle_name] = ?\n"
                + "      ,[number_seat] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE vehicle_id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, t.getService_category_id());
            stm.setString(2, t.getVehicle_type());
            stm.setString(3, t.getVehicle_name());
            stm.setInt(4, t.getNumber_seat());
            stm.setString(5, t.getPhone());
            stm.setInt(6, t.getVehicle_id());
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

      @Override
    public Vehicle getOne(int id) {
        try {
            String sql = "SELECT * FROM [dbo].[Vehicle]\n"
                    + "      WHERE vehicle_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle t = new Vehicle();
                t.setVehicle_id(rs.getInt("vehicle_id"));
                t.setNumber_seat(rs.getInt("number_seat"));
                t.setNumber_seat(rs.getInt("number_seat"));
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setVehicle_name(rs.getString("vehicle_name"));
                t.setVehicle_type(rs.getString("vehicle_type"));
                t.setPhone(rs.getString("phone"));
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        HotelDAO tt = new HotelDAO();
        System.out.println(tt.deleteHotel("korea"));
    }
}
