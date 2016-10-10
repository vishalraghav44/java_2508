
$(document).ready(function() {
	$('#addsub').click(function(e) {
	// Initializing Variables With Form Element Values
	var customer_name = $('#customer_name').val();
	var customer_code = $('#customer_code').val();
	var customer_address1 = $('#customer_address1').val();
	var customer_address2 = $('customer_address2').val();
	var customer_pincode = $('#customer_pincode').val();
	var contact_no = $('#contact_no').val();
	var primary_contact_person = $('#primary_contact_person').val();
	var active_inactive_flag = $('#active_inactive_flag').val();
	var email_address = $('#email_address').val();
	// Initializing Variables With Regular Expressions
	var name_regex = /^[a-zA-Z]+$/;
	//var email_regex = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
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