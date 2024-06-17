/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.repo.TourRepo;
import java.util.ArrayList;
import model.Tour;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuanj
 */
public class TourDAO extends DBContext implements TourRepo {

    @Override
    public ArrayList<Tour> getList() {
        ArrayList<Tour> list = new ArrayList<>();
        try {
            String sql = "select * from Tour";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Tour t = new Tour();
                t.setTour_name(rs.getString("tour_name"));
                t.setDescription(rs.getString("description"));
                t.setDeposit(rs.getFloat("deposit"));
                t.setStart_date(rs.getString("start_date"));
                t.setEnd_date(rs.getString("end_date"));
                t.setMin_child(rs.getString("min_child"));
                t.setMax_child(rs.getString("max_child"));
                t.setMin_adult(rs.getString("min_adult"));
                t.setMax_adult(rs.getString("max_adult"));
                t.setTotal_price(rs.getFloat("total_price"));
                t.setNumber_day(rs.getString("number_day"));
                t.setAccount_id(rs.getInt("account_id"));
                t.setTour_catetgory_id(rs.getInt("tour_catetgory_id"));

                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Tour getOne(String name) {
        try {
            String sql = "SELECT * FROM [dbo].[Tour]\n"
                    + "      WHERE tour_name = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour t = new Tour();
                t.setTour_name(rs.getString("tour_name"));
                t.setDescription(rs.getString("description"));
                t.setDeposit(rs.getFloat("deposit"));
                t.setStart_date(rs.getString("start_date"));
                t.setEnd_date(rs.getString("end_date"));
                t.setMin_child(rs.getString("min_child"));
                t.setMax_child(rs.getString("max_child"));
                t.setMin_adult(rs.getString("min_adult"));
                t.setMax_adult(rs.getString("max_adult"));
                t.setTotal_price(rs.getFloat("total_price"));
                t.setNumber_day(rs.getString("number_day"));
                t.setAccount_id(rs.getInt("account_id"));
                t.setTour_catetgory_id(rs.getInt("tour_catetgory_id"));
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addTour(Tour t) {
        boolean isSuccess = false;
        try {
            String sql = "INSERT INTO [dbo].[Tour]\n"
                    + "           ([tour_name]\n"
                    + "           ,[description]\n"
                    + "           ,[deposit]\n"
                    + "           ,[start_date]\n"
                    + "           ,[end_date]\n"
                    + "           ,[min_child]\n"
                    + "           ,[max_child]\n"
                    + "           ,[min_adult]\n"
                    + "           ,[max_adult]\n"
                    + "           ,[total_price]\n"
                    + "           ,[number_day]\n"
                    + "           ,[account_id]\n"
                    + "           ,[tour_catetgory_id])\n"
                    + "     VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, t.getTour_name());
            stm.setString(2, t.getDescription());
            stm.setFloat(3, t.getDeposit());
            stm.setString(4, t.getStart_date());
            stm.setString(5, t.getEnd_date());
            stm.setString(6, t.getMin_child());
            stm.setString(7, t.getMax_child());
            stm.setString(8, t.getMin_adult());
            stm.setString(9, t.getMax_adult());
            stm.setFloat(10, t.getTotal_price());
            stm.setString(11, t.getNumber_day());
            stm.setInt(12, t.getAccount_id());
            stm.setInt(13, t.getTour_catetgory_id());

            isSuccess = stm.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean editTour(Tour t) {
        boolean isSuccess = false;
        String sql = "UPDATE [dbo].[Tour]\n"
                + "   SET [tour_name] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[deposit] = ?\n"
                + "      ,[start_date] = ?\n"
                + "      ,[end_date] = ?\n"
                + "      ,[min_child] = ?\n"
                + "      ,[max_child] = ?\n"
                + "      ,[min_adult] = ?\n"
                + "      ,[max_adult] = ?\n"
                + "      ,[total_price] = ?\n"
                + "      ,[number_day] = ?\n"
                + "      ,[account_id] = ?\n"
                + "      ,[tour_catetgory_id] = ?\n"
                + " WHERE tour_name = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, t.getTour_name());
            stm.setString(2, t.getDescription());
            stm.setFloat(3, t.getDeposit());
            stm.setString(4, t.getStart_date());
            stm.setString(5, t.getEnd_date());
            stm.setString(6, t.getMin_child());
            stm.setString(7, t.getMax_child());
            stm.setString(8, t.getMin_adult());
            stm.setString(9, t.getMax_adult());
            stm.setFloat(10, t.getTotal_price());
            stm.setString(11, t.getNumber_day());
            stm.setInt(12, t.getAccount_id());
            stm.setInt(13, t.getTour_catetgory_id());
            stm.setString(14, t.getTour_name());
            isSuccess = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return isSuccess;
    }

    @Override
    public boolean deleteTour(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        TourDAO tt = new TourDAO();
        Tour t = new Tour("new2", "aaa", 2, "222", "222", "222", "222", "22", "22", 2, "12", 2, 2);

        System.out.println(tt.editTour(t));
    }
}
