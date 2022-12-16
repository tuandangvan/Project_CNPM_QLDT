<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
	<div style="color: rgb(7, 132, 163);" class="panel-heading">
		<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Chi tiết đề tài</h4>
	</div>
	<div class="panel-body">
		<table class="table">
			<thead>
				<tr>
					<th>Tên sinh viên</th>
					<th>Trưởng nhóm</th>
					<th>Điểm số</th>
					<th></th>
				</tr>
			</thead>
	
			<tbody class="table-body">
			<c:forEach var="topic" items="${topicDetailsDao.getAllByTopicId(topicModel.topicId)}">
				<tr>
					<td>${studentsDao.findById(topic.studentId).studentName}</td>
					<td>${topic.leader}</td>
					<td>${topic.scores}</td>
					<td><a href="./delete?id=${topic.id}&topicId=${topicModel.topicId}">Xóa</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-primary" href="../topics">Trở về</a>
	</div>
</div>