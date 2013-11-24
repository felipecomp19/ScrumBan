<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="viewModel.*"%>
<%@page import="model.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:useBean id="vm" type="viewModel.ScrumBoardViewModel" scope="request" />

<html>
<%@include file="../shared/head.jsp"%>
<body>
	<%@include file="../shared/navbar.jsp"%>

	<div class="container">
		<fieldset>
			<legend>
				<spring:message code="label.activities"/>
				<button data-toggle="modal" data-target="#activityForm">
					<i id="newActivity" class="icon-plus-sign"> </i>
				</button>
			</legend>
			<table class="table-striped">
				<thead>
					<tr>
						<td><spring:message code="label.project"/></td>
						<td><spring:message code="label.name"/></td>
						<td><spring:message code="label.description"/></td>
						<td><spring:message code="label.status"/></td>
						<td><spring:message code="label.actions"/></td>
					</tr>
				</thead>
				<tbody>
					<%
						ProjectModel p = vm.getProject();
						for (ActivityModel a : p.getActivities() ) {
					%>
					<tr>
						<td><%=p.getTitle()%></td>
						<td><%=a.getName() %></td>
						<td><%=a.getDescription()%></td>
						<td><%=a.getStatus()%></td>
						<td>
							<ul class="nav nav-pills">
								<li >
									<a href="scrumboard.html?projectId=<%=a.getId()%>"><spring:message code="label.edit"/></a>
								</li>
								<li>
									<a href="deleteProject.html?id=<%=a.getId()%>"><spring:message code="label.delete"/></a>
								</li>
							</ul>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</fieldset>

		<!-- Activity Modal Form -->
		<div id="activityForm" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 id="myModalLabel">
					<spring:message code="label.newActivity" />
				</h3>
			</div>
			<form method="POST" action="saveActivity.html">
				<div class="modal-body">
					<input type="hidden" name="projectId" value=<%=vm.getProject().getId()%>>
					
					<label><spring:message code="label.name" /></label> 
					<input name="name" class="span3" type="text" required /> 
					
					<label><spring:message code="label.description" /></label>
					<textarea name="desc" rows="5" class="span3"></textarea>
					
					<label>
						<spring:message code="label.createdDate"/><%=vm.getActivity().getCreatedDate()%>
					</label>
					
					<label><spring:message code="label.status" /></label>
					<select name="status">
						<% for(StatusModel s : vm.getStatusList()) { %>
							<option value="<%=s.getId()%>" ><%=s.getDescription()%></option>
						<% } %>
					</select>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal">Cancelar</button>
				</div>
			</form>
		</div>

		<%@include file="../shared/footer.jsp" %>
	</div>
</body>
</html>