/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuanj
 */
public class Tour {

    private String tour_name;
    private String description;
    private float deposit;
    private String start_date;
    private String end_date;
    private String min_child;
    private String max_child;
    private String min_adult;
    private String max_adult;
    private float total_price;
    private String number_day;
    private int account_id;
    private int tour_catetgory_id;
    private String image;

    public Tour() {
    }

    public Tour(String tour_name, String description, float deposit, String start_date, String end_date, String min_child, String max_child, String min_adult, String max_adult, float total_price, String number_day, int account_id, int tour_catetgory_id, String image) {
        this.tour_name = tour_name;
        this.description = description;
        this.deposit = deposit;
        this.start_date = start_date;
        this.end_date = end_date;
        this.min_child = min_child;
        this.max_child = max_child;
        this.min_adult = min_adult;
        this.max_adult = max_adult;
        this.total_price = total_price;
        this.number_day = number_day;
        this.account_id = account_id;
        this.tour_catetgory_id = tour_catetgory_id;
        this.image = image;
    }

    

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getMin_child() {
        return min_child;
    }

    public void setMin_child(String min_child) {
        this.min_child = min_child;
    }

    public String getMax_child() {
        return max_child;
    }

    public void setMax_child(String max_child) {
        this.max_child = max_child;
    }

    public String getMin_adult() {
        return min_adult;
    }

    public void setMin_adult(String min_adult) {
        this.min_adult = min_adult;
    }

    public String getMax_adult() {
        return max_adult;
    }

    public void setMax_adult(String max_adult) {
        this.max_adult = max_adult;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getNumber_day() {
        return number_day;
    }

    public void setNumber_day(String number_day) {
        this.number_day = number_day;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getTour_catetgory_id() {
        return tour_catetgory_id;
    }

    public void setTour_catetgory_id(int tour_catetgory_id) {
        this.tour_catetgory_id = tour_catetgory_id;
    }

    @Override
    public String toString() {
        return "Tour{" + "tour_name=" + tour_name + ", description=" + description + ", deposit=" + deposit + ", start_date=" + start_date + ", end_date=" + end_date + ", min_child=" + min_child + ", max_child=" + max_child + ", min_adult=" + min_adult + ", max_adult=" + max_adult + ", total_price=" + total_price + ", number_day=" + number_day + ", account_id=" + account_id + ", tour_catetgory_id=" + tour_catetgory_id + ", image=" + image + '}';
    }

    

   
}
