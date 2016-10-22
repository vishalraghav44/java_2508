<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
		<h1>Access is denied</h1>
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"></form>
		<form action="http://10.0.61.62:8080/BRD4UPDATED/back" id="backForm"></form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}

			function formBack() {
				document.getElementById("backForm").submit();
			}
		</script>
		<c:choose>
			<c:when test="${empty username}">
				<h2>You do not have permission to access this page!</h2>
			</c:when>
			<c:otherwise>
				<h2>You do not have permission to access this page!</h2>
			</c:otherwise>
		</c:choose>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
           <h2>
				${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a> <br />
				<a href="javascript:formBack()"> Back</a>
			</h2>
		</c:if>
	</center>
</body>
</html>