/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.repo;

import java.util.ArrayList;
import model.Tour;

/**
 *
 * @author tuanj
 */
public interface TourRepo {
    public ArrayList<Tour> getList();
    public Tour getOne(String name);
    public boolean addTour(Tour t);
    public boolean editTour(Tour t);
    public boolean deleteTour(String name);
    
    
}
