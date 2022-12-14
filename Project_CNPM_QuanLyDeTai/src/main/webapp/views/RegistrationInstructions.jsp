<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/home" var="link"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-9">
		<div class="well-sm">
			<span> 
					<img src="<c:url value="/assets/public/images/bullet-blue-icon.png"/>" > <small>
						<a href="${link}/TinTuGiaoVu?id=${sign.signUpId}"> Thông báo đăng ký chuyên
							ngành khóa ${sign.yStart } <small style="color: rgb(87, 87, 87);">(${sign.startTime })</small>
					</a>
				</small>


			</span> 
			</span>
		</div>

		<div class="panel panel-default">
			<div style="color: rgb(7, 132, 163);" class="panel-heading">
				<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Hướng
					dẫn đăng ký</h4>
			</div>
			<div class="panel-body">
				<h3>
					<strong>Hướng dẫn đăng nhập :</strong>
				</h3>

				<p style="text-align: center;">
					<img class="img-thumbnail img-responsive" alt="Username password"
						src="<c:url value="/assets/public/images/DN.png"/>" 
						style="height: 371px; width: 578px">
				</p>
				<p>&nbsp;</p>

				<p>
					Username : <strong>MSSV</strong>
				</p>

				<p>
					Password : <strong>nếu lần đầu đăng nhập thì password cũng
						chính là mã số sinh viên (nếu không thành công thì vui lòng sử
						dụng chức năng Nhắc mật khẩu hoặc liên hệ supporter để được reset
						mật khẩu).</strong>
				</p>

				<hr>
				<p>
					Sau khi đăng nhập thành công thì menu sẽ hiện lên chức
					năng&nbsp;cho <strong>Sinh viên : </strong>
				</p>

				<p style="text-align: center;">
					<img class="img-thumbnail img-responsive" alt=""
					src="<c:url value="/assets/public/images/cn_sv.png"/>" >
				</p>
				<p>&nbsp;</p>

				<p>
					<strong>Quản trị tài khoản : </strong>Sinh viên xem thông báo về
					phép được đăng ký đề tài trong lần này không, <strong>thay
						đổi thông tin</strong> hoặc <strong>mật khẩu</strong>.
				</p>

				<p>
					<strong>Đăng ký đề tài : </strong>
				</p>

				<ul>
					<li>Nếu bạn chưa đăng ký đề tài nào thì hệ thống hiện ra danh
						sách các đề tài mà bạn có thể đăng ký, bạn chọn đề tài nào thì
						nhấp vào link&nbsp;<strong>Đăng ký</strong>&nbsp;đề tài đó
					</li>
				</ul>

				<p>&nbsp;</p>

				<ul>
					<li>Nếu đề tài bạn muốn đăng ký đã có người đăng ký trước rồi
						thì bạn chọn vào link&nbsp;<strong>XVN (xin vào nhóm: </strong>để
						thêm mình vào danh sách “<strong>Quan tâm đề tài</strong>”<strong>)
					</strong>hoặc click<strong> gửi mail </strong>để gửi yêu cầu trực tiếp đến
						email trưởng nhóm đề tài. Ngoài ra bạn có thể xem thông tin liên
						lạc của nhóm trưởng thông qua “<strong>Chi tiết đề tài</strong>”.
					</li>
				</ul>

				<p>&nbsp;</p>

				<ul>
					<li>Nếu bạn đăng ký đề tài và là trưởng nhóm thì bạn được
						quyền xem danh sách các sinh viên “<strong>Quan tâm đề
							tài</strong>” và có thể thêm các thành viên này (hoặc bất cứ sinh viên nào
						được phép đăng ký đề tài) vào nhóm với điều kiện đề tài của bạn
						còn chỗ trống.
					</li>
				</ul>

				<p>&nbsp;</p>

				<ul>
					<li>Đề tài có ràng buộc chuyên ngành thì Nhóm trưởng phải thêm
						các thành viên theo đúng chuyên ngành của đề tài.</li>
				</ul>

				<hr>
				<p>
					Mỗi đợt đăng ký đề tài có giới hạn thời gian bắt đầu và thời gian
					kết thúc, khi hết thời gian đăng ký thì bạn không thể vào chức năng
					<strong>Đăng ký đề tài </strong>nữa mà chỉ có thể tìm kiếm các
					thông tin chung của các đề tài.
				</p>
			</div>
		</div>

		<ol class="breadcrumb">
			<li><a href="/Home/Index">Home</a></li>

		</ol>
		<div class="panel panel-default" id="thongke_right">
			<div class="panel-heading">
				<h4 id="mobile_thongke">Thống kê</h4>
			</div>
			<a class="list-group-item"><img
				src="/Content/public/images/user-group-icon (1).png" width="24"
				height="24"> Lượt truy cập : <span class="badge">111177</span></a>
			<a style="text-decoration: underline;" data-toggle="modal"
				data-target="#who_online" title="Who is online ?"
				href="javascript:void();" class="list-group-item"><img
				src="/Content/public/images/online-icon.png" width="24" height="24">
				Đang trực tuyến: <span class="badge">6</span></a>
		</div>
	</div>
</body>
</html>