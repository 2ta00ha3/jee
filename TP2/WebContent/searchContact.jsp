<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
<h1>Search Contact</h1>
<form action="ControllerServlet" method="POST">
    <input type="hidden" name="do_this" value="search"/>
    <table>
        <tr>
            <td>Contact ID</td>
            <td><input type="text" name="contact_id"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Search"/></td>
        </tr>
    </table>
</form>
<c:if test="${not empty contact}">
    <h2>Contact Details</h2>
    <table border="2">
        <tr>
            <th>Contact Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Address</th>
        </tr>
        <tr>
            <td>${contact.id}</td>
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
            <td>${contact.email}</td>
            <td>${contact.phone}</td>
            <td>${contact.address}</td>
        </tr>
    </table>
</c:if>
<a href="ControllerServlet">Back to Home</a>
</body>
</html>
