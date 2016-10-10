<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Update Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String u = (String) session.getAttribute("uname");
		out.print("Welcome " + u + "<br/>Role: MAKER<br/><br/>");
	%>
	<center>
	<table border="2">
		<h1>Update Customer Profile</h1>
		
		<form action="http://localhost:8087/MakerChecker/CrudController" method="get">
			
		<tr>
			<td>		<b>Customer Name: </b> </td>
			<td><input type="text" id="customer_name" name="customer_name"
					value="${list.getCustName()}"></td>
		</tr>
				
			<tr>	
				<td><b>Customer Code: </b></td>
				<td><input type="text" id="customer_code" name="customer_code"
					value="${list.getCustomer_code()}"></td>
			</tr>
			
			<tr>	
				<td><b>Customer Address 1: </b></td>
				 <td><textarea id="customer_address1" name="customer_address1" rows="10" cols="30"
                   	value="${list.getCustomer_address1()}"></textarea></td>
			</tr>
			
			<tr>	
				<td><b>Customer Address 2: </b>
				 <td><textarea id="customer_address2" name="customer_address2" rows="10" cols="30"
                   	value="${list.getCustomer_address2()}"> </textarea>
			</tr>
			
			<tr>	
				<td><b>Customer Pin code: </b>
				<td><input type="text" id="customer_pincode" name="customer_pincode"
					value="${list.getCustomer_pincode()}">
			</tr>
			
			<tr>	
				<td><b>Customer Contact No: </b>
				<td><input type="text" id="contact_no" name="contact_no"
					value="${list.getCustomer_name()}">
			</tr>
			
			<tr>	
				<td><b>Primary Contact Person: </b>
				<td><input type="text" id="primary_contact_person" name="primary_contact_person"
					value="${list.getPrimary_contact_person()}">
			</tr>
				
			<tr>
				<td><b>Flag: </b></td>
				<td><select id="active_inactive_flag" name="choice3">
					<option value=0>Select Status</option>
					<option value=I>Inactive</option>
					<option value=A>Active</option>
				</select></td>
			</tr>
			
			<tr>	
				<td><b>Customer Email Address: </b></td>
				<td><input type="text" id="email_address" name="email_address"
					value="${list.getCustEmail()}"></td>
				<br />
				
			<tr>
				<td><b>Record Status: </b></td>
				<td><select id="record_status" name="choice2">
					<option value=0>Select Status</option>
					<option value=N>New</option>
					<option value=A>Authorized</option>
					<option value=M>Modified</option>
					<option value=D>Deleted</option>
					<option value=R>Rejected</option>
				</select></td>
			</tr>
			
			<tr>	
				<td><b>Create Date: </b></td>
				<td><input type="text" id="create_date" name="create_date"
					value="${list.getCreate_date()}"></td>
			</tr>
			
			<tr>	
				<td><b>Created By: </b></td>
				<td><input type="text" id="created_by" name="created_by"
					value="${list.getCreated_by()}"></td>
			</tr>
				
			<tr>
				<td><b>Modified Date: </b></td>
				<input type="text" name="modified_date"
					value="${list.getModified_date()}"></td>
			</tr>
			
			<tr>	
				<td><b>Modified By: </b></td>
				<td><input type="text" name="modified_by"
					value="${list.getModified_by()}"></td>
			</tr>
				
			<tr>	
				<td><b>Authorized Date: </b></td>
				<td><input type="text" name="authorized_date"
					value="${list.getAuthorized_date()}"></td>
			</tr>
				
			<tr>
				<td><b>Authorized By: </b></td>
				<td><input type="text" name="authorized_by"
					value="${list.getAuthorized_by()}"></td>
			</tr>
			
				<div class="container">
				<input type="submit" name="updatesub" value="Submit"
					class="btn btn-info">
				<input type="submit" name="back" value="Cancel" class="btn btn-danger">
			</div>
			
		</form>
</table>
	</center>
</body>
</html>