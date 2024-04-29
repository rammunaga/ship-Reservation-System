package com.developer.Ship_Manager.Service;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Entity.User_Info;
import com.developer.Ship_Manager.Manager_Interface.Manager;
import com.developer.Ship_Manager.Repository.Booking_Repository;
import com.developer.Ship_Manager.Repository.Ship_Repository;
import com.developer.Ship_Manager.Repository.Ship_Route_Repository;
import com.developer.Ship_Manager.Repository.User_Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Manager_Service implements Manager {

    @Autowired
    private Ship_Repository ship_repository;
    
    @Autowired
    private Ship_Route_Repository ship_route_repository;
    
    @Autowired
    private Booking_Repository book_repo;
    
    @Autowired
    private User_Repository user_repository;

    public boolean addShip(Ship_Details ship) {
        try {
            ship_repository.save(ship);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
    
    public User_Info getUser(String id)
    {
       Optional<User_Info> opt=user_repository.findById(id);
       if(opt.isPresent())
       {
         User_Info user=opt.get();
         return user;
       
       }
       else{
       
       return null;
       }
    
    }
    
    

    public List<Ship_Details> getAllShips() {
        List<Ship_Details> lst = new ArrayList<>();

        try {
            ship_repository.findAll().forEach(lst::add);
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            lst.clear();
            return lst;
        }

    }

    public boolean updateShipDetails(Ship_Details ship) {
        String id = ship.getId();
        Optional<Ship_Details> opt = ship_repository.findById(id);
        if (opt.isPresent()) {

            ship_repository.save(ship);

            return true;
        } else {
            return false;

        }

    }

    public boolean deleteShip(String ship_id) {

        Optional<Ship_Details> opt = ship_repository.findById(ship_id);
        if (opt.isPresent()) {

            ship_repository.deleteById(ship_id);

            return true;
        } else {
            return false;

        }

    }
    
    public boolean addShipRoute(Ship_Routes ship_route)
    {
        try{
        
            ship_route_repository.save(ship_route);
            return true;
           
        
        }catch(Exception e)
        {
         e.printStackTrace();
         return false;
        }
    }
    
    public List<Bookings> getBookings(String id,Date date)
    {
        List<Bookings> bookings=book_repo.getCustomBookings(id, date);
        if(bookings.size()>0)
        {
        return bookings;
        }
        else{
        
            return null;
        
        }
    }
    
    

}
