/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.developer.Ship_Manager.Manager_Interface;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Entity.User_Info;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mehul
 */
public interface Manager {
    
 public Ship_Details getShip(String id);
 
 public User_Info getUser(String id);
 
 public List<Ship_Details> getAllShips();
 
 public boolean updateShipDetails(Ship_Details ship);
 
 public boolean deleteShip(String ship_id);
 
 public boolean addShipRoute(Ship_Routes ship_route);
 
 public List<Bookings> getBookings(String id,Date date);
 
}
