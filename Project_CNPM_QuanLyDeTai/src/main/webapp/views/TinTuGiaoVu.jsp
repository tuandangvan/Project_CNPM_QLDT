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
						<a href="/Home/TinTuGiaoVu?id=9"> Thông báo đăng ký chuyên
							ngành khóa ${sign.yStart } <small style="color: rgb(87, 87, 87);">(${sign.dStart}/${sign.mStart}/${sign.yStart} đến ${sign.dEnd}/${sign.mEnd}/${sign.yEnd})</small>
					</a>
				</small>


			</span>
			</span>
		</div>


		<div class="panel panel-default">
			<div style="color: rgb(7, 132, 163);" class="panel-heading">
				<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Tin
					từ giáo vụ</h4>
			</div>
			<div class="panel-body">


				<h4 style="color: #bb240d !important;">Thông báo đăng ký chuyên
					ngành khóa ${sign.yStart }</h4>
				<span style="font-size: 0.9em; color: rgb(204, 0, 0);">
					(${sign.startTime }) </span>
				<hr>
				<div class="chitiet_thongbao">
					<p>
						<font style="font-size: 14.6667px; background-color: transparent;">Trường
							ĐH Sư phạm Kỹ thuật TP. HCM</font>
					</p>
					<p>
						<font style="font-size: 14.6667px; background-color: transparent;">Khoa
							Công nghệ Thông tin </font>
					</p>

					<p align="center">
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							Độc lập - Tự do - Hạnh phúc</font>
					</p>

					<p align="center">
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							THÔNG BÁO ĐĂNG KÝ CHUYÊN NGÀNH KHÓA ${sign.yStart }</font>
					</p>
					<p>
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							Sinh viên khối công nghệ khóa ${sign.yStart } tiến hành đăng ký chuyên ngành
							tại website dkdt.fit.hcmute.edu.vn</font>
					</p>
					<p>
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							(Các em xem hướng dẫn đăng ký trên website dkdt.hcmute.edu.vn để
							đăng nhập lần đầu tiên vào hệ thống)</font>
					</p>
					<p>
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							Sinh viên đăng ký hai nguyện vọng (NV1, NV2).</font>
					</p>
					<p>
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							Thời gian đăng ký: Từ ngày ${sign.dStart}/${sign.mStart}/${sign.yStart} đến ${sign.dEnd}/${sign.mEnd}/${sign.yEnd}</font>
					</p>
					<p>
						<font
							style="font-size: 14.6667px; background-color: transparent; text-align: center;">
							Kết quả đăng ký chuyên ngành sẽ được thông báo trên website Khoa
							CNTT vào ngày ${(sign.dEnd+10)%30}/${sign.mEnd+1}/${sign.yEnd}</font>
					</p>
				</div>



				<hr>
				<h3 class="text-danger">&nbsp;&nbsp;Tin liên quan</h3>
				<hr>
				<ul>
					<c:forEach items="${signs}" var="signs">
						<a href="${link}/TinTuGiaoVu?id=${signs.signUpId}">
							<li>
								<p>
									<span class="badge green"> ${sign.dStart}/${sign.mStart}/${sign.yStart} đến ${sign.dEnd}/${sign.mEnd}/${sign.yEnd}</span> Đăng ký
									Tiểu luận chuyên ngành khoá ${signs.yStart }
								</p>
						</li>
						</a>
					</c:forEach>
				</ul>
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
				height="24"> Lượt truy cập : <span class="badge">111186</span></a>
			<a style="text-decoration: underline;" data-toggle="modal"
				data-target="#who_online" title="Who is online ?"
				href="javascript:void();" class="list-group-item"><img
				src="/Content/public/images/online-icon.png" width="24" height="24">
				Đang trực tuyến: <span class="badge">5</span></a>
		</div>
	</div>
</body>
</html>