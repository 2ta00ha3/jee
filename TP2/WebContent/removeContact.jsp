<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Contact</title>
</head>
<body>
<h1>Remove Contact</h1>
<form action="ControllerServlet" method="POST">
    <input type="hidden" name="do_this" value="delete"/>
    <table>
        <tr>
            <td>Contact ID</td>
            <td><input type="text" name="contact_id"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Delete"/></td>
        </tr>
    </table>
</form>
<a href="ControllerServlet">Back to Home</a>
</body>
</html>
