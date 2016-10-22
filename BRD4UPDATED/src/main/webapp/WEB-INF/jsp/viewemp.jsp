
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Graph Display</title>
<script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
   window.onload = function () {
	 var chart = new CanvasJS.Chart("chartContainer", {
		theme: "theme2",//theme1
		title:{
			text: "EMPLOYEE DEPARTMENT GRAPH BY RAGHAV", 
				fontFamily: "arial black"
		},
		animationEnabled: false,   // change to true
		data: [              
		{
			type: "column",
			click: onClick,
			dataPoints: [
				<c:forEach var="e" items="${list}"> 
				{ label: "${e.dept_id}", y:${e.count}},			   			 			   
			    </c:forEach>
			]
		}
		]
	});
	chart.render();
	function onClick(e) {
		window.location = 'http://10.0.61.62:8080/BRD4UPDATED/empdept/' + e.dataPoint.label;
  }
}
</script>
</head>

<body>
	<center>
		<h1>Table</h1>
		<table border="2" width="70%" cellpadding="2" class="table table-hover">
			<tr class="active">
				<td class="success">Department Id</td>
				<td class="danger">No of Employees</td>
			</tr>
			<c:forEach var="count" items="${list}">
				<tr >
					<td class="warning">${count.dept_id}</td>
					<td class="info" >${count.count}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</center>
	<br>


	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<div id="click">
		<c:choose>
			<c:when test="${!empty employee}">
			<center>
				<form action="http://10.0.61.62:8080/BRD4UPDATED/search">
					<input type="text" name="emp" required/> <input type="submit"
						value="Search" class="btn btn-success"/>
				</form>
				<br>
				<form action="http://10.0.61.62:8080/BRD4UPDATED/sort">
					<select name="name">
						<option value="emp_name">Employee_Name</option>
						<option value="emp_id">Employee_Id</option>
						
					</select> <select name="type">
						<option value="ASC">Ascending</option>
						<option value="DESC">Descending</option>
					</select> <input type="submit" value="Sort" class="btn btn-danger" />
				</form>
				</center>
				<br>
				<center>
					<table border="2" width="70%" cellpadding="2" class="table table-striped">
					<tr>
						<td><b>Employee Id</b></td>
						<td><b>Name</b></td>
						<td><b>Designation</b></td>
						<td><b>Department Id</b></td>
						
						</tr>
						<c:forEach var="count" items="${employee}">
							<tr>
							    <td class="success">${count.emp_id}</td>
							    <td class="info">${count.emp_name}</td>
								<td class="danger">${count.designation}</td>
								<td class="warning">${count.dept.dept_id}</td>
							</tr>
						</c:forEach>
					</table>
				</center>
			</c:when>
			<c:otherwise>
				<div>
					<center>No Match Found....</center>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
