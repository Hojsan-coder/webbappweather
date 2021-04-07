<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
  <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>

</head>
<body>



<form action="OWservlet" method="get">

City<input type="text" name="city" /> <br/>
Country (Language code): <input type="text" name ="country"/><br/>




<button type="submit" class="mdc-button mdc-button--raised">  <span class="mdc-button__ripple"></span> Go</button>



</form>






</body>
</html>