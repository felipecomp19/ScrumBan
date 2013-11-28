<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">
<%@include file="/WEB-INF/view/shared/head.jsp"%>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ScrumBan</a>
			</div>
			<div class="navbar-collapse collapse">
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
	
	<div class="jumbotron banner">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h1>Build agile software with control</h1>
					<p>Powerful collaboration, code review, and code management for open source and private projects. Need private repositories? [Upgraded plans start at $7/mo.]</p>
					<p>
						<a class="btn btn-primary btn-lg" role="button">Explore  &raquo;</a>
					</p>
				</div>
				<div class="col-md-4">
					<form role="form" method="POST" action="saveUser.html">
						<div class="form-group">
							<input type="text" class="form-control" id="inputName" name="inputName" placeholder="Enter you name or nickname" required="required">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" id="inputEmail1" name="inputEmail1" placeholder="Enter email">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Enter a password">
						</div>
						<input type="submit" class="btn btn-primary btn-lg btn-block" value="Sing up for ScrumBan"/>
					</form>
				</div>
			</div>	
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; TexTI 2013</p>
		</footer>
	</div>
	<!-- /container -->
</body>
</html>