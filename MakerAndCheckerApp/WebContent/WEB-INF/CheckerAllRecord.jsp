<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="loop" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer info</title>
<meta name="viewport" content="width=device-width, initial scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style>
body {
	background-color:Cornsilk ;
}
</style>
</head>
<body>
	<center>
			<h1>All Customer Records</h1>
			<br>
			<br>
				<table border="2">
					<tr class="warning">
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
					<loop:forEach var="arrlist" items="${arrlist}">
					<tr class="info">
					<td><loop:out value=" ${arrlist.getCustomer_name()}"/></td>
					<td><loop:out value=" ${arrlist.getCustomer_code()}"/></td>
					<td><loop:out value=" ${arrlist.getCustomer_address1()}"/></td>
					<td><loop:out value=" ${arrlist.getCustomer_address2()}"/></td>
					<td><loop:out value=" ${arrlist.getCustomer_pincode()}"/></td>
					<td><loop:out value=" ${arrlist.getContact_no()}"/></td>
					<td><loop:out value=" ${arrlist.getPrimary_contact_person()}"/></td>
					<td><loop:out value=" ${arrlist.getActive_inactive_flag()}"/></td>
					<td><loop:out value=" ${arrlist.getEmail_address()}"/></td>
					<td><loop:out value=" ${arrlist.getRecord_status()}"/></td>
					<td><loop:out value=" ${arrlist.getCreate_date()}"/></td>
					<td><loop:out value=" ${arrlist.getCreated_by()}"/></td>
					<td><loop:out value=" ${arrlist.getModified_date()}"/></td>
					<td><loop:out value=" ${arrlist.getModified_by()}"/></td>
					<td><loop:out value=" ${arrlist.getAuthorized_date()}"/></td>
					<td><loop:out value=" ${arrlist.getAuthorized_by()}"/></td>
					</tr>
					</loop:forEach>
					
				</table>
				<br/>
				<form action="http://localhost:8080/MakerAndCheckerApp/CrudController">
				<div class ="container">
				<input type="submit" name="checkerback" value="back " class="btn btn-success" />
				</div>
				</form>
				
	</center>
</body>
</html>