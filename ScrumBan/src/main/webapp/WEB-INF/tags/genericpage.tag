<!DOCTYPE html>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<html lang="en">
<%@include file="../view/shared/head.jsp"%>
<body>
	<div id="wrap">
		<div id="pageheader">
			<jsp:invoke fragment="header" />
		</div>
		<div id="body">
			<jsp:doBody />
		</div>
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
</body>
</html>