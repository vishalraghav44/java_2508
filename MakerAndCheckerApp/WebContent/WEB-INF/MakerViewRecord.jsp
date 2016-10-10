<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="loop" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<meta name="viewport" content="width=device-width, initial scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<center>
			<h1>Customer List</h1>
			<br>
			<br>
				<table border="2">
					<tr>
					<td><b>Customer Name</b></td>	
					<td><b>Customer Code</b></td>	
					<td><b>Customer Address 1</b></td>	
					<td><b>Customer Address 2</b></td>	
					<td><b>Customer Pin code</b></td>	
					<td><b>Customer Contact No</b></td>	
					<td><b>Primary Contact Person </b></td>	
					<td><b>Flag</b></td>	
					<td><b>Customer Email Address</b></td>	
					<td><b>Record Status</b></td>	
					<td><b>Create Date</b></td>	
					<td><b>Created By</b></td>	
					<td><b>Modified Date</b></td>	
					<td><b>Modified By</b></td>	
					<td><b> Authorized Date</b></td>	
					<td><b>Authorized By</b></td>	
					</tr>
					<loop:forEach var="list" items="${list}">
					<tr>
					<td><loop:out value=" ${list.getCustomer_name()}"/></td>
					<td><loop:out value=" ${list.getCustomer_code()}"/></td>
					<td><loop:out value=" ${list.getCustomer_address1()}"/></td>
					<td><loop:out value=" ${list.getCustomer_address2()}"/></td>
					<td><loop:out value=" ${list.getCustomer_pincode()}"/></td>
					<td><loop:out value=" ${list.getContact_no()}"/></td>
					<td><loop:out value=" ${list.getPrimary_contact_person()}"/></td>
					<td><loop:out value=" ${list.getActive_inactive_flag()}"/></td>
					<td><loop:out value=" ${list.getEmail_address()}"/></td>
					<td><loop:out value=" ${list.getRecord_status()}"/></td>
					<td><loop:out value=" ${list.getCreate_date()}"/></td>
					<td><loop:out value=" ${list.getCreated_by()}"/></td>
					<td><loop:out value=" ${list.getModified_date()}"/></td>
					<td><loop:out value=" ${list.getModified_by()}"/></td>
					<td><loop:out value=" ${list.getAuthorized_date()}"/></td>
					<td><loop:out value=" ${list.getAuthorized_by()}"/></td>
					</tr>
					</loop:forEach>
					
				</table>
				<br/>
				<form action="http://localhost:8080/MakerAndCheckerApp/CrudController">
				<div class ="container">
				<input type="submit" name="back" value="back " class="btn btn-success" />
				</div>
				</form>
				
	</center>
</body>
</html>