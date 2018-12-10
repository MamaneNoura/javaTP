<% @ page language = "java" contentType = "text / html; charset = UTF-8"
    pageEncoding = "UTF-8"%>
    <% @ page import = "java.util.Date"%>
<! DOCTYPE html>
<html>
<tête>
<meta charset = "UTF-8">
<title> ChatJPS </ title>
</ head>
<body>
	<h1> <%%> </ h1>
	<! - <label> <% = nouvelle date ()%> </ label>

	<pre>
    <% = request.getAttribute ("content")%>
	</ pre>
		  ->
	<nom du formulaire = 'chatForm' method = 'POST' action = 'Chat'>
		<type d'entrée = 'text' name = 'name' value = '' />
		<input type = 'submit' name = 'action' value = 'Envoyer' />
		<type d'entrée = 'submit' nom = 'action' valeur = 'Réinitialiser' />
	</ form>
	
		
</ body>
</ html>
