<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content-body">
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="spad">
				<div class="row">
					<div class="col-md-8" style="width: 100%;">
						<div class="card mb-3 user-profile">
							<div class="card-body info-panel">
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Họ & tên</h6>
									</div>
									<div class="col-sm-9 text-secondary">${teacher.teacherName}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Email</h6>
									</div>
									<div class="col-sm-9 text-secondary">${teacher.email}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Số điện thoại</h6>
									</div>
									<div class="col-sm-9 text-secondary">${teacher.phone}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Giới tính</h6>
									</div>
									<div class="col-sm-9 text-secondary">${teacher.gender ? "Nam":"Nữ"}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Sinh năm</h6>
									</div>
									<div class="col-sm-9 text-secondary">${teacher.birth}</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">Chuyên ngành</h6>
									</div>
									<div class="col-sm-9 text-secondary">

										${majorsDao.get(teacher.majorId).majorName}</div>

								</div>
								<hr>
								<div class="row">
									<div class="col-sm-9">
										<a class="btn btn-info" target=""
											href="./updateProfile?user=${teacher.email}">Sửa thông
											tin</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
