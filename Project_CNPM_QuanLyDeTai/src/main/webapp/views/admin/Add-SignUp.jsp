<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/admin/singUp/add" var="add"></c:url>
<!-- <div class="alert alert-success">Đã tạo thành công
</div> -->
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%; height: 500px">
          <h2 class="mb-3" style="    font-weight: bold;
    color: cornflowerblue;">Tạo đợt đăng ký</h2>
          <form class="needs-validation" novalidate action="${add }" method="post">
			<div class = "row">
				<div class="col-md-6 mb-3">
	              <label for="username">Thời gian bắt đầu</label>
	              <div class="input-group">
	                <input type="date" class="form-control" name="start" placeholder="Thời gian bắt đầu" value="${student.phone }" required>
	              </div>
            	</div>
				
            	<div class="col-md-6 mb-3">
	              <label for="username">Thời gian kết thúc</label>
	              <div class="input-group">
	                <input type="date" class="form-control" name="end" placeholder="Thời gian bắt đầu" value="${student.birth }" required>
	              </div>
            	</div>
			</div>
			<div class="mb-3">
              <label for="username">Dành cho</label>
              <select class="form-control" name="role">
				<option selected value="${true}">Giảng viên</option>
				<option  value="${false}">Sinh Viên</option>
			  </select>
            </div>
            <hr class="mb-4" style="margin: 50px">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Tạo">
          </form>
        </div>
	</div>
</div>