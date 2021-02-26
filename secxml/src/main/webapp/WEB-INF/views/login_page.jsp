<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.error!=null }">
		<i>You have invalid username/password!</i>
	</c:if>


	<c:if test="${param.logout!=null }">
		<i>You logged out successfully!</i>
	</c:if>


	<c:url var="url" value="/loginprocess"></c:url>
	<form:form action="${url }" method="Post">
	User:<input type='text' name='username'>
		<br />
	Password:<input type='password' name='password' />
		<br />
		<input name="submit" type="submit" value="Login" />
	</form:form>
</body>
</html>