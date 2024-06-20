/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import dal.repo.HotelRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hotel;

/**
 *
 * @author tuanj
 */
public class HotelDAO extends DBContext implements HotelRepo {

    @Override
    public ArrayList<Hotel> getList() {
        ArrayList<Hotel> list = new ArrayList<>();
        try {
            String sql = "select * from Hotel";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Hotel t = new Hotel();
                t.setHotel_name(rs.getString("hotel_name"));
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setDaily_price(rs.getFloat("daily_price"));
                t.setHoliday_price(rs.getFloat("holiday_price"));
                t.setNumber_room(rs.getString("number_room"));
                t.setNumber_people(rs.getString("number_people"));
                t.setDescription(rs.getString("description"));
                t.setPhone(rs.getString("phone"));

                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Hotel getOne(String name) {
        try {
            String sql = "SELECT * FROM [dbo].[Hotel]\n"
                    + "      WHERE hotel_name = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Hotel t = new Hotel();
                t.setHotel_name(rs.getString("hotel_name"));
                t.setService_category_id(rs.getInt("service_category_id"));
                t.setDaily_price(rs.getFloat("daily_price"));
                t.setHoliday_price(rs.getFloat("holiday_price"));
                t.setNumber_room(rs.getString("number_room"));
                t.setNumber_people(rs.getString("number_people"));
                t.setDescription(rs.getString("description"));
                t.setPhone(rs.getString("phone"));
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addHotel(Hotel t) {
        boolean isSuccess = false;
        String sql = "INSERT INTO [dbo].[Hotel] "
                + "([hotel_name], [service_category_id], [daily_price], [holiday_price], "
                + "[number_room], [number_people], [description], [phone]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, t.getHotel_name());
            stm.setInt(2, t.getService_category_id());
            stm.setFloat(3, t.getDaily_price());
            stm.setFloat(4, t.getHoliday_price());
            stm.setString(5, t.getNumber_room());
            stm.setString(6, t.getNumber_people());
            stm.setString(7, t.getDescription());
            stm.setString(8, t.getPhone());

            isSuccess = stm.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean editHotel(Hotel t) {
        boolean isSuccess = false;
        String sql = "UPDATE [dbo].[Hotel]\n"
                + "   SET [hotel_name] = ?\n"
                + "      ,[service_category_id] = ?\n"
                + "      ,[daily_price] = ?\n"
                + "      ,[holiday_price] = ?\n"
                + "      ,[number_room] = ?\n"
                + "      ,[number_people] = ?\n"
                + "	  ,[description] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE hotel_name = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, t.getHotel_name());
            stm.setInt(2, t.getService_category_id());
            stm.setFloat(3, t.getDaily_price());
            stm.setFloat(4, t.getHoliday_price());
            stm.setString(5, t.getNumber_room());
            stm.setString(6, t.getNumber_people());
            stm.setString(7, t.getDescription());
            stm.setString(8, t.getPhone());
            stm.setString(9, t.getHotel_name());
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccess;
    }

    @Override
    public boolean deleteHotel(String name) {
        boolean isSuccess = false;
        String sql = "DELETE FROM Hotel WHERE hotel_name = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, name);
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
