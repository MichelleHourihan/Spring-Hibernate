<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Calendar</title>
</head>
<body>
<h1>Hello  ${calendar.month} ${calendar.today}</h1>
<div id="container">
	
		<div id="content">



<c:url var="changeMonthLink" value="/next">
<c:param name="today" value="${calendar.today}" />
</c:url>
<a href="${changeMonthLink}">Next Month</a>
</div>
</div>

</body>



</html>