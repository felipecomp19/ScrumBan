<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="scrumban" tagdir="/WEB-INF/tags" %>

<div id="activityForm" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<c:choose>
        <c:when test="${activity['new']}">
            <c:set var="method" value="post"/>
        </c:when>
        <c:otherwise>
            <c:set var="method" value="put"/>
        </c:otherwise>
    </c:choose>
    
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3 id="myModalLabel">
			<c:if test="${activity['new']}"><spring:message code="label.new"/></c:if>
			<spring:message code="label.activity" />
		</h3>
	</div>
	
	<form:form modelAttribute="activity" method="${method}" >
		<div class="modal-body">
			<form:hidden path="project.id"/>
			<scrumban:inputField name="name" placeholder="label.activityName"/>
			<scrumban:dropDownField label="label.assignedUser" name="assignedUser" names="${members}" />
			<scrumban:dropDownField label="label.status" name="status" names="${status}" />
			<scrumban:textField label="label.description" name="description" rows="5" cols="10" />
			
			<!-- make it tooltip -->
			<label class="control-label"><spring:message code="label.createdDate" /></label>
			<c:out value="${createdDate }" />
			<label class="control-label"><spring:message code="label.createdBy" /></label>
			<c:out value="${createdByUser.name}" />
		</div>
		<div class="form-actions">
           <button type="submit" class="btn btn-primary"><spring:message code="label.save"/></button>
           <button type="button" class="btn" data-dismiss="modal"><spring:message code="label.cancel"/></button>
	   	</div>
	</form:form>
</div>