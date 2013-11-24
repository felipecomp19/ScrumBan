<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="projectForm" class="modal hide fade" tabindex="-1"	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3 id="myModalLabel"><spring:message code="label.newProject"/></h3>
	</div>
	<form method="POST" action="saveProject.html">
		<div class="modal-body">
			<label><spring:message code="label.name"/></label>
			<input name="name" class="span3" type="text" required /> 
			<label><spring:message code="label.description"/></label>
			<textarea name="desc" rows="5" class="span3"></textarea>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary"><spring:message code="label.save"/></button>
			<button type="button" class="btn" data-dismiss="modal"><spring:message code="label.cancel"/></button>
		</div>
	</form>
</div>