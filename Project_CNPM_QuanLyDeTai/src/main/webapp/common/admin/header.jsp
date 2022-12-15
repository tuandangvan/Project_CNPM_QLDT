<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="navigation">
            <div id="banner-desktop">
                <div class="container">
                    <div id="banner">
                        <%-- <div id="login-area">
                                   <a data-toggle="modal" href="#dang_nhap"><img src="<c:url value="/assets/public/images/Login-icon.png"/>" width="24" height="24" /> Đăng nhập</a>
                        </div> --%>
                    </div>
                </div>
            </div>
            <!-- ############################ Đăng nhập ############################## -->
            <div class="modal fade" id="dang_nhap">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Đăng nhập</h4>
                        </div>
                        <form method="post" action="/Home/DangNhap" id="frm-login">
                            <div class="modal-body">
                                <div id="err_login"></div>
                                <div id="login_here">
                                    <label>Username : </label>
                                    <input type="text" class="form-control" name="username" id="username" />
                                    <label>Password : </label>
                                    <input type="password" class="form-control" name="password" id="password" />
                                    <br />
                                    <a href="/Home/QuenMatKhau" class="text-danger">Quên mật khẩu</a>
                                </div>
                                <br />
                                <div id="waiting" style="display: none;">
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" id="login_btn">Đăng nhập</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
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
                $(document).ready(function () {
                    $("#frm-login").submit(function (e) {
                        if ($("#username").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Username chưa nhập</div>');
                            $("#username").focus();
                            return false;
                        }
                        else if ($("#password").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Password chưa nhập</div>');
                            $("#password").focus();
                            return false;
                        }
                        else {
                            var form_data_login = {
                                username: $("#username").val(),
                                password: $("#password").val()
                            };
                            $.ajax({
                                url: '/Home/DangNhap',
                                type: 'POST',
                                async: true,
                                data: form_data_login,
                                success: function (msg_login) {
                                    //alert(msg);
                                    if (msg_login == 'false') {
                                        $('#err_login').html('<div class="alert alert-danger">Tên hoặc mật khẩu không chính xác</div>');
                                        $("#password").val("");
                                        $("#password").focus();
                                        return false;
                                    }
                                    else if(msg_login=='er_block')
                                    {
                                        $('#err_login').html('<div class="alert alert-danger">Tài khoản đang bị khóa</div>');
                                    }
                                    else {
                                        $("#login_here").hide();
                                        $(".modal-footer").hide();

                                        $('#err_login').html('<div class="alert alert-success"><strong>Đăng nhập thành công</strong><span> Hệ thống tự chuyển sau vài giây ...</span></div>');
                                        setTimeout(
                                           //chuyển đến địa chỉ msg_login của controler gửi qua
                                          function () {
                                              window.location.href = '' + msg_login + '';
                                          }, 2000);
                                    }
                                }
                            });
                            return false;
                        }
                    });
                })
                //Load wating bar
                $(document).ajaxStart(function () {
                    $("#waiting").show();
                }).ajaxStop(function () {
                    $("#waiting").hide();
                });
            </script>
<script type="text/javascript" src="<c:url value="/assets/public/js/bootstrap.min.js"/>"></script>
        </div>