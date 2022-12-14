<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/student/info/edit" var="edit"></c:url>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-8 order-md-1" style="width: 100%">
          <h4 class="mb-3">Cập nhật thông tin sinh viên</h4>
          <form class="needs-validation" novalidate action="${edit }" method="post">
            <div class="mb-3">
              <label for="firstName">Họ và tên</label>
              <input type="text" class="form-control" name="name" placeholder="Họ và tên" value="${student.studentName }" required>
              <input type="hidden" class="form-control" name="studentId" value="${student.studentId }">
            </div>
			<div class = "row">
				<div class="col-md-4 mb-3">
	              <label for="username">Số điện thoại</label>
	              <div class="input-group">
	                <input type="text" class="form-control" name="phone" placeholder="Số điện thoại" value="${student.phone }" required>
	              </div>
            	</div>
				<div class="col-md-4 mb-3">
	              <label for="username">Giới tính</label>
	              <select class="form-control" name="gender" name="gender">
					<option selected value="${true}">Nam</option>
					<c:if test="${student.gender==false}"><option selected value="${false}">Nữ</option></c:if>
					<c:if test="${student.gender==true}"><option  value="${false}">Nữ</option></c:if>
				  </select>
	              <%-- <div class="input-group">
	              <c:if test="${student.gender==true}">
	              	 <input type="text" class="form-control" id="gender" placeholder="Giới tính" value="Nam" required>
	              </c:if>
	              <c:if test="${student.gender==false}">
	              	 <input type="text" class="form-control" id="gender" placeholder="Giới tính" value="Nữ" required>
	              </c:if>
	              </div> --%>
            	</div>
            	<div class="col-md-4 mb-3">
	              <label for="username">Ngày sinh</label>
	              <div class="input-group">
	                <input type="date" class="form-control" name="birth" placeholder="Ngày sinh" value="${student.birth }" required>
	              </div>
            	</div>
			</div>
			<div class="mb-3">
              <label for="email">Chuyên ngành</label>
              <c:if test="${student.majorId==1 }">
              	<input type="major" class="form-control" disabled="disabled" id="major" placeholder="Chuyên ngành" value="Kĩ thuật dữ liệu">
              </c:if>
              <c:if test="${student.majorId==2 }">
              	<input type="major" class="form-control" disabled="disabled" id="major" placeholder="Chuyên ngành" value="Công nghệ thông tin">
              </c:if>
            </div>

            <div class="mb-3">
              <label for="email">Email</label>
              <input type="email" class="form-control" disabled="disabled" id="email" placeholder="you@example.com" value="${student.email }">
            </div>

            <div class="mb-3">
              <label for="address">Địa chỉ</label>
              <input type="text" class="form-control" name="address" placeholder="Địa chỉ" required value="${student.address }">
            </div>
            <hr class="mb-4">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Cập nhật thông tin">
          </form>
        </div>
	</div>
</div>