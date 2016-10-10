<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="jquery-3.1.1.min.js"></script>
<style>
body {
	background-color: powderblue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maker Page</title>
</head>
<body >
<center>
<h1> Welcome Maker</h1>
<p>
<h3>Please Select your Option</h3>
<p></p>
<p></p>
<p></p>
</center>
<form name="makerform" action="http://localhost:8080/MakerAndCheckerApp/CrudController" method="get">
<div align="center">
<select name="choice">
<option value="option">Select</option>
<option value="add">Add-Record</option>
<option value="update">Update-Record</option>
<option value="delete">Delete-Record</option>
<option value="search">Search-Record</option>
<option value="searchall">Search-All-Record</option>
</select>
<input type="submit" class="btn btn-success" name="makerbutton" value="submit">
</div>
</form>


</body>

</html>