<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	

	<div class="container">
	<h3>File Upload:</h3>
		<ul class="nav nav-tabs">
			<!-- 			<li class="active"><a href="#">Home</a></li> -->
			<li class="active"><a class="nav-item nav-link active"
				id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab"
				aria-controls="nav-home" aria-selected="true" href="#">Convert to Excel</a></li>
				
				
			<li><a class="nav-item nav-link" id="nav-profile-tab"
				data-toggle="tab" href="#nav-profile" role="tab"
				aria-controls="nav-profile" aria-selected="false" href="#">Generate Report
					</a></li>
		
		
			<li><a class="nav-item nav-link" id="nav-rename-tab"
				data-toggle="tab" href="#nav-rename" role="tab"
				aria-controls="nav-rename" aria-selected="false" href="#">
					Rename file</a></li>

		</ul>

		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane" id="nav-home" role="tabpanel"
				aria-labelledby="nav-home-tab">
				<h3>Convert CSV to XLSX</h3>
				<form action="${pageContext.request.contextPath}/convertToExcel"
					method="post" enctype="multipart/form-data">
					<input type="file" name="files" size="50" /> <br /> <input
						type="submit" value="Convert File" />
				</form>
			</div>
			<div class="tab-pane" id="nav-profile" role="tabpanel"
				aria-labelledby="nav-home-tab">
				<h3>Automate Report</h3>
				<form action="${pageContext.request.contextPath}/upload"
					method="post" enctype="multipart/form-data">
					<input type="file" name="files" size="50" /> <br /> <input
						type="submit" value="Upload File" />
				</form>
			</div>
			
			<div class="tab-pane" id="nav-rename" role="tabpanel"
				aria-labelledby="nav-rename-tab">
				<h3>Rename Report</h3>
				<form action="${pageContext.request.contextPath}/rename"
					method="post" enctype="multipart/form-data">
					<input type="file" name="files" size="50" />
					 <br /> <input
						type="submit" value="Rename File" />
				</form>
			</div>

		</div>
	</div>

</body>
</html>