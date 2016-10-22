<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<%-- <center> --%>
		<h1>Welcome</h1>

		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"></form>
		<form
			action="http://10.0.61.62:8080/BRD4UPDATED/viewemp/${pageContext.request.userPrincipal.name}"
			id="viewForm"></form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
			function viewSubmit() {
				document.getElementById("viewForm").submit();
			}
		</script>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a><a
					href="javascript:viewSubmit()/${pageContext.request.userPrincipal.name}">
					View Employees</a>
			</h2>
		</c:if>
	<%-- </center> --%>
</body>
</html>