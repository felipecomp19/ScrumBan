<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:sbpage>
   	<jsp:body>
   		<div class="container-fluid">
   			<div class="row-fluid">
   				<div class="span12">
   					<div class="btn-group">
  						<button class="btn" data-toggle="modal" data-target="#activityForm">
  							<spring:message code="label.newActivity" />
						</button>
  						<button class="btn">Middle</button>
  						<button class="btn">Right</button>
					</div>
   				</div>
   			</div>
   			<div class="row-fluid">
   				<div class="span6">
   					<c:forEach var="act" items="${project.activities}">
   						<p>${act.name} </p>
   					</c:forEach>
   				</div>
   				<div class="span6">
   					<c:forEach var="act" items="${project.activities}">
   						<p>${act.name} </p>
   					</c:forEach>
   				</div>
   			</div>
   		</div>
   		
   		<jsp:include page="../activity/createOrUpdateActivityForm.jsp"/>
   		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui-1.10.3/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
   	</jsp:body>
</t:sbpage>

