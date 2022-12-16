<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/admin/manage-account/change-pass" var="change"></c:url>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%">
          <h4 class="mb-3">Đổi mật khẩu</h4>
          <form class="needs-validation" novalidate action="${change }" method="post">
            <div class="mb-3">
              <label for="firstName">Username</label>
              <input type="text" class="form-control" disabled="disabled" placeholder="Username" value="${account.username }" required>
            </div>

            <div class="mb-3">
              <label for="email">Password</label>
              <input type="password" class="form-control" placeholder="Password" value="${account.password }" name="password" required>
            </div>
            <hr class="mb-4">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Cập nhật mật khẩu">
          </form>
        </div>
	</div>
</div>