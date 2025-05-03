<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accueil</title>
</head>
	<body>
		<h1>Liste des contacts :</h1>
		<table border="2">
		    <tr>
		        <th>Contact Id</th>
		        <th>First Name</th>
		        <th>Last Name</th>
		        <th>Email</th>
		        <th>Phone Number</th>
		        <th>Address</th>
		    </tr>
		    <c:forEach var="contact" items="${requestScope.listContacts}">
		        <tr>
		            <td>${contact.id}</td>
		            <td>${contact.firstName}</td>
		            <td>${contact.lastName}</td>
		            <td>${contact.email}</td>
		            <td>${contact.phone}</td>
		            <td>${contact.address}</td>
		        </tr>
		    </c:forEach>
		</table>
		<a href="ControllerServlet?do_this=create">Créer un nouveau contact</a><br/>
		<a href="ControllerServlet?do_this=delete">Supprimer un Contact</a><br/>
		<a href="ControllerServlet?do_this=update">Modifier un Contact</a><br/>
		<a href="ControllerServlet?do_this=search">Rechercher un contact</a>
	</body>
</html>
