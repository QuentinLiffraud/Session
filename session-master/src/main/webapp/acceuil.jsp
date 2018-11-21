<%-- 
    Document   : acceuil
    Created on : 14 nov. 2018, 14:16:49
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Number Guessing game</title>
	</head>
	<body>
		<h1>Bienvenue dans notre jeu !</h1>
		<hr>
		<h2>${numberConnected} joueurs connectés</h2>
		<hr>

	<form method="POST">
		<label>Ton prénom : <input name="playerName"></label>
		<input name="action" value="Connexion" type="SUBMIT">
	</form>
    </body>
</html>
