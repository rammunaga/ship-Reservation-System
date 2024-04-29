package com.developer.Ship_Manager.Controller;

import com.developer.Ship_Manager.Entity.Ship_Details;
import com.developer.Ship_Manager.Entity.User_Info;
import com.developer.Ship_Manager.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login_Controller {

    @Autowired
    private User_Service service;

    // URL:  http://localhost:5082/user/new_user
    @GetMapping("/user/new_user")
    public String create_user(Model model) {
        User_Info user = new User_Info();
        model.addAttribute("user", user);
        return "Register_User";
    }

    // URL:  http://localhost:5082/user/save_user
    @PostMapping("/user/save_user")
    public String save_user(@ModelAttribute("user") User_Info user) {
        boolean status = service.addUser(user);
        if (status) {
            return "redirect:/user/login";
        } else {
            return "error";
        }

    }

    // URL:  http://localhost:5082/user/login
    @GetMapping("/user/login")
    public String login(Model model) {
        User_Info user = new User_Info();
        model.addAttribute("user", user);
        return "Login";
    }

    // URL:  http://localhost:5082/user/login/check_user
    @PostMapping("/user/login/check_user")
    public String getUser(@RequestParam("user_id") String user_id, @RequestParam("password") String password, Model model) {


        try{
        User_Info user = service.getUser(user_id);
   
        
        
        
        
        String user_password = user.getPassword();
        String role = user.getType();

        if (user.getUser_id()=="") {
            System.out.println("User not found");
      
            return "user_not_found";

        } else if ((password.equalsIgnoreCase(user_password)) && role.equals("Customer")) {
            System.out.println("User Id: " + user.getUser_id());
            model.addAttribute("user", user);
            return "User_Dashboard";

        } else {
            return "user_not_found";
        }
        }catch(Exception e)
        {
         return "user_not_found";
        }

    }

    
     // URL:  http://localhost:5082/inded
    @GetMapping("/index")
    public String main_page() {
       
        return "index";
    }

    
    
    
}
