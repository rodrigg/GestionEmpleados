<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Trabajo Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="trabajo">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="nref">nºref </label> </td>
				<td><form:input path="nref" id="nref"/></td>
				<td><form:errors path="nref" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="lugar">Lugar</label> </td>
				<td><form:input path="lugar" id="lugar"/></td>
				<td><form:errors path="lugar" cssClass="error"/></td>
		    </tr>
			<tr>
			<tr>
				<td>
					<form:select path="clientes" items="${clientesList}" multiple="true"
								 itemValue="id" itemLabel="nombre" />
 				</td>
			</tr>
											
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='trabajos/list' />">List of All Trabajos</a>
</body>
</html>