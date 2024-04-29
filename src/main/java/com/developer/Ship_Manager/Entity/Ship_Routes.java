package com.developer.Ship_Manager.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ship_routes")
public class Ship_Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    int route_id;
    String ship_id;
    String start;
    String destination;
    String distance;
    int price;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Ship_Routes(int route_id, String ship_id, String start, String destination, String distance, int price, Date date) {
        this.route_id = route_id;
        this.ship_id = ship_id;
        this.start = start;
        this.destination = destination;
        this.distance = distance;
        this.price = price;
        this.date = date;
    }

   



   

    public Ship_Routes() {

    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    

    public String getShip_id() {
        return ship_id;
    }

    public void setShip_id(String ship_id) {
        this.ship_id = ship_id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ship_Routes{" + "route_id=" + route_id + ", ship_id=" + ship_id + ", start=" + start + ", destination=" + destination + ", price=" + price + ", date=" + date + '}';
    }
    
    
    
}
