<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/admin/manage-teacher/edit" var="edit"></c:url>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%">
          <h4 class="mb-3">Cập nhật thông tin giảng viên</h4>
          <form class="needs-validation" novalidate action="${edit }" method="post">
            <div class="mb-3">
              <label for="firstName">Họ và tên</label>
              <input type="text" class="form-control" name="name" placeholder="Họ và tên" value="${teacher.teacherName }" required>
              <input type="hidden" class="form-control" name="teacherId" value="${teacher.teacherId }">
            </div>
			<div class = "row">
				<div class="col-md-4 mb-3">
	              <label for="username">Số điện thoại</label>
	              <div class="input-group">
	                <input type="text" class="form-control" name="phone" placeholder="Số điện thoại" value="${teacher.phone }" required>
	              </div>
            	</div>
				<div class="col-md-4 mb-3">
	              <label for="username">Giới tính</label>
	              <select class="form-control" name="gender">
					<option selected value="${true}">Nam</option>
					<c:if test="${teacher.gender==false}"><option selected value="${false}">Nữ</option></c:if>
					<c:if test="${teacher.gender==true}"><option  value="${false}">Nữ</option></c:if>
				  </select>
            	</div>
            	<div class="col-md-4 mb-3">
	              <label for="username">Ngày sinh</label>
	              <div class="input-group">
	                <input type="date" class="form-control" name="birth" placeholder="Ngày sinh" value="${teacher.birth }" required>
	              </div>
            	</div>
			</div>
			<div class="mb-3">
			<label for="major">Chuyên ngành</label>
              <select class="form-control" name="major">
              <c:forEach items="${lstMajor }" var="major">
              	<c:if test="${major.majorId==teacher.majorId }">
              		<option value="${major.majorId }" selected>${major.majorName }</option>
              	</c:if>
              	<c:if test="${major.majorId!=teacher.majorId }">
              		<option value="${major.majorId }">${major.majorName }</option>
              	</c:if>
              </c:forEach>
              </select>
            </div>

            <div class="mb-3">
              <label for="email">Email</label>
              <input type="email" class="form-control" disabled="disabled" id="email" placeholder="you@example.com" value="${teacher.email }">
            </div>
            <hr class="mb-4">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Cập nhật thông tin">
          </form>
        </div>
	</div>
</div>