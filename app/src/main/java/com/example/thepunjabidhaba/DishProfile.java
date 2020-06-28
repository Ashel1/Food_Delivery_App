package com.example.thepunjabidhaba;

public class DishProfile {
    private String name;
    private String price;
    private String pic;
    private String type;
    private String time;
    private String id;
    private String description;
    private String quantity;

    public DishProfile(){

    }
    public DishProfile(String name, String pic, String price,String type,String time, String quantity, String description,String id) {
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.type= type;
        this.time= time;
        this.description=description;
        this.quantity=quantity;
        this.id=id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}