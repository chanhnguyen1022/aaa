<%@page import="search.CustomerForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX based CRUD operations using jTable in Servlet and
	JSP</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet"
	type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
<!-- Include jTable script file. -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
</head>
<body bgcolor="CCFFFF">
	<%
		List<CustomerForm> list = (List<CustomerForm>) request.getAttribute("list");
	%>
	<div
		style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
		<h1 align="left" style="color: red;">Training</h1>
		<hr>
		<div id="center">
			<h3 align="left"">Login > Search Customer</h3>
			<p style="padding: 1%;background-color: blue;"></p>
			<div id="1">
				<table align="left">
					<tr>
						<td align="left"><h4>Wellcome</h4></td>
					</tr>
				</table>
			</div>
			<br> <br>
			<div
				style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
				<table>
					<tr>
					<td>                                           </td>
						<td><input type="button" id="first" value="<<"></td>
						<td><input type="button" id="preOne" value="<"></td>
						<td>Privous</td>
						<td>Next</td>
						<td><input type="button" id="nextOne" value=" >"></td>
						<td><input type="button" id="last" value=">>"></td>

					</tr>
				</table>
			</div>
			<%
				int index = (Integer) request.getAttribute("start");
				int all = (Integer) request.getAttribute("all");
			%>
			<script>
				$('#preOne')
						.click(
								function() {
									var i =
			<%=index%>
				;
									if (i == 0) {
										document.getElementById("preOne").disabled = true;
									} else {
										window.location.href = "http://localhost:8080/struts-beans/page.do?start="
												+ (i - 1);
									}
								});
				$('#nextOne')
						.click(
								function() {
									var i =
			<%=index%>
				;
									if ((i * 5) + 5 >=
			<%=all%>
				) {
										document.getElementById("nextOne").disabled = true;
									} else {
										window.location.href = "http://localhost:8080/struts-beans/page.do?start="
												+ (i + 1);
									}
								});
				$('#first')
						.click(
								function() {
									window.location.href = "http://localhost:8080/struts-beans/page.do?start=0";
								});
				$('#last')
						.click(
								function() {
									var all =
			<%=all%>
				;
									var index = Math.floor(all / 5);
									window.location.href = "http://localhost:8080/struts-beans/page.do?start="
											+ index;
								});
			</script>

			<div id="block-search"
				style="background-color: #F3F781; padding: 1%;">
				<form action="processSearch.do" method="post" id="searchForm"
					name="Form">
					<table align="center">
						<tr>
							<span id="error" style="color: red;"></span>
						</tr>
						<tr>
							<td style="size: 10%;">Customer Name</td>
							<td><input type="text" name="Customer_Name"></td>
							<td style="size: 10%;">Sex:</td>
							<td><select name="sex">
									<option value="F">F</option>
									<option value="M">M</option>
							</select></td>
							<td style="size: 10%;">BrithDay:</td>
							<td><input type="text" size="10%;" name="birthDayStart"
								placeholder="yyyy-mm-dd"></td>
							<td style="padding: 1%;"></td>
							<td><input type="text" size="10%;" name="birthDayEnd"
								placeholder="yyyy-mm-dd"></td>
							<td><input type="submit" value="Search"
								onclick="return checkBirthday();"></td>
						</tr>
					</table>
				</form>
			</div>
			<script>
				function checkBirthday() {
					var start = document.Form.birthDayStart.value;
					var end = document.Form.birthDayEnd.value;
					var rxDatePattern = /^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;
					if (document.Form.birthDayStart.value === ""
							&& document.Form.birthDayEnd.value === "") {
						return true;
					} else {
						if (start.match(rxDatePattern)) {
							if (end.match(rxDatePattern)) {
								var date1 = new Date(start);
								var date2 = new Date(end);
								if (date2 > date1) {
									return true;
								} else {
									document.getElementById("error").innerHTML = "Ngay sau phai lon hon ngay truoc";
								}
							} else {
								document.getElementById("error").innerHTML = "Ngay sau nhap khong dung dinh dang";
							}
						} else {
							document.getElementById("error").innerHTML = "Ngay truoc nhap khong dung dinh dang";
						}
					}
					return false;
				}
			</script>
			<table border="2" align="left" width="100%">
				<tr bgcolor="red;">
					<th><input type="checkbox"></th>
					<th>Customer_Id</th>
					<th>Customer_Name</th>
					<th>Sex</th>
					<th>BirthDay</th>
					<th>Address</th>
				</tr>
				<%
					for (CustomerForm cus : list) {
				%>
				<tr>
					<td><input type="checkbox" value="<%=cus.getCustomer_Id()%>">
					</td>
					<td><a href="edit.do?id=<%=cus.getCustomer_Id()%>"><%=cus.getCustomer_Id()%></a></td>
					<td><%=cus.getCustomer_Name()%></td>
					<td><%=cus.getSex()%></td>
					<td><%=cus.getBirthDay()%></td>
					<td><%=cus.getAddress()%></td>
				</tr>
				<%
					}
				%>
			</table>

		</div>
		<div id="block_button" style="padding: 2%;">
			<table>
				<!--viết html như thế thì làm sao mà chạy được input là input, a là a con lạy mẹ. giờ CSS cho thẻ a thành một cái button muốn biết làm sao thì lên google mà search-->
				<td><a href="add.do">Add New</a></td>
				<td><input type="submit" name="actionMethod" id="delete"
					value="Delete""></td>
			</table>
		</div>
		<div id="footer" align="left">
			<hr>
			<label>Copy right@ 2000-2008 FUJINET, All Rights Reserved.</label>
		</div>
	</div>
	<script>
		$('#delete')
				.click(
						function() {
							var r = confirm("Do you like freetuts.net");
							if (r == true) {
								var selected = "";
								$("input[type=checkbox]:checked").each(
										function() {
											selected = selected + "-"
													+ $(this).val();
										});
								$
										.ajax({
											url : "http://localhost:8080/struts-beans/delete.do?data="
													+ selected,
											type : 'POST',
											success : function(data) {
												alert("deleted:" + selected
														+ " thanh cong");
												window.location.reload();
											},
											error : function(xhr, status, error) {
												alert('there is some problem in updating data');
											}
										});
							} else {
								return;
							}
						});
		function enableEditDelete() {
			document.getElementById('editbutton').disabled = false;
			document.getElementById('deletebutton').disabled = false;
		}
	</script>
</body>
</html>