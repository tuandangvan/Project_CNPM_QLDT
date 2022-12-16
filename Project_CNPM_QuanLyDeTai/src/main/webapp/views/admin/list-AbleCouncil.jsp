<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách giảng viên</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>Teacher Id</th>
                    <th>Họ và tên</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Chuyên ngành</th>
                    <th>Chọn</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${listTeacher }" var="teacher">
                     <tr>
                        <td>${teacher.teacherId }</td>
                        <td>${teacher.teacherName }</td>
                        <td>${teacher.email }</td>
                        <td>${teacher.phone }</td>
                        <td>${teacher.majorName }</td>
                        <td>
                        	<a class="btn btn-primary" type="button"
								href="<c:url value='./add-council?idTeacher=${teacher.teacherId }&councilId=${councilId }&teachReturn=${teachReturn }&topicReturn=${topicReturn}'/>">Thêm</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5"></td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Các giảng viên đã chọn</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Teacher Id</th>
                    <th>Họ và tên</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${details }" var="councilDt">
                     <tr>
                        <td>${councilDt.councilId }</td>
                        <td>${councilDt.teacherId }</td>
                        <td>${councilDt.teacherName }</td>
                        <td>
                        	<a class="btn btn-danger" type="button"
								href="<c:url value='./delete?councilId=${councilDt.councilId}&teacherId=${councilDt.teacherId }&teachReturn=${teachReturn }&topicReturn=${topicReturn} '/>">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
	                <tr>
	                    <td colspan="5"></td>
	                </tr>
            </tfoot>
        </table>
    </div>
</div>