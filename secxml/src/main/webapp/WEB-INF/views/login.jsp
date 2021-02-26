
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

 <head>
   <title>Spring Security Login page</title>
 </head>
 
<h2>Custom Login Form</h2>
  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to 
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
    
  <form:form action='loginprocess' method='POST'>
	 <table>
	    <tr>
	      <td>User Name:</td>
	      <td><input type='text' name='username'></td>
	    </tr>
	    <tr>
	      <td>Password:</td>
	      <td><input type='password' name='password'/></td>
	    </tr>
	    
	    <tr>
	      <td colspan='2'>
	        <input name="submit" type="submit" value="Login"/></td>
	    </tr>
	  </table>
  </form:form>
  
</body>
