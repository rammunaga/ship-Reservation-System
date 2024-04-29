
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container"> 
            <div class="row"> 
                <h1>Ticket Details </h1>
            </div> 
            <div class="card-body">
                
                
                            <div class="form-group">
                                
                               
                         
                               
                                 <h5>  Booking  Id: ${bookings.booking_id}</h5>
                                 <h5>  Route Id: ${bookings.route_id}</h5>
                                <h5> Ship Id: ${bookings.ship_id}</h5>
                                 
                                 <h5> Customer Id: ${bookings.user_id} </h5>
                                 <h5> Total Ticket ${bookings.quantity} </h5>
                                 
                                 
                                 
                                 <h5> Start:${bookings.start}</h5>
                                  
                                 <h5> Destination:${bookings.destination}</h5>
                                 <h5> Price: ${bookings.price}</h5>
                                 
                                 <h5> Date: ${bookings.date}</h5>
                               
                                 
                                    
                                </div>
                                 </div>
                                    
                       
                            
                        
                    </div>
                                                 
                </form>
                    
                </div>
                
    </body>
</html>










