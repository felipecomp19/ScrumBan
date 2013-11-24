<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="header">
    	<%@include file="../view/shared/navbar.jsp"%>
    </jsp:attribute>
	<jsp:attribute name="footer">
 		<div id="footer">
      		<div class="container">
      			<p class="muted credit">TexTI 2013</p>
   		  	</div>
		</div>
    </jsp:attribute>
   	<jsp:body>
       <jsp:doBody/>
    </jsp:body>
</t:genericpage>