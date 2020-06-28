package com.example.thepunjabidhaba;

public class Cart {
    private String Name, Price, Quantity, ID, Time, Date;

    public Cart(){

    }

    public Cart(String Name, String Price, String Quantity, String Time, String Date, String ID) {
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Time = Time;
        this.Date = Date;
        this.ID=ID;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}