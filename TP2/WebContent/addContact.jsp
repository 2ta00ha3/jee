<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
<h1>Add New Contact</h1>
<form action="ControllerServlet" method="POST">
    <input type="hidden" name="do_this" value="create"/>
    <table>
        <tr>
            <td align="center" colspan="2"><font size="4">Please Enter the Following Details</font></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="Validate" value="Save"/></td>
        </tr>
    </table>
</form>
<a href="ControllerServlet">Back to Home</a>
</body>
</html>
