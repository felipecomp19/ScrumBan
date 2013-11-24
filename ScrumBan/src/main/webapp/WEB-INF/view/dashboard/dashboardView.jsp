<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="dashVM" type="viewModel.DashBoardViewModel" scope="request" />

<t:sbpage>
   	<jsp:body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
					<!-- Left sidebar -->
				</div>
				<div class="span8">
					<div class="row-fluid">
						<div class="span8">
							<div class="page-header">
								<h1>
									<spring:message code="label.projects"/>
									<button style="float:right" data-toggle="modal" data-target="#projectForm">
										<i id="newProject" class="icon-plus-sign icon-white"></i>
									</button>
								</h1>
							</div>
							<table class="table table-hover">
								<thead>
									<tr>
										<th><spring:message code="label.name"/></th>
										<th><spring:message code="label.description"/></th>
										<th><spring:message code="label.createdBy"/></th>
										<th><spring:message code="label.actions"/></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="project" items="${dashVM.projects}">
	  									<tr>
	  										<td>${project.title}</td>
	  										<td>${project.description}</td>
	  										<td>${project.createdByUser.name}</td>
	  										<td>
												<ul class="nav nav-pills">
													<li >
														<a href="scrumboard.html?projectId=${project.id}"><spring:message code="label.Scrumboard"/></a>
													</li>
													<li>
														<spring:url value="/kanban/{projectId}/activities.html" var="kanbanUrl">
			                        						<spring:param name="projectId" value="${project.id}"/>
			                    						</spring:url>
			                    						<a href="${fn:escapeXml(kanbanUrl)}">Kanban</a>
													</li>
													<li>
														<a href="deleteProject.html?id=${project.id}"><spring:message code="label.delete"/></a>
													</li>
												</ul>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="span4">
							<fieldset>
								<legend>Info</legend>
							</fieldset>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<div class="page-header">
								<h1>
									<spring:message code="labe.myActivities"/>
								</h1>
							</div>
							</div>
						</div>
					</div>
				</div>
				<div class="span2">
					<!-- Rigth sidebar -->
				</div>
			</div>
		</div>
		
		<%@include file="projectForm.jsp"%>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui-1.10.3/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    </jsp:body>
</t:sbpage>

