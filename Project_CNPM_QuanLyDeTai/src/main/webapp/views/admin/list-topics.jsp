<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/Council" var="link"></c:url>
    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách loại đề tài</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên đề tài</th>
                    <th>Người tạo</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${topics }" var="topic" varStatus="STT">
                     <tr>                  	
                        <td>${topic	.topicId }</td>
                        <td>${topic.topicName }</td>
                        <td>${topic.teacherId }</td>
                        <td style="width: 55px;">
	                        <a class="btn btn-primary" type="button"
								href="<c:url value='Council/create?id=${topic.teacherId }&topicId=${topic.topicId }'/>">Tạo hội đồng</a> 
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