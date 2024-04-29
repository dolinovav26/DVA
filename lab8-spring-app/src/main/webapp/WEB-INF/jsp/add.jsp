<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form:form method="post" modelAttribute="user">
<form:hidden path="id"/><br>
            First name:
<form:input type="text" path="firstName" /><br>
            Last name:
<form:input type="text" path="lastName" /><br>
            Date of birth:
<form:input type="text" path="dateOfBirth"/><br>
            <input type="submit" name="okButton" value="Ok">
 spring:url value="/users/browse.html" var="browseUrl"/>
<input type="submit" name="cancelButton" value="Cancel"
onclick="location.href='${browseUrl}'; return false">
</form:form>