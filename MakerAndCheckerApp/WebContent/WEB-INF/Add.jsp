<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- <script type="text/javascript" src="/MakerAndCheckerApp/WebContent/WEB-INF/validation.js"></script>  -->
<script>

$(document).ready(function() {
	$('#addsub').click(function(e) {
	// Initializing Variables With Form Element Values
	var customer_name = $('#customer_name').val();
	var customer_code = $('#customer_code').val();
	var customer_address1 = $('#customer_address1').val();
	var customer_address2 = $('#customer_address2').val();
	var customer_pincode = $('#customer_pincode').val();
	var contact_no = $('#contact_no').val();
	var primary_contact_person = $('#primary_contact_person').val();
	var active_inactive_flag = $('#active_inactive_flag').val();
	var email_address = $('#email_address').val();
	// Initializing Variables With Regular Expressions
	var name_regex = /^[a-zA-Z]+$/;
	//var email_regex = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	//var email_regex =/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	//var email_regex =/^[0-9a-zA-Z]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	var email_regex =("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,80}))$");
	var add_regex = /^[0-9a-zA-Z]+$/;
	var zip_regex = /^[0-9]+$/;
	// To Check Empty Form Fields.
	if (customer_name.length == 0) {
		alert("invalid username");
		$("#customer_name").focus();
		return false;
	}
	// Validating code.
	else if (customer_code.length >=10 || customer_code.length == 0 ||customer_code.length >=30) {
		alert("* Please enter correct cust code*"); // This Segment Displays The Validation Rule For customer code
		$("#customer_code").focus();
		return false;
	}
	// Validating Name Field.
	else if (customer_name.length == 0 ||!customer_name.match(add_regex)||!customer_name.match(add_regex)) {
		alert("For your name please use alphabets only "); // This Segment Displays The Validation Rule For Name
		$("#customer_name").focus();
		return false;
	}

	// Validating Email Field.
	else if (!email_address.match(email_regex) || email_address.length == 0) {
		alert("* Please enter a valid email address *"); // This Segment Displays The Validation Rule For Email
		$("#email_address").focus();
	return false;
	}

	// Validating Select Field.
	else if (active_inactive_flag == "Please Choose") {
		alert.text("* Please Choose any one option"); // This Segment Displays The Validation Rule For Selection
		$("#active_inactive_flag").focus();
	return false;
	}
	// Validating Address Field.
	else if (!customer_address1.match(add_regex) || customer_address1.length == 0 || customer_address1.length >=100) {
		alert("* For Address please use numbers and letters *"); // This Segment Displays The Validation Rule For Address
		$("#customer_address1").focus();
	return false;
	}
	// Validating Address Field2.
	else if (!customer_address2.match(add_regex)|| customer_address2.length >=100) {
		alert("* For Address please use numbers and letters *"); // This Segment Displays The Validation Rule For Address
		$("#customer_address2").focus();
		return false;
	}
	// Validating cust pin.
	else if (!customer_pincode.match(zip_regex) || customer_pincode.length == 0 || customer_pincode.length !=6) {
		alert("* Please enter a valid pin code *"); // This Segment Displays The Validation Rule For Zip
		$("#customer_pincode").focus();
		return false;
	} 
	// Validating cust no.
	else if (!contact_no.match(zip_regex)|| contact_no.length >=20) {
		alert("* Please enter a valid contact no*"); // This Segment Displays The Validation Rule For contact
		$("#contact_no").focus();
		return false;
	} 
	// Validating cust primary contact person
	else if (primary_contact_person.length == 0 || !primary_contact_person.match(add_regex) || !primary_contact_person.match(name_regex)||primary_contact_person.length >=100) {
		alert("* Please enter a valid name*"); // This Segment Displays The Validation Rule For Zip
		$("#primary_contact_person").focus();
		return false;
	} 
	else {
		alert("Form Submitted Successfuly!");
		return true;
	}
});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<center><h1>CREATE CUSTOMER PROFILE</h1></center>
<P></P>
<form method="get" action="http://localhost:8080/MakerAndCheckerApp/CrudController">
<center>
<div class="container">
<div class="well">
<table class="table table-striped">

<tr class="warning">
 <td><b>Customer Name</b></td>
   <td><input type="text" id="customer_name" name="customer_name"></td>
</tr>

<tr class="warning">
 <td><b> Customer Code </b></td>
     <td><input type="text" id="customer_code" name="customer_code"></td>
</tr>

<tr class="danger">
<td><b>Customer Address 1</b></td>
  <td> <textarea id="customer_address1" name="customer_address1" rows="10" cols="30">
</textarea></td>
</tr>
<tr class="info">
   <td> <b>Customer Address 2</b></td>
 <td> <br> <textarea id="customer_address2" name="customer_address2" rows="10" cols="30">
  </textarea></td>
</tr>
<tr class="danger">
  <td><b>Customer Pincode</b></td>
    <td><input type="text" id="customer_pincode" name="customer_pincode"></td>
  </tr>
  
   <tr class="info">
  <td><b>Customer Contact No </b></td>
     <td><input type="text" id="contact_no" name="contact_no"></td>
  </tr>
  
   <tr class="danger">
  <td><b>Primary Contact Person </b></td>
 <td> <br> <input type="text" id="primary_contact_person" name="primary_contact_person"></td>
    </tr>
   
   <tr class="warning">
 <td> <b>Flag </b></td>
<td><select id="active_inactive_flag" name="active_inactive_flag">
<option value=0>Select Status</option>
<option value="a">Active</option>
<option value="i">Inactive</option></select></td>
  </tr>
   
<tr class="warning">
 <td> <b>Customer Email Address</b></td>
  <td><br> <input type="text" id="email_address" name="email_address"></td>
  </tr>

  <tr class="danger">
  <td><b>Primary Contact Person </b></td>
 <td> <br> <input type="text" id="primary_contact_person" name="primary_contact_person"></td>
    </tr>
   
    <tr class="info">
     <td><b>Record Status </b></td>
  <td><br> <input type="text" id="record_status" name="record_status"></td>
   </tr>
   
   
  
  <tr class="success">
  <td><b>Create Date</b></td>
  <td> <input type="text" id="create_date" name="create_date"></td>
   </tr>
   
   <tr  class="danger">
     <td><b>Created By</b></td>
  <td><input type="text" id="created_by" name="created_by"></td>
  </tr>
  
   <!--  <tr class="success">
  <td><b>Modified Date</b></td>
  <td><input type="text"  id="modified_date" name="modified_date"></td>
  </tr>
  
  <tr class="info">
  <td><b>Modified By</b></td>
   <td><input type="text"  id="modified_by" name="modified_by"></td>
</tr>

    <tr class="success">
 <td><b> Authorized Date</b></td>
   <td><input type="text" id="authorized_date" name="authorized_date"></td>
   </tr>
   
   <tr class="danger">
  <td><b>Authorized By</b></td>
<td><input type="text" id="authorized_by" name="authorized_by"></td>
   </tr> -->
  
  </table>
  </div>
  </div>
<br> <input type="submit" class="btn btn-primary" id="addsub"  name="addsub" value="Submit To Add">

</center>
</form>

</body>
</html>