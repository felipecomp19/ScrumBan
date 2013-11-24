<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
              description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="placeholder" required="false" rtexprvalue="true"
              description="Text inside the inputfield" %>

<spring:bind path="${name}">
    <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
    	<c:choose>
    		<c:when test="${empty placeholder}">
    			<c:set var="message" value=""/>
   			</c:when>
   			<c:otherwise>
   				<spring:message code="${placeholder}" var="message"/>
			</c:otherwise>	
    	</c:choose>
    	
        <label class="control-label"><spring:message code="${label}"/></label>
        <div class="controls">
            <form:input path="${name}" placeholder="${message}"/> 
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>