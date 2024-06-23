/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Vehicle {
    private int vehicle_id;
    private int service_category_id;
    private String vehicle_type;
    private String vehicle_name;
    private int number_of_seat;
    private String phone;

    public Vehicle(int vehicle_id, int service_category_id, String vehicle_type, String vehicle_name, int number_of_seat, String phone) {
        this.vehicle_id = vehicle_id;
        this.service_category_id = service_category_id;
        this.vehicle_type = vehicle_type;
        this.vehicle_name = vehicle_name;
        this.number_of_seat = number_of_seat;
        this.phone = phone;
    }

    public Vehicle() {
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getService_category_id() {
        return service_category_id;
    }

    public void setService_category_id(int service_category_id) {
        this.service_category_id = service_category_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public int getNumber_of_seat() {
        return number_of_seat;
    }

    public void setNumber_of_seat(int number_of_seat) {
        this.number_of_seat = number_of_seat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
