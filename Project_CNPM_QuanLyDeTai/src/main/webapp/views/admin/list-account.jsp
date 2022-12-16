<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.hidetext { -webkit-text-security: square; }
</style>
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách tài khoản</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${lstAccount }" var="account">
                     <tr>                  	
                        <td>${account.username }</td>
                        <td class="hidetext">${account.password }</td>
                        <td>
                        	<c:if test="${account.role==1 }">
                        		Sinh viên
                        	</c:if>
                        	<c:if test="${account.role==2 }">
                        		Giảng viên
                        	</c:if>
                        </td>
                        <td style="width: 55px;">
	                        <a class="btn btn-success" type="button"
								href="<c:url value='manage-account/change-pass?username=${account.username }'/>">Đổi mật khẩu</a> 
						</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5"></td>
                </tr>
            </tfoot>
        </table>
    </div>
</div>