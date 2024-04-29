package com.developer.Ship_Manager.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ship_details")
public class Ship_Details {
    
    @Id
    String id;
    String ship_name;
    String type;
    int capacity;
    int available;

    public Ship_Details(String id, String ship_name, String type, int capacity) {
        this.id = id;
        this.ship_name = ship_name;
        this.type = type;
        this.capacity = capacity;
    }
    
    public Ship_Details()
    {
    
    }
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    
    
    
  
    @Override
    public String toString() {
        return "Ship_Details{" + "id=" + id + ", ship_name=" + ship_name + ", type=" + type + ", capacity=" + capacity + '}';
    }
    
    
    
}
