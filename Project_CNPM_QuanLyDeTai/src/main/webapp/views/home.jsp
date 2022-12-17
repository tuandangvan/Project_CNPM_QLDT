<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
	<div class="panel-body">
		<ul class="list-unstyled">
			
			<c:forEach items="${signs}" var="signs">
			<a href="./TinTuGiaoVu?id=${signs.signUpId }">
				<li class="article-area">
					<p>
						<span class="btn btn-primary btn-sm"> ${signs.startTime} </span>
						Đăng kí đề tài tốt nghiệp khóa ${signs.yEnd }

					</p>
			</li>
			</a>
			</c:forEach>
			
		</ul>
	</div>
</div>