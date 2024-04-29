
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
                
                <form action="/user/book_ticket/${ship_route.route_id}" method="post">
                
                            <div class="form-group">
                                
                               
                                
                               
                               
                                 <h5>  Route Id: ${ship_route.route_id}</h5>
                                 <h5> Ship Id: ${ship_route.ship_id}</h5>
                                 <h5> Ship Name: ${ship_details.ship_name}</h5>
                                 <h5> Start:${ship_route.start}</h5>
                                 
                                 <h5> Destination:${ship_route.destination}</h5>
                                 <h5> Price: ${ship_route.price}</h5>
                                 <h5> Price: ${ship_route.distance}</h5>
                                 
                                 
                                 <h5> Date: ${ship_route.date}</h5>
                               
                                 <div>
                                 <label for="user">User ID:</label>
                                 <input type="text" id="user_id" name="user_id"><br><br>
                                
                                 <label for="quantity">Quantity:</label>                              
                                 <input type="text" id="quantity" name="quantity"><br><br>
                                
                                 <label for="upi_id">UPI ID:</label>
                                 
                                 
                                 <input type="text"  name="upi_id"><br><br>
                                 
                                <div class="box-footer" >
                                    <button type="submit"   class="btn btn-primary">Pay</button>
                                    
                                </div>
                                 </div>
                                    
                       
                            
                        
                    </div>
                                                 
                </form>
                    
                </div>
                
    </body>
</html>









