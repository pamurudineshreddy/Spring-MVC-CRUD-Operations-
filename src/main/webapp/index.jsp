<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<style>
    
</style>
<body>
	${deleteid}
    <div class="row align-items-center justify-content-center">
        <div class="col-sm-4">
        
        <a href="gellalldata" ><strong>All data</strong></a>
        
        
        
        <form action="getDatabyId" method="post" >
        <label for="">Get data by ID </label>
                <input type="number" class="form-control" name="id" placeholder="" >
                 <br/>
                <button type="submit" class="btn btn-primary"  >Submit</button>
        
        </form>
        
            
            
             <form action="getDatabyName" method="post" >
		        <label for="">Get data by Name </label>
		                <input type="text" class="form-control" name="name" placeholder="" >
		                 <br/>
		                <button type="submit" class="btn btn-primary"  >Submit</button>
        
        	</form>
        	<form action="getDatabyCity" method="post" >
		        <label for="">Get data by City </label>
		                <input type="text" class="form-control" name="name" placeholder="" >
		                 <br/>
		                <button type="submit" class="btn btn-primary"  >Submit</button>
        
        	</form>
        	 	 ${response1} ${message1} 
        		 ${response2} ${message2} 
        		 ${response3} ${message3} 
        		 ${response4} ${message4} 
        		 ${response5} ${message5} 
        		 ${response6} ${message6} 
        		 ${response7} ${message7} 
        		 ${response8} ${message8} 
        	
        	
        	
        	<table class="table"   >
        	<tr>
        	<th>Id</th>
        	<th>Mall Name</th>
        	<th>State</th>
        	<th>City</th>
        	<th>Address</th>
        	<th>Totalfloors</th>
        	<th>Totalshops</th>
        	<th>Totalstaff</th>
        	<th>Update</th>
        	<th>Delete</th>
        	</tr>
			    
        	<c:forEach items="${data}" var="d">
        	<tr>
        	<td>  ${d.id}</td>
        	<td>  ${d.mallname}</td>
        	<td>  ${d.state}</td>
        	<td>  ${d.city}</td>
        	<td>  ${d.address}</td>
        	<td>  ${d.totalfloors}</td>
        	<td>  ${d.totalshops}</td>
        	<td>  ${d.totalstaff}</td>
        	<td><a href="updateData/${d.id}">Edit</a></td>
        	<td><a href="deleteData/${d.id}">Delete</a></td>
        	</tr>
        	</c:forEach>
        	<c:forEach items="${citydata}" var="d">
        	<tr>
        	<td>  ${d.id}</td>
        	<td>  ${d.mallname}</td>
        	<td>  ${d.state}</td>
        	<td>  ${d.city}</td>
        	<td>  ${d.address}</td>
        	<td>  ${d.totalfloors}</td>
        	<td>  ${d.totalshops}</td>
        	<td>  ${d.totalstaff}</td>
        	<td><a href="updateData/${d.id}">Edit</a></td>
        	<td><a href="deleteData/${d.id}">Delete</a></td>
        	</tr>
        	</c:forEach>
        	
        	
        	<tr>
				<c:forEach var="i" begin="1" end="1">
	        	<td>  ${idData.id}</td>
	        	<td>  ${idData.mallname}</td>
	        	<td>  ${idData.state}</td>
	        	<td>  ${idData.city}</td>
	        	<td>  ${idData.address}</td>
	        	<td>  ${idData.totalfloors}</td>
	        	<td>  ${idData.totalshops}</td>
	        	<td>  ${idData.totalstaff}</td>
	        	<%-- <td><a href="updateData/${idData.id}">Edit</a></td>
	        	<td><a href="deleteData/${idData.id}">Delete</a></td> --%>
				</c:forEach>
			</tr>
        	</table>
        	${nodata}
        	 ${message}
        
        
            <form action="insertionmallsdata" class="form-group" method="post">
                <h1><strong>Shopping malls information Insertion</strong> </h1>

                <label for="htmldata">Mall name </label>
                <input type="text" class="form-control" name="name" placeholder="Forum mall" >
                <label for="">State</label>
                <input type="text" class="form-control" name="state" placeholder="Karnataka" >
                <label for="">City</label>
                <input type="text" class="form-control" name="city" placeholder="Bengaluru" >
                <label for="">Street and area </label>
                <input type="text" class="form-control" name="address" placeholder="BTM layout" >
                <label for="">Number of floors </label>
                <input type="number" class="form-control" name="totalfloors" placeholder="8" >
                <label for="">Number of shops </label>
                <input type="number" class="form-control" name="totalshops" placeholder="40" >
                <label for="">Total staff </label>
                <input type="number" class="form-control" name="totalstaff" placeholder="50" >
                
                
                
                <br/>
                <button type="submit" class="btn btn-primary"  >Submit</button>

            </form>
            
            ${message }
            ${updateentity }
            
        </div>
    </div>

   
    
</body>
</html>