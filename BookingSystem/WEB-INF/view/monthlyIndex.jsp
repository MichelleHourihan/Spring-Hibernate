<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Calendar</title>
<link type = "text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Today:  ${calendar.today}</h1>
	<div id="container">
	
		<div id="content">

			<c:url var="changeLastMonthLink" value="/last">
			<c:param name="today" value="${calendar.today}" />
			</c:url>
			<a href="${changeLastMonthLink}">Last Month</a>
			&nbsp;
			${calendar.month}
			&nbsp;
			<c:url var="changeMonthLink" value="/next">
			<c:param name="today" value="${calendar.today}" />
			</c:url>
			&nbsp;
			<a href="${changeMonthLink}">Next Month</a>

			<c:url var="bookDate" value="/bookDate">
			<c:param name="today" value="${calendar.today}" />
			</c:url>
			
			&nbsp;&nbsp;&nbsp;
			<c:url var="changeThisMonthLink" value="/">
			</c:url>
			<a href="${changeThisMonthLink}">Today</a>
			
			
			&nbsp;&nbsp;
			
			<c:url var="weekly" value="/weekCalendar">
			<c:param name="today" value="${calendar.today}" />
			</c:url>
			<a href="${weekly}">Weekly</a>
			
			<br><br>

			<table style="width:900px; height:400px">
			<tr>
				<td>
		 		 Sunday    
				</td>
				
				<td>
		 		 Monday    
				</td>
				
				<td>
			    Tuesday    
				</td>
				
				<td>
			    Wednesday    
				</td>
				
				<td>
			    Thursday    
				</td>
				
				<td>
		 		 Friday   
				</td>
				
				<td>
		 		Saturday   
				</td>
		
			</tr>
			
			
			<tr>
			
			<c:forEach var="temp" items="${daysOfMonth}" begin="0" end="6" step="1" varStatus="loop1">

				<td>${temp.getDayOfMonth()}</td>
		
			</c:forEach>
			
			</tr>
			<tr>
			
			<c:forEach var="temp" items="${daysOfMonth}" begin="7" end="13" step="1" varStatus="loop2">

				<td>${temp.getDayOfMonth()}</td>
		
			</c:forEach>
			</tr>
			
			<tr>
			<c:forEach var="temp" items="${daysOfMonth}" begin="14" end="20" step="1" varStatus="loop3">

				<td>${temp.getDayOfMonth()}</td>
		
			</c:forEach>
			</tr>
			
			<tr>
			<c:forEach var="temp" items="${daysOfMonth}" begin="21" end="27" step="1" varStatus="loop4">

				<td>${temp.getDayOfMonth()}</td>
		
			</c:forEach>
			</tr>
			
			<tr>
			<c:forEach var="temp" items="${daysOfMonth}" begin="28" end="34" step="1" varStatus="loop5">

				<td>${temp.getDayOfMonth()}</td>
		
			</c:forEach>
			</tr>
			
			
			</table>
			<br>
			<br>
		</div>
	</div>

</body>



</html>