<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="container mt-5">
        <div id="form">
            <div class="form-container">
                <h2>Edit Burger</h2>
                <form:form action="/burgers/edit/${burger.id}" method="post" modelAttribute="burger">
                <input type="hidden" name="_method" value="put" />
                    <div class="form-group">
                        <form:label path="name" class="font-weight-bold">Burger Name</form:label>
                        <form:errors path="name" class="text-danger" />
                        <form:input path="name" class="form-control" placeholder="Burger Name" />
                    </div>
                    <div class="form-group">
                        <form:label path="restaurant" class="font-weight-bold">Restaurant</form:label>
                        <form:errors path="restaurant" class="text-danger"/>
                        <form:input path="restaurant" class="form-control" placeholder="Restaurant" />
                    </div>
                    <div class="form-group">
                        <form:label path="rating" class="font-weight-bold">Rating</form:label>
                        <form:errors path="rating" class="text-danger"/>
                        <form:input path="rating" class="form-control" placeholder="Rating" />
                    </div>
                    <div class="form-group">
                        <form:label path="notes" class="font-weight-bold">Notes</form:label>
                        <form:errors path="notes" class="text-danger"/>
                        <form:textarea path="notes" class="form-control" placeholder="Notes" rows="3" />
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
