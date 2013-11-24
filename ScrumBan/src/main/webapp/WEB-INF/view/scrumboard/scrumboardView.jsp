<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page import="viewModel.*"%>
<%@page import="model.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vm" type="viewModel.ScrumBoardViewModel" scope="request" />

<t:sbpage>
	<jsp:body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
				
				</div>
				<div class="span8">
					<div class="page-header">
						<h1>Scrumboard</h1>
					</div>
					<button data-toggle="modal" data-target="#activityForm">
							<spring:message code="label.newActivity" />
					</button>
					<table class="table table-hover">
						<thead>
							<tr>
								<th><spring:message code="label.name" /></th>
								<th><spring:message code="label.description" /></th>
								<th><spring:message code="label.project" /></th>
								<th><spring:message code="label.assignedUser" /></th>
								<th><spring:message code="label.actions" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="act" items="${vm.activities}">
								<tr>
									<td>${act.name}</td>		
									<td>${act.description}</td>
									<td>${act.project}</td>
									<td>${act.assignedUser}</td>
									<td>TO-DO</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="span2">
				
				</div>
			</div>
		</div>
		
		
		<%@include file="activityForm.jsp"%>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui-1.10.3/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
	</jsp:body>
</t:sbpage>