<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>

<style>

form{
	margin-left:10%;
	margin-right:10%;
}

</style>
<body>
<form action="updatedatabyid" class="form-group" method="post"   >
                <h1><strong>Update Data</strong> </h1>
                <label for="">id</label>
                <input type="number" class="form-control" name="id" value="${id}" readonly  >

                <label for="">Mall name </label>
                <input type="text" class="form-control" name="name" value="${mallname}" >
                <label for="">State</label>
                <input type="text" class="form-control" name="state" value="${state}" >
                <label for="">City</label>
                <input type="text" class="form-control" name="city" value="${city}" >
                <label for="">Street and area </label>
                <input type="text" class="form-control" name="address" value="${address}" >
                <label for="">Number of floors </label>
                <input type="number" class="form-control" name="totalfloors"value="${totalfloors}" >
                <label for="">Number of shops </label>
                <input type="number" class="form-control" name="totalshops" value="${totalshops}" >
                <label for="">Total staff </label>
                <input type="number" class="form-control" name="totalstaff" value="${totalstaff}">
                
                
                
                <br/>
                <button type="submit" class="btn btn-primary"  >Submit</button>

            </form>
            ${updateentity}

</body>
</html>