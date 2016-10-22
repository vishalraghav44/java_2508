<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Employee</title>
</head>
<body>
	<center>
		<h2>Add Employee</h2>
		</br> </br>
		<form:form method="post" action="add" commandName="employee">

			<table>
				<tr>
					<td><form:label path="EId">
							<spring:message code="label.EId" />
						</form:label></td>
					<td><form:input path="EId" /></td>
				</tr>
				<tr>
					<td><form:label path="EName">
							<spring:message code="label.EName" />
						</form:label></td>
					<td><form:input path="EName" /></td>
				</tr>
				<tr>
					<td><form:label path="dept.DId">
							<spring:message code="label.dept.DId" />
						</form:label></td>
					<td><form:input path="dept.DId" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Add"
						class="btn-success" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>