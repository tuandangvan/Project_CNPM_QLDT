<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/home" var="link"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
</head>
<body>
	<script>
$(document).ready(function () {
    $("#${panel}").show();
});
</script>

	<div class="panel panel-default" id="timkiemsinhvien"
		style="display: none">
		<div style="color: rgb(7, 132, 163);" class="panel-heading">
			<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Sinh
				viên</h4>
		</div>
		<div class="panel-body">
			<div class="text-center">
				<p class="badge red">Tổng số mẩu tin : 0</p>
			</div>
			<table class="table demo tablet breakpoint footable-loaded footable"
				data-page-size="5">
				<thead>
					<tr>
						<th data-hide="phone" class="footable-first-column">MSSV</th>
						<th data="true">Họ Tên</th>
						<th data-hide="phone" class="footable-last-column">Số Điện
							Thoại</th>
						<th data-hide="phone" class="footable-last-column">Email</th>
						<th data-hide="phone" class="footable-last-column">Chuyên
							Ngành</th>
						<th data-hide="phone" class="footable-last-column">Tên Đề Tài</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stu}" var="stu">
						<tr>
							<td>${stu.studentId}</td>
							<td>${stu.studentName}</td>
							<td>${stu.phone}</td>
							<td>${stu.email}</td>
							<td>${stu.majorName}</td>
							<td>${stu.topicName}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="pagination pagination-centered">
								<div class="pagination-container">
									<ul class="pagination"></ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<div class="panel panel-default" id="timkiemgiangvien"
		style="display: none">
		<div style="color: rgb(7, 132, 163);" class="panel-heading">
			<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Giảng
				viên</h4>
		</div>
		<div class="panel-body">
			<div class="text-center">
				<p class="badge red">Tổng số mẩu tin : 0</p>
			</div>
			<table class="table demo tablet footable-loaded footable"
				data-page-size="5">
				<thead>
					<tr>
						
						<th data="true">Họ Tên</th>
						<th data-hide="phone" class="footable-last-column">Số Điện
							Thoại</th>
						<th data-hide="phone" class="footable-last-column">Email</th>
						<th data-hide="phone" class="footable-last-column">Chuyên
							Ngành</th>
						<th data-hide="phone" class="footable-last-column">Tên Đề Tài</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tea}" var="tea">
						<tr>
							
							<td>${tea.teacherName}</td>
							<td>${tea.phone}</td>
							<td>${tea.email}</td>
							<td>${tea.majorName}</td>
							<td>${tea.topicName}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="pagination pagination-centered">
								<div class="pagination-container">
									<ul class="pagination"></ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<div class="panel panel-default" id="timkiemdetai" style="display: none">
		<div style="color: rgb(7, 132, 163);" class="panel-heading">
			<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Đề tài</h4>
		</div>
		<div class="panel-body">

			<div class="text-center">
				<p class="badge red">Tổng số mẩu tin : 0</p>
			</div>
			<table class="table demo footable-loaded footable tablet breakpoint"
				data-page-size="5">
				<thead>
					<tr>
						<th data="true" class="footable-first-column">Tên đề tài</th>
						<th>GVHD</th>
						<th data-hide="phone,tablet" style="display: none;">Chuyên
							ngành</th>
						<th data-hide="phone,tablet" style="display: none;">Tình
							trạng</th>
						<th data-hide="phone" class="footable-last-column">Số lượng
							SV</th>
						<th data-hide="phone,tablet" style="display: none;">More info</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topi}" var="topi">
						<tr>
							<td class="footable-first-column"><span
								class="footable-toggle"></span>${topi.topicName}</td>
							<td>${topi.teacherName}</td>

							<td class="footable-last-column"><span class="badge green">${topi.count}</span>
								/ <span class="badge red"> 3</span></td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<div class="pagination pagination-centered">
								<div class="pagination-container">
									<ul class="pagination"></ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>

</body>
</html>