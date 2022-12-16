<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/home" var="link"></c:url>
    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách đề tài</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable">
            <thead>
                <tr>
                    <th data="true">STT</th>
                    <th>Tên đề tài</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${topics}" var="topic" varStatus="STT">
                     <tr>
                        <td>${STT.index+1}</td>
                        <td>
                            <a href="${link}/topicdetail?id=${topic.topicId }" style="color: rgb(68,68,68)!important;">${topic.topicName}</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>