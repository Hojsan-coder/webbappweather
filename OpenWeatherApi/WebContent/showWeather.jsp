<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="model.weatherBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>ShowWeather</title>
<link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
  <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>

</head>
<body>

<%

weatherBean wBean = (weatherBean)request.getAttribute("wBean");


out.print(wBean.getCityStre()+" "+wBean.getCloudsStr()+" "+"Current time: "+wBean.getDateStr());

out.println("<br />");

out.println("Cookies: ");

Cookie cookies [] = request.getCookies();

for (int i = 0; i<cookies.length;i++){
	
	
	if(!cookies[i].getName().equals("JSESSIONID")){
		
		String [] splitCookies = cookies[i].getValue().split("/");
		
		
		out.println(splitCookies[0]);
		out.println(splitCookies[1]);
		out.println(splitCookies[2]);
		
		
	}
	
}

%>
<a href="index.jsp">
<button  class="mdc-button mdc-button--raised">  <span class="mdc-button__ripple"></span> Go back!</button>

</a>


</body>
</html>