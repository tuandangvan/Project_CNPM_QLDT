<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
	<div class="panel-body">
<div class="spad">
	<div style="color: rgb(7, 132, 163);" class="panel-heading-1">
		<h4 style="font-family: verdana; color: rgb(87, 87, 87);">Đăng ký
			đề tài</h4>
	</div>
	<div class="row">
		<div class="col-md-8">
			<div class="card mb-3 user-profile">
				<div class="card-body info-panel">
					<form class="card-body" method="post" action="./register">
						<input type="hidden" name="teacherId" value="${teacherId}" />
						<div class="card-body info-panel">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Tên đề tài</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" name="topicName"
										id="topicName">
								</div>
							</div>
							<br />
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Mô tả đề tài</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input type="text" class="form-control" name="detail">
								</div>
							</div>

							<div class="row">
								<div class="col-lg-2"
									style="display: flex; margin: 15px 0; width: auto;">
									<button class="btn btn-success" type="submit"
										style="margin-right: 15px;">Đăng ký</button>
									<a href="#" class="btn btn-danger">Hủy</a>
								</div>
							</div>
							<br />

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>