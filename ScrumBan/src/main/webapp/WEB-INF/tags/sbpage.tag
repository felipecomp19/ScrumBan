<%@tag description="User Page template" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="baseVM" type="viewModel.BaseViewModel" required="true"%>
<%@attribute name="activeLabel" required="true"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui-1.10.3/js/jquery-1.9.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js" ></script>
	
<script type="text/javascript">
	$(function() {
		var activeId = "#" + "${activeLabel}";
		$(activeId).addClass("active");
	});
</script>

<t:genericpage>
	<jsp:attribute name="header">
 		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ScrumBan</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li id="projects"><a href="#"><spring:message code="label.projects"/></a></li>
					<li id="dashboard"><a href="#">Dashboard</a></li>
					<li id="scrumboard"><a href="#">Scrumboard</a></li>
					<li id="reports"><a href="#"><spring:message code="label.reports"/></a></li>
					<li id="loggedUser"><a href="#"><span class="glyphicon glyphicon-user"></span>   ${baseVM.loggedUser.name}</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->	
		</div>
    </jsp:attribute>

   	<jsp:attribute name="footer">
 		<div id="footer">
      		<div class="container">
      			<p class="muted credit">TexTI 2013 </p>
   		  	</div>
		</div>
    </jsp:attribute>
    
     <jsp:body>
       <jsp:doBody/>
    </jsp:body>
</t:genericpage>