/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repo;

import java.util.ArrayList;
import model.Hotel;

/**
 *
 * @author tuanj
 */
public interface HotelRepo {
     public ArrayList<Hotel> getList();
    public Hotel getOne(String name);
    public boolean addHotel(Hotel t);
    public boolean editHotel(Hotel t);
    public boolean deleteHotel(String name);/////
}
