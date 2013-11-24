<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="placeholder" required="true" rtexprvalue="true"
              description="Type the message you want just like de message.properties" %>

<spring:bind path="${name}">
    <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
    	<spring:message code="${placeholder}" var="message"/>
    	
        <div class="controls">
            <form:input path="${name}" placeholder="${message}"/> 
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>