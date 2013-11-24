<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<html>
  <%@include file="../view/shared/head.jsp"%>
  <body>
	  <div id="wrap">
		    <div id="pageheader">
		      <jsp:invoke fragment="header"/>
		    </div>
		    <div id="body">
		      <jsp:doBody/>
		    </div>
	  </div>
	  <div id="pagefooter">
	    <jsp:invoke fragment="footer"/>
	  </div>
  </body>
</html>