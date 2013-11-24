<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="activityForm" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3 id="myModalLabel"><spring:message code="label.newActivity"/></h3>
	</div>
	<form method="POST" action="scrumboard/saveActivity.html">
		<div class="modal-body">
			<input type="hidden" name="projectId" value="${vm.project.id}">
			<label><spring:message code="label.name"/></label>
			<input name="name" class="span5" type="text" required /> 
			
			<label><spring:message code="label.description"/></label>
			<textarea name="description" rows="3" class="span5"></textarea>
			
			<label><spring:message code="label.createdDate" /><c:out value=": ${vm.activity.createdDate}"/></label>
			<label><spring:message code="label.createdBy"/><c:out value=": ${vm.activity.createdByUser}"/></label>

			<label><spring:message code="label.status" /></label>
			<select name="status">
				<c:forEach items="${vm.statusList}" var="status">
					<option value="${status.id}">${status.description}</option>
				</c:forEach>
			</select>

			<label><spring:message code="label.assignedUser" /></label>
			<select name="assignedUser">
				<c:forEach items="${vm.userList}" var="assignedUser">
					<option value="${assignedUser.id}">${assignedUser.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Salvar</button>
			<button type="button" class="btn" data-dismiss="modal">Cancelar</button>
		</div>
	</form>
</div>