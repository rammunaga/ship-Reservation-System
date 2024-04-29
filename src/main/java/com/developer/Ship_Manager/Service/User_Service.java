package com.developer.Ship_Manager.Service;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Entity.User_Info;
import com.developer.Ship_Manager.Repository.Booking_Repository;
import com.developer.Ship_Manager.Repository.Ship_Repository;
import com.developer.Ship_Manager.Repository.Ship_Route_Repository;
import com.developer.Ship_Manager.Repository.User_Repository;
import com.developer.Ship_Manager.User_Interface.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_Service implements User{

    @Autowired
    private User_Repository repository;

    @Autowired
    private Ship_Route_Repository ship_route_repository;

    @Autowired
    private Ship_Repository ship_repository;

    @Autowired
    private Booking_Repository book_repo;

    public boolean addUser(User_Info user) {
        try {
            repository.save(user);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public User_Info getUser(String user_id) {
        
     Optional<User_Info> opt=repository.findById(user_id);
     if(opt.isPresent())
     {
     User_Info user=opt.get();
      return user;
     }
     else{
     return null;
     }
    }
    
    
    public Ship_Routes getShipRouteId(int id) {
      Optional<Ship_Routes> opt=ship_route_repository.findById(id);
      
      if(opt.isPresent())
      {
      Ship_Routes ship_route=opt.get();
      return ship_route;
      
      }
      else{
      return null;
      }
       
    }

    

    public List<Ship_Routes> getShipRoute(String start, String destination) {
        List<Ship_Routes> ship_route_details = ship_route_repository.getCustomBookings(start, destination);
        if (ship_route_details.size() > 0) {
            return ship_route_details;

        } else {

            return null;
        }

    }

    public Ship_Details getShip(String id) {

        try {
            Optional<Ship_Details> opt = ship_repository.findById(id);
            if (opt.isPresent()) {
                Ship_Details ship = opt.get();
                return ship;
            } else {
                return null;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean Book_Ship(int route_id, String user_id,int quantity) {
        Optional<Ship_Routes> opt = ship_route_repository.findById(route_id);

        if (opt.isPresent()) {

            Ship_Routes ship_route_details = opt.get();

            Ship_Details ship = getShip(ship_route_details.getShip_id());

            
            System.out.println(ship_route_details);
            System.out.println(ship);

            if (ship.getId() == null || ship.getAvailable() <quantity) {
              
                return false;
            }

            int available = ship.getAvailable() - quantity;

            Bookings book_detail = new Bookings();
            book_detail.setRoute_id(route_id);
            book_detail.setShip_id(ship_route_details.getShip_id());
            book_detail.setUser_id(user_id);
            book_detail.setStart(ship_route_details.getStart());
            book_detail.setDestination(ship_route_details.getDestination());
            book_detail.setPrice(ship_route_details.getPrice());
            book_detail.setQuantity(quantity);
            book_detail.setDate(ship_route_details.getDate());
            ship.setAvailable(available);
            ship_repository.save(ship);
            book_repo.save(book_detail);
            return true;

        } else {
         

            return false;
        }
    }
    
    public List<Bookings> view_booking(String user_id)
    {
      List<Bookings> customer_booking_details=book_repo.getCustomBookings(user_id);
      if(customer_booking_details.size()>0)
      {
        return customer_booking_details;
      
      }
      else{
      
          return null;
      
      }
       
    
    }
    
     public Bookings view_booking_details(int booking_id)
    {
     Optional<Bookings> opt=book_repo.findById(booking_id);
     
     if(opt.isPresent())
     {
     Bookings booking_detail=opt.get();
     return booking_detail;
     }
     
     else
     {
       return null;
     }
     
       
    
    }
    
    
    
    public boolean cancel_booking(int booking_id)
    {
        
        Optional<Bookings> opt=book_repo.findById(booking_id);
        if(opt.isPresent())
        {
        Bookings book=opt.get();
      
        String ship_id=book.getShip_id();
        Optional<Ship_Details> ship_details=ship_repository.findById(ship_id);
        Ship_Details ship=ship_details.get();
        int qty=book.getQuantity();
        int available=ship.getAvailable()+qty;
        ship.setAvailable(available);
        ship_repository.save(ship);
        book_repo.deleteById(booking_id);
        return true;
        
        }
        else{
        return false;
        }
    
    
    }
    
    
    

}
