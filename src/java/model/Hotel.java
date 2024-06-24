/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuanj
 */
public class Hotel {

    private String hotel_name;
    private int service_category_id;
    private float daily_price;
    private float holiday_price;
    private String number_room;
    private String number_people;
    private String description;
    private String phone;
    private String image;

    public Hotel() {
    }

    public Hotel(String hotel_name, int service_category_id, float daily_price, float holiday_price, String number_room, String number_people, String description, String phone, String image) {
        this.hotel_name = hotel_name;
        this.service_category_id = service_category_id;
        this.daily_price = daily_price;
        this.holiday_price = holiday_price;
        this.number_room = number_room;
        this.number_people = number_people;
        this.description = description;
        this.phone = phone;
        this.image = image;
    }

    

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getService_category_id() {
        return service_category_id;
    }

    public void setService_category_id(int service_category_id) {
        this.service_category_id = service_category_id;
    }

    public float getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(float daily_price) {
        this.daily_price = daily_price;
    }

    public float getHoliday_price() {
        return holiday_price;
    }

    public void setHoliday_price(float holiday_price) {
        this.holiday_price = holiday_price;
    }

    public String getNumber_room() {
        return number_room;
    }

    public void setNumber_room(String number_room) {
        this.number_room = number_room;
    }

    public String getNumber_people() {
        return number_people;
    }

    public void setNumber_people(String number_people) {
        this.number_people = number_people;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotel_name=" + hotel_name + ", service_category_id=" + service_category_id + ", daily_price=" + daily_price + ", holiday_price=" + holiday_price + ", number_room=" + number_room + ", number_people=" + number_people + ", description=" + description + ", phone=" + phone + ", image=" + image + '}';
    }
    
    

}
