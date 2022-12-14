<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>HomePage</title>
<%@include file="/common/link-css-js.jsp"%>
</head>
<body>

	<%@include file="/common/header.jsp"%>
	<%-- <%@include file="/common/nav.jsp"%> --%>
	<div id="wrapper">
		<div class="container">
			<div class="row">
				<%@include file="/common/sinhvien/menu_left.jsp"%>
				<div class="col-md-9">
					<ol class="breadcrumb">
						<li><a href="/Home/Index">Home</a></li>

					</ol>
					<dec:body/>
				</div>
			</div>
		</div>
	</div>


		<%@include file="/common/footer.jsp"%>
</body>
</html>