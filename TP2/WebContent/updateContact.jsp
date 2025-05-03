<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Contact</title>
</head>
<body>
<h1>Update Contact</h1>
<c:choose>
    <c:when test="${empty contact}">
        <form action="ControllerServlet" method="POST">
            <input type="hidden" name="do_this" value="update"/>
            <table>
                <tr>
                    <td>Contact ID</td>
                    <td><input type="text" name="contact_id"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Load Contact"/></td>
                </tr>
            </table>
        </form>
    </c:when>
    <c:otherwise>
        <form action="ControllerServlet" method="POST">
            <input type="hidden" name="do_this" value="update"/>
            <input type="hidden" name="contact_id" value="${contact.id}"/>
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${contact.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${contact.lastName}"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="${contact.email}"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" value="${contact.phone}"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="${contact.address}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form>
    </c:otherwise>
</c:choose>
<a href="ControllerServlet">Back to Home</a>
</body>
</html>
