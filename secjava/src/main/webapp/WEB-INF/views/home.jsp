<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
home
<!-- u need post method to do logout href will not work
as by default csrf is eable  -->
<sec:authorize access="hasAnyRole('MGR','ADMIN')">
		<a href="mgr">MGR</a>
		<br />
	</sec:authorize>

	<sec:authorize access="hasRole('ADMIN')">
		<a href="admin">admin</a>
		<br />
	</sec:authorize>


<a href="getallbooks">all books</a>
	
User: <sec:authentication property="principal.username"/>
User profile: <sec:authentication property="principal.authorities"/>
<br>
<c:url var="logout" value="/logout"></c:url>
<form:form action="${logout }" method ="post">
	<input type="submit" value="logout">
</form:form>
</body>
</html>