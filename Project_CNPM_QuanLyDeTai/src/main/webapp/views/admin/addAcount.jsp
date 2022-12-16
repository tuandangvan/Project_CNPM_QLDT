<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/admin/add" var="add"></c:url>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%">
          <h4 class="mb-3">Thêm tài khoản</h4>
          <form class="needs-validation" novalidate action="${add }" method="post">
            <div class="mb-3">
              <label for="firstName">Họ và tên</label>
              <input type="text" class="form-control" name="name" placeholder="Họ và tên" required>
            </div>
			<div class = "row">
				<div class="col-md-4 mb-3">
	              <label for="username">Số điện thoại</label>
	              <div class="input-group">
	                <input type="text" class="form-control" name="phone" placeholder="Số điện thoại" required>
	              </div>
            	</div>
				<div class="col-md-4 mb-3">
	              <label for="username">Giới tính</label>
	              <select class="form-control" name="gender">
					<option selected value="${true}">Nam</option>
					<option value="${false}">Nữ</option>
				  </select>
            	</div>
            	<div class="col-md-4 mb-3">
	              <label for="username">Ngày sinh</label>
	              <div class="input-group">
	                <input type="date" class="form-control" name="birth" placeholder="Ngày sinh" required>
	              </div>
            	</div>
			</div>
			<div class="mb-3">
              <label for="major">Chuyên ngành</label>
              <select class="form-control" name="major">
              <c:forEach items="${lstMajor }" var="major">
              	<option value="${major.majorId }">${major.majorName }</option>
              </c:forEach>
              </select>
            </div>
            <div class="mb-3">
              <label ${hidden } for="Adress">Địa chỉ</label>
              <input class="form-control" type="${hidden }" name="address" placeholder="Adress">
            </div>
            <div class="mb-3">
              <label for="email">Email</label>
              <input type="email" class="form-control" name="email" placeholder="you@example.com" required>
            </div>
            <div class="mb-3">
              <label for="password">Mật khẩu</label>
              <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>
            <hr class="mb-4">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Thêm tài khoản" style="margin: 35px 0px;">
          </form>
        </div>
	</div>
</div>