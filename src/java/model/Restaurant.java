/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuanj
 */
public class Restaurant {
    int service_category_id;
    String restaurant_name;
    String time_close;
    String time_open;
    String description;
    String image;
    public Restaurant() {
    }

    public Restaurant(int service_category_id, String restaurant_name, String time_close, String time_open, String description, String image) {
        this.service_category_id = service_category_id;
        this.restaurant_name = restaurant_name;
        this.time_close = time_close;
        this.time_open = time_open;
        this.description = description;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
    public int getService_category_id() {
        return service_category_id;
    }

    public void setService_category_id(int service_category_id) {
        this.service_category_id = service_category_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getTime_close() {
        return time_close;
    }

    public void setTime_close(String time_close) {
        this.time_close = time_close;
    }

    public String getTime_open() {
        return time_open;
    }

    public void setTime_open(String time_open) {
        this.time_open = time_open;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "service_category_id=" + service_category_id + ", restaurant_name=" + restaurant_name + ", time_close=" + time_close + ", time_open=" + time_open + ", description=" + description + ", image=" + image + '}';
    }

    
    
    
}
