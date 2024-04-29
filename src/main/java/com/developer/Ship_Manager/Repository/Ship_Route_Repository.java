/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.developer.Ship_Manager.Repository;

import com.developer.Ship_Manager.Entity.Bookings;
import com.developer.Ship_Manager.Entity.Ship_Routes;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Ship_Route_Repository extends JpaRepository<Ship_Routes,Integer>{
    @Query(value = "FROM Ship_Routes p WHERE p.start=:start and p.destination=:destination ")
	List<Ship_Routes> getCustomBookings(@Param("start") String start,@Param("destination") String destination);
    
    
    
}
