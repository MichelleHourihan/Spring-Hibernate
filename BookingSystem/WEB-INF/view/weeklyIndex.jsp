<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Calendar</title>
<link type = "text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<style>
	/* The popup form - hidden by default */
.form-popup {

  display: none;
  position: fixed;
  bottom: 50px;
  right: 200px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {

  max-width: 350px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 90%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>

<script> function openForm(x, y) {
	var bool = x;
	alert(y);
	alert(bool);
	if(bool == "true"){
	alert("hi");
	alert(y);
		document.getElementById(y).submit();
		//var forms= document.getElementsById(form).submit();
		//document.getElementById("myForm").style.display = "block";
		//document.getElementById("place").setAttribute("placeholder", x);
		//window.showModalDialog("popup", "dialogHeight: 260px; dialogWidth: 350px; center: Yes; edge:Raised"));

	}
}

function color(x, y){
	var bool= x;
	alert(y);
	alert(bool);
	if(bool=="true"){
		alert("color");
		}
}
 </script>
 
</head>
<body>
<h1>Today:  ${calendar.today}  Week: ${calendar.weekOfYear}</h1>
<div id="container">
	
		<div id="content">


<c:url var="changeLastWeekLink" value="/lastWeek">
<c:param name="today" value="${calendar.today}" />
</c:url>
<a href="${changeLastWeekLink}">Last Week</a>
&nbsp;
Week ${calendar.weekOfYear}
&nbsp;
<c:url var="changeWeekLink" value="/nextWeek">
<c:param name="today" value="${calendar.today}" />
</c:url>
<a href="${changeWeekLink}">Next Week</a>
&nbsp;&nbsp;&nbsp;

<c:url var="changeThisWeekLink" value="/weekCalendar">
</c:url>
<a href="${changeThisWeekLink}">This Week</a>
&nbsp;
<c:url var="monthly" value="/">
<c:param name="today" value="${calendar.today}" />
</c:url>
<a href="${monthly}">Monthly</a>
<br>
<br>
<table style="width:900px; height:800px">
	
	<tr><th> &nbsp;</th>
	
			<c:forEach var="temp" items="${slotsInWeek}" begin= "0" end = "6" step = "1" varStatus = "count">

			<th>
							${temp.getStart().getDayOfWeek()} <br> ${temp.getStart().getDayOfMonth()} ${temp.getStart().getMonth()}
						</th>
	
			</c:forEach>
		</tr>
		

				
			<tr>
			<td>07:00</td>
					<c:forEach var="temp" items="${slotsInWeek}" begin="0" end="6"
						step="1" varStatus="count">

						<td>
							<form id="$data1_${count.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onload="('${temp.getStatus()}','$data1_${count.count}')" onclick="openForm('${temp.getStatus()}','$data1_${count.count}')" />
							</form>
						</td>

					</c:forEach>
				</tr>
		
		 <tr>
		 <td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin="7" end="13"
						step="1" varStatus="count2">

						<td>
							<form id="$data2_${count2.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data2_${count2.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>7:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin="14" end="20"
						step="1" varStatus="count3">

						<td>
							<form id="$data3_${count3.count}" action="popup" method="GET">
								<input type="hidden" name="temp" value="${temp.getStart()}" /> 
								<input
									type="button" type="hidden" class="booking_button" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data3_${count3.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr>
		 <td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin="21" end="27"
						step="1" varStatus="count4">

						<td>
							<form id="$data4_${count4.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data4_${count4.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>8:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin="28" end="34"
						step="1" varStatus="count5">

						<td>
							<form id="$data5_${count5.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data5_${count5.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr>
		 <td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin="35" end="41"
						step="1" varStatus="count6">

						<td>
							<form id="$data6_${count6.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$dataa_${count6.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>8:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "42" end = "48" step = "1" varStatus="count7">

						<td>
							<form id="$data7_${count7.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data7_${count7.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "49" end = "55" step = "1" varStatus="count8">

						<td>
							<form id="$data8_${count8.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data8_${count8.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>9:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "56" end = "62" step = "1" varStatus="count9">

						<td>
							<form id="$data9_${count9.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data9_${count9.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "63" end = "69" step = "1" varStatus="count10">

						<td>
							<form id="$data10_${count10.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data10_${count10.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>9:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "70" end = "76" step = "1" varStatus="count11">
			<td>
							<form id="$data11_${count11.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data11_${count11.count}')" />
							</form>
						</td>
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "77" end = "83" step = "1" varStatus="count12">
						<td>
							<form id="$data12_${count12.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data12_${count12.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>10:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "84" end = "90" step = "1" varStatus="count13">

						<td>
							<form id="$data13_${count13.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data13_${count13.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "91" end = "97" step = "1" varStatus="count14">

						<td>
							<form id="$data14_${count14.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data14_${count14.count}')" />
							</form>
						</td>
					</c:forEach>
		</tr>
		 <tr><td>10:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "98" end = "104" step = "1" varStatus="count15">

						<td>
							<form id="$data15_${count15.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data15_${count15.count}')" />
							</form>
						</td>
					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "105" end = "111" step = "1" varStatus="count16">

						<td>
							<form id="$data16_${count16.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data16_${count16.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
			 <tr><td>11:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "112" end = "118" step = "1" varStatus="count17">

						<td>
							<form id="$data17_${count17.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data17_${count17.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "119" end = "125" step = "1" varStatus="count18">

						<td>
							<form id="$data18_${count18.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data18_${count18.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>11:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "126" end = "132" step = "1" varStatus="count19">

						<td>
							<form id="$data19_${count19.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data19_${count19.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "133" end = "139" step = "1" varStatus="count20">

						<td>
							<form id="$data20_${count20.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data20_${count20.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>12:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "140" end = "146" step = "1" varStatus="count21">

						<td>
							<form id="$data21_${count21.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data21_${count21.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "147" end = "153" step = "1" varStatus="count22">

						<td>
							<form id="$data22_${count22.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data22_${count22.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>12:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "154" end = "160" step = "1" varStatus="count23">

						<td>
							<form id="$data23_${count23.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data23_${count23.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "161" end = "167" step = "1" varStatus="count24">

						<td>
							<form id="$data24_${count24.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data24_${count24.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>13:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "168" end = "174" step = "1" varStatus="count25">

						<td>
							<form id="$data25_${count25.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data25_${count25.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "175" end = "181" step = "1" varStatus="count26">

						<td>
							<form id="$data26_${count26.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data26_${count26.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>13:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "182" end = "188" step = "1" varStatus="count27">

						<td>
							<form id="$data27_${count27.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data27_${count27.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "189" end = "195" step = "1" varStatus="count28">

						<td>
							<form id="$data28_${count28.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data28_${count28.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>14:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "196" end = "202" step = "1" varStatus="count29">

						<td>
							<form id="$data29_${count29.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data29_${count29.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "203" end = "209" step = "1" varStatus="count30">

						<td>
							<form id="$data30_${count30.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data30_${count30.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>14:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "210" end = "216" step = "1" varStatus="count31">

						<td>
							<form id="$data31_${count31.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data31_${count31.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "217" end = "223" step = "1" varStatus="count32">

						<td>
							<form id="$data32_${count32.count}" action="popup" method="GET">
								<input type=hidden name="temp" value="${temp.getStart()}" /> <input
									type="button" class="form" value="${temp.getStart()}"
									onclick="openForm('${temp.getStatus()}','$data32_${count32.count}')" />
							</form>
						</td>

					</c:forEach>
		</tr>
		 <tr><td>15:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "224" end = "230" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "231" end = "237" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td>15:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "238" end = "244" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "245" end = "251" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td>16:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "252" end = "258" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "259" end = "265" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td>16:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "266" end = "272" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "273" end = "279" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td>17:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "280" end = "286" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "287" end = "293" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td>17:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "294" end = "300" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		 <tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "301" end = "307" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		<tr><td>18:00</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "308" end = "314" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		<tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "315" end = "321" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		<tr><td>18:30</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "322" end = "328" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		<tr><td> &nbsp;</td>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "329" end = "335" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="temp" items="${slotsInWeek}" begin= "336" end = "342" step = "1">

			<td>${temp.getStatus()}</td>
	
			</c:forEach>
		</tr>
		
</table>
	<div class="form-popup" id="myForm">
							<form action="/action_page.php" class="form-container">
								<h1>New Reservation</h1>

								<label for="start"><b>From</b></label>
								 <input id="place" type="text" placeholder="hello" name="name" > 
								 <label for="name"><b>Name</b></label> <input type="text"
									placeholder="Enter Name" name="name" required> <label
									for="email"><b>Password</b></label> <input type="password"
									placeholder="Enter Password" name="psw" required>

								<button type="submit" class="btn">Login</button>
								<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
							</form>
						</div>
</div>
</div>

</body>



</html>