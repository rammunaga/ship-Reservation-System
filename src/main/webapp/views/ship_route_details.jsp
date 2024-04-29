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
                <h1>All Ship Details </h1>
            </div> 
            
            <table class="table table-striped table-bordered" >
                   <thead class="table-dark">
               <tr>
                   
                   <th> Route ID </th>
                   <th> Ship ID </th>
                   <th> Start </th>
                   <th> destination</th>
                   <th> Price</th>
                   <th> Date</th>
                   <th> Action </th>
               </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="ship" items="${ship_route}">
                          <tr>
                              
                          <td>${ship.route_id} </td>                    
                          <td>${ship.ship_id}</td>
                          <td>${ship.start}</td>
                          <td>${ship.destination}</td>
                          <td>${ship.price}</td>
                          <td>${ship.date}</td>
                          
                          
                                                 
                  <td><a href="<c:url value='/user/book_ticket/payment/${ship.route_id}/${ship.ship_id}' />"  class="btn btn-primary" >Book</a>
                      
                      
                        
                              
                                 
                                  
                          </td>
                      </tr>
                      </c:forEach>
                  </tbody> 
                  </table>
        </div>
    </body>
</html>









