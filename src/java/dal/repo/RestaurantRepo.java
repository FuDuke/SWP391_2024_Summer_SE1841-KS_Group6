/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repo;

import java.util.ArrayList;
import model.Restaurant;

/**
 *
 * @author tuanj
 */
public interface RestaurantRepo {
    public ArrayList<Restaurant> getList();
    public Restaurant getOne(String name);
    public boolean addRestaurant(Restaurant r);
    public boolean editRestaurant(Restaurant r);
    public boolean deleteRestaurant(String name);
}
