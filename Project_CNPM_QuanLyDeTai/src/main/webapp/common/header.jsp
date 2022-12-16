<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="navigation">
            <div id="banner-desktop">
                <div class="container">
                    <div id="banner">
                        <div id="login-area">
                                   <a data-toggle="modal" href="#dang_nhap"><img src="<c:url value="/assets/public/images/Login-icon.png"/>" width="24" height="24" /> Đăng nhập</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ############################ Đăng nhập ############################## -->
            <div class="modal fade" id="dang_nhap">
                <div class="modal-dialog ">
		<div class="modal-content ">
			<form method="post" action="login" id="frm-login">
				<div class="modal-body ">
					<div id="err_login"></div>
					<div id="login_here">
						<label>Email : </label> <input type="text" class="form-control"
							name="username"  /> <label>Password
							: </label> <input type="password" class="form-control" name="password"
							  /> <br /> <a
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
		</div><!-- /.modal -->
            <!-- ===================================Thông tin người dùng=========================-->
            <div class="modal fade" id="thong_tin">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Thông tin người dùng</h4>
                        </div>

                    

                    


                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- ===================================Ajax Login=========================-->
            <script>
                
                //Load wating bar
                $(document).ajaxStart(function () {
                    $("#waiting").show();
                }).ajaxStop(function () {
                    $("#waiting").hide();
                });
            </script>
<script type="text/javascript" src="<c:url value="/assets/public/js/bootstrap.min.js"/>"></script>
        </div>