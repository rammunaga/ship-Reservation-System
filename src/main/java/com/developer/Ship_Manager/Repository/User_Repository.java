package com.developer.Ship_Manager.Repository;

import com.developer.Ship_Manager.Entity.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User_Repository extends JpaRepository<User_Info,String>{
             
}
