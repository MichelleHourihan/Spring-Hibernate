<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title> List Customers</title>
	<link type = "text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!-- Add customer button -->
		
		<input type="button" value="Add Customer"
				onclick="window.location.href='showForm'; return false;"
				class="add-button" />
			
			<!-- add our html table here -->
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
				
			<!-- loop over and print customer -->
			
				<c:forEach var="temp" items="${customers}">
				
				<!-- construct an udate link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${temp.id}" />
				</c:url>
				
				<!-- construct an delete link with customer id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${temp.id}" />
				</c:url>
				
					<tr>
						<td> ${temp.firstName}</td>
						<td> ${temp.lastName}</td>
						<td> ${temp.email}</td>
						<td> 
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
								onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
							
						</td>
						
					</tr>
				
				</c:forEach>
				
	 		</table>
		
		</div>
	</div>

</body>
</html>