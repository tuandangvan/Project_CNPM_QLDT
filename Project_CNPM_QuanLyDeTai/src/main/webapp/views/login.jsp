<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 	<a
		href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/CNPMNHOM20/logingooglehandler&response_type=code
		   &client_id=859276976264-rdaof3ki2rac86bctla9vbr7fvrukfkb.apps.googleusercontent.com&approval_prompt=force">Đăng
		nhập</a> -->
<body>
	<div class="modal-dialog ">
		<div class="modal-content ">
			<form method="post" action="login" id="frm-login">
				<div class="modal-body ">
					<div id="err_login"></div>
					<div id="login_here">
						<label>Username : </label> <input type="text" class="form-control"
							name="username" id="username" value="${username}" /> <label>Password
							: </label> <input type="password" class="form-control" name="password"
							value="${password}" id="password" /> <br /> <a
							href="/Home/QuenMatKhau" class="text-danger">Quên mật khẩu</a>
					</div>
					<br />
					<div id="waiting" style="display: none;">
						<div class="progress progress-striped active">
							<div class="progress-bar" role="progressbar" aria-valuenow="45"
								aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
						</div>
					</div>
					<c:if test="${alerts != null }">
						<h3 class="alerts alert-danger1 ">${alerts}</h3>
					</c:if>
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="login_btn">Đăng
						nhập</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
		</div>
</body>

<!-- /.modal-content -->

}
<!-- /.modal-dialog -->
<!-- /.modal -->