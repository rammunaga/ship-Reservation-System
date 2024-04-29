package com.developer.Ship_Manager.Controller;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Service.User_Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User_Controller {

    @Autowired
    private User_Service service;

    // URL:  http://localhost:5082/user/search_ship
    @GetMapping("/user/search_ship")
    public String search_ship() {
        
        return "ship_routes_user_search";
    }

    // URL:  http://localhost:5082/user/ship_route_details
    @GetMapping("/user/ship_route_details")
    public String getShipRouteDetails(@RequestParam("start") String start, @RequestParam("destination") String destination, Model model) {
        System.out.println(start);
        System.out.println(destination);
        List<Ship_Routes> ship_route = service.getShipRoute(start, destination);

        model.addAttribute("ship_route", ship_route);

        return "ship_route_details";
    }

    
    // URL:  http://localhost:5082/user/ship_route_details
    @GetMapping("/user/book_ticket/payment/{route_id}/{ship_id}")
    public String getTicketPayment(@PathVariable("route_id") int route_id, @PathVariable("ship_id") String ship_id, Model model) {

        Ship_Routes ship_route = service.getShipRouteId(route_id);
        Ship_Details ship_details = service.getShip(ship_id);
        System.out.println(ship_route);
        System.out.println(ship_details);

        model.addAttribute("ship_route", ship_route);
        model.addAttribute("ship_details", ship_details);
        return "booking_status";

    }

    
    // URL:  http://localhost:5082/user/book_ticket/101/5
    @PostMapping("/user/book_ticket/{route_id}")
    public String bookShipTicket(@PathVariable("route_id") int route_id, 
                                 @RequestParam("user_id") String user_id,
                                 @RequestParam("quantity") int quantity) {

        System.out.println(route_id);
        System.out.println(user_id);
        System.out.println(quantity);
        boolean status = service.Book_Ship(route_id, user_id,quantity);
        System.out.println(status);
        if (status) {
            return "success";
        } else {

            return "error";
        }

    }
    
    
    // URL:  http://localhost:5082/user/view_bookings/101
    @GetMapping("/user/view_bookings/{user_id}")
    public String view_customer_bookings(@PathVariable("user_id") String user_id,Model model) {
        
        List<Bookings> bookings=service.view_booking(user_id);
      
        model.addAttribute("bookings", bookings);
        
        
        return "booking_list";
        
    }
    
    
    // URL:  http://localhost:5082/user/view_bookings/101
    @GetMapping("/user/view_ticket/{booking_id}")
    public String customer_ticket(@PathVariable("booking_id") int booking_id,Model model) {
        
        System.out.println(booking_id);
        Bookings bookings=service.view_booking_details(booking_id);
        
        System.out.println("bookings");
   model.addAttribute("bookings",bookings);
        
        
        return "customer_ticket_details";
        
    }
    
    
      // URL:  http://localhost:5082/user/cancel_booking/101
    @GetMapping("/user/cancel_booking/{booking_id}")
    public String cancel_customer_booking(@PathVariable("booking_id") int booking_id) {
        boolean status=service.cancel_booking(booking_id);
        if(status)
        {
        return "success";
        }
        
        return "error";
        
    }
    
    
    
    
    
    

}
