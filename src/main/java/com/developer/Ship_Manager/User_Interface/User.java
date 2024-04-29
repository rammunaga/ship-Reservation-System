package com.developer.Ship_Manager.User_Interface;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Entity.User_Info;
import java.util.List;

public interface User {
   public boolean addUser(User_Info user);
 public User_Info getUser(String user_id);
 public Ship_Routes getShipRouteId(int id);
 public List<Ship_Routes> getShipRoute(String start, String destination);
 public Ship_Details getShip(String id);
 public boolean Book_Ship(int route_id, String user_id,int quantity); 
 public List<Bookings> view_booking(String user_id);
 public Bookings view_booking_details(int booking_id);
 public boolean cancel_booking(int booking_id);
      
}
