<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="spad">
	<div class="panel-heading-1">
		<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Thông
			tin giảng viên</h4>
	</div>
	<div class="row">
		<div class="col-md-8">
			<div class="card mb-3 user-profile">
				<div class="card-body info-panel">
					<form class="card-body" method="post" action="./updateProfile">
						<input type="hidden" class="form-control" value="${teacher.email}"
							name="email">
						<div class="card-body info-panel">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Họ & tên</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control"
										value="${teacher.teacherName}" name="teacherName"
										id="teacherName">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" disabled="disabled"
										value="${teacher.email}">

								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Số điện thoại</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control"
										value="${teacher.phone}" name="phone">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Giới tính</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<select class="form-control" name="gender" id="gender">
										<option selected value="${true}">Nam</option>
										<c:if test="${teacher.gender==false}">
											<option selected value="${false}">Nữ</option>
										</c:if>
										<c:if test="${teacher.gender==true}">
											<option value="${false}">Nữ</option>
										</c:if>
									</select>

								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Ngày sinh</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="date" class="form-control"
										value="${teacher.birth}" name="birth">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Chuyên ngành</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" disabled="disabled"
										value="${majorsDao.get(teacher.majorId).majorName}"
										name="majorId">
								</div>

							</div>

							<div class="row">
								<div class="col-lg-2"
									style="display: flex; margin: 15px 0; width: auto;">
									<a href="./profile?user=${teacher.email}"
										class="btn btn-primary" style="margin-right: 15px;">Trở về</a>
									<button class="btn btn-success" type="submit">Lưu
										thông tin</button>
								</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>