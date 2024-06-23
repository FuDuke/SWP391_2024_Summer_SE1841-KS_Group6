/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repo;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author ASUS
 */
public interface VehecleRepo {
      public ArrayList<Vehicle> getList();
    public boolean addVehicle(Vehicle t);
    public boolean editVehicle(Vehicle t);
    public boolean deleteVehicle(String name);
}
