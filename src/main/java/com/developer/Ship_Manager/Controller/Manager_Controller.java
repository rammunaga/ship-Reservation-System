package com.developer.Ship_Manager.Controller;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import com.developer.Ship_Manager.Service.Manager_Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Manager_Controller {

    @Autowired
    private Manager_Service service;
    

    

    // URL:  http://localhost:5082/manager/new_ship
    @GetMapping("/manager/new_ship")
    public String create_user(Model model) {
        Ship_Details ship = new Ship_Details();
        model.addAttribute("ship", ship);
        return "add_ship";
    }

    // URL:  http://localhost:5082/manager/save_ship
    @PostMapping("/manager/save_ship")
    public String save_user(@ModelAttribute("ship") Ship_Details ship) {
        boolean status = service.addShip(ship);
        if (status) {
            return "success";
        } else {
            return "error";
        }

    }
    
    
   
    
    

    // URL:  http://localhost:5082/manager/all_ships
    @GetMapping("/manager/all_ships")
    public String getAllShipDetails(Model model) {

        List<Ship_Details> ship_details = service.getAllShips();
        model.addAttribute("ship_details", ship_details);

        return "all_ships";
    }

    // URL:  http://localhost:5082/manager/ship_details/update/101
    @GetMapping("/manager/ship_details/update/{ship_id}")
    public String updateShipDetails(@PathVariable("ship_id") String id, Model model) {
        Ship_Details ship = service.getShip(id);
        System.out.println(ship.getId());
        model.addAttribute("ship", ship);
        return "update_details";
    }

    // URL:  http://localhost:5082/manager/ship_details/view_details/101
    @GetMapping("/manager/ship_details/view_details/{ship_id}")
    public String viewShipDetails(@PathVariable("ship_id") String id, Model model) {
        Ship_Details ship = service.getShip(id);
        System.out.println(id);
        model.addAttribute("ship", ship);
        return "view_details";
    }

    // URL:  http://localhost:5082/manager/save_ship
    @GetMapping("/manager/save_ship")
    public String update_ship_details(Ship_Details ship) {
        boolean status = service.updateShipDetails(ship);
        System.out.println(status);
        if (status) {
            return "success";
        } else {

            return "error";

        }

    }

    // URL:  http://localhost:5082/manager/ship_details/101
    @GetMapping("/manager/ship_details/delete/{ship_id}")
    public String deleteShipDetails(@PathVariable("ship_id") String id, Model model) {
        boolean status = service.deleteShip(id);

        if (status) {

            return "success";

        } else {

            return "error";

        }

    }

    // URL:  http://localhost:5082/manager/ship_route/new_route
    @GetMapping("/manager/ship_route/new_route")
    public String create_route(Model model) {
        Ship_Routes ship_route = new Ship_Routes();

        model.addAttribute("ship_route", ship_route);
        return "add_route_details";
    }

    // URL:  http://localhost:5082/manager/ship_route/save_route
    @PostMapping("/manager/ship_route/save_route")
    public String save_route(@RequestParam("shipping_date") String shipping_date, @ModelAttribute("ship_route") Ship_Routes ship_route) throws ParseException {

        System.out.println(ship_route.getShip_id());
        System.out.println(shipping_date);

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(shipping_date);
        ship_route.setDate(date);

        boolean status = service.addShipRoute(ship_route);
        if (status) {
            return "success";
        } else {
            return "error";
        }

    }

    // URL:  http://localhost:5082/manager/view_booking
    @GetMapping("/manager/view_booking")
    public String viewBookingDetails() {
        return "display_booking";
    }

    // URL:  http://localhost:5082/manager/bookings
    @GetMapping("/manager/bookings")
    public String getbookingsDetails(@RequestParam("shipping_date") String shipping_date,
            @RequestParam("ship_id") String ship_id, Model model) throws ParseException {

        System.out.println(ship_id);
        System.out.println(shipping_date);

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(shipping_date);

        
        List<Bookings> bookings = service.getBookings(ship_id, date);

        
        
        
        model.addAttribute("bookings",bookings);
        
        return "booking_list";

    }
    
     // URL:  http://localhost:5082/manager/home
    @GetMapping("/manager/home")
    public String main() {
      
        return "Manager_Dashboard";
    }
    

}
