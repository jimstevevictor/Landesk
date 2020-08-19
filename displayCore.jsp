<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
	function functionclick() {
		// 		console.log("jim");
		window.open('data:application/vnd.ms-excel,'
				+ encodeURIComponent($('div[id$=divTableDataHolder]').html()));
	}
</script>

<meta charset="ISO-8859-1">
<title>Core Apps Report</title>
</head>
<body>


	<div class="container">


		<br />
		<div id="divTableDataHolder">
			<table class="table" id="account_table">
				<tr>
					<th>Date</th>
					<th>Reference no</th>
					<th>Category</th>
					<th>User Login Id</th>
					<th>Created</th>
					<th>Assignee</th>
					<th>AssignedGroup</th>
					<th>Status</th>
					<th>Current Assigned GRoup</th>
					<th>Is Breached</th>
					<th>Aging</th>
					<th>Current Status</th>
				</tr>

				<c:forEach var="list" items="${coreApps}">
					<tr>
						<%-- 				<td><%= (new java.util.Date()).toLocaleString()%></td> --%>
						<td>
							<%
								Date dNow = new Date();
									SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
									out.print(ft.format(dNow));
							%>
						</td>
						<td><c:out value="${list.referenceNumber}"></c:out></td>
						<td><c:out value="${list.category}"></c:out></td>
						<td><c:out value="${list.userLoginId}"></c:out></td>
						<td><c:out value="${list.created}"></c:out></td>
						<td><c:out value="${list.assignee}"></c:out></td>
						<td><c:out value="${list.assignedGroup}"></c:out></td>
						<td><c:out value="${list.status}"></c:out></td>
						<td><c:out value="${list.currentAssignedGroup}"></c:out></td>
						<td><c:out value="${list.isBreached}"></c:out></td>
						<td><c:set var="msg" value="${list.created}" /> <c:set
								var="ssmsg" value="${fn:substring(msg, 0, 2)}" />
							${fn:substring(msg, 0, 2)}</td>
						<td>Assigned to ${list.assignee}'s Queue</td>

					</tr>
				</c:forEach>
			</table>
		</div>
		<br> <br>
<!-- 				<button class="btn btn-primary" id="clickExcel" -->
<!-- 					onclick="functionclick()" download="jim.xlsx">Export Table data into Excel</button> -->

<a class="btn btn-primary" id="clickExcel"
					onclick="functionclick()" download="jim.xlsx">Export Table data into Excel</a>

	</div>
</body>
</html>