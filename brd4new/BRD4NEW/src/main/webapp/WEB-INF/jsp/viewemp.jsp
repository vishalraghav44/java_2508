    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   <%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  --%> 

	<%-- <h1>Employee Data</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Department Id</th><th>Number Of Employees</th>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.dept_id}</td>
    <td>${emp.count}</td>
    
    </tr>
    </c:forEach>
    </table>
  <br/>
    <a href="graph">Click Here For Graph</a> --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Employes by Department",
			fontFamily: "arial black"
		},
                animationEnabled: true,
		legend: {
			verticalAlign: "bottom",
			horizontalAlign: "center"
		},
		theme: "theme1",
		data: [
		{        
			type: "pie",
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 20,
			indexLabelFontWeight: "bold",
			startAngle:0,
			indexLabelFontColor: "MistyRose",       
			indexLabelLineColor: "darkgrey", 
			indexLabelPlacement: "inside", 
			toolTipContent: "{name}: {y}hrs",
			showInLegend: true,
			indexLabel: "#percent%", 
			dataPoints: [
			<c:forEach var="emp" items="${list}">
				{y: ${emp.count}, name: "${emp.dept_id}"},
			</c:forEach>
			]
		}
		]
	});
	chart.render();
}
</script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script>
</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</body>

</html>
