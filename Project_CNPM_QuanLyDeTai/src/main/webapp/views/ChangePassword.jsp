<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/student/doimatkhau" var="change"></c:url>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%">
			<h4 class="mb-3">Đổi mật khẩu</h4>
			<form class="needs-validation" action="${change}" method="post">
				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="password">Mật khẩu hiện tại</label>
						<div class="input-group">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
					</div>
					<div class="col-md-4 mb-3">
						<label for="password">Mật khẩu mới</label>
						<div class="input-group">
							<input type="password" class="form-control" name="newpassword"
								placeholder="New Password" required>
						</div>
					</div>
					<div class="col-md-4 mb-3">
						<label for="password">Nhập lại mật khẩu mới</label>
						<div class="input-group">
							<input type="password" class="form-control" name="retypepassword"
								placeholder="New Password" required>
						</div>
					</div>

				</div>
				<c:if test="${alerts != null }">
					<h3 class="alerts alert-danger1 ">${alerts}</h3>
				</c:if>
				<hr class="mb-4">
				<input type="submit" class="btn btn-success btn-lg btn-block"
					value="Cập nhật thông tin">
			</form>
		</div>
	</div>
</div>