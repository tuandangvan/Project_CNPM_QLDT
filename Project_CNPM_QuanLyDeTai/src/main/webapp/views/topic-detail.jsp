<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Chi tiết đề tài</h4>
    </div>
    <c:if test="${topic.topicId!=null }">
    <div class="panel-body">
        <div id="detail">
            <table class="table table-hover footable-loaded footable">
                <tbody><tr>
                    <td>Tên đề tài</td>
                    <td>${topic.topicName }</td>
                </tr>
                <tr>
                    <td>Chi tiết đề tài</td>
                    <td>${topic.detail } </td>
                </tr>
                <tr>
                    <td>SL sinh viên</td>
                    <td><span class="badge green" title="Số lượng sinh viên đã đăng ký">${sl }</span> / <span class="badge red" title="Tổng Số lượng sinh viên tối đa">3</span></td>
                </tr>
                <tr>
                    <td>Được phép đăng ký khác chuyên ngành</td>
                            <td>Không</td>

                </tr>
                <!--
    <tr>
        <td>Thời gian bắt đầu bảo vệ</td>
        <td>0000-00-00 00:00:00</td>
    </tr>
    <tr>
        <td>Thời gian kết thúc bảo vệ</td>
        <td>0000-00-00 00:00:00</td>
    </tr>
    -->
                <tr>
                    <td>Chuyên ngành</td>
                    <td>${majorName }</td>
                </tr>
                <tr>
                    <td>Trạng thái</td>
                    <td>Được bảo vệ</td>
                </tr>
                <tr class="success">
                    <td>Trưởng nhóm</td>
                    <td>
                        <a data-toggle="modal" href="#truong_nhom">${leader.studentName } </a>
                    </td>
                </tr>
                <tr>
                    <td>Các Thành viên</td>
                    <td>
                    	<c:forEach items="${students }" var="student">
							<span class="text-info">${student.studentName }</span><br>
							</c:forEach>
                    </td>
                </tr>
         
                <tr class="danger">
                    <td>GV hướng dẫn </td>
                    <td>
                        <a data-toggle="modal" href="#GVHD">${teacherIn.teacherName }</a>
                    </td>
                </tr>
                <tr class="warning">
                    <td>GV phản biện</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Điểm đề tài</td>
                    <c:if test="${topicdetail.scores==null }">
                    	<td>Chưa có điểm</td>
                    </c:if>
                   <c:if test="${topicdetail.scores!=null }">
                    	<td>${topicdetail.scores }</td>
                    </c:if>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;"><button id="back" type="button" class="btn btn-info">Quay về</button></td>
                </tr>
            </tbody></table>
        </div>
        <!-- ========================== Info nhom truong ==========================-->
        <div class="modal fade" id="truong_nhom">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Thông tin nhóm trưởng</h4>
                    </div>
                    <div class="modal-body">
                            <img style="width: 92px;height:102px;" class="pull-right img-thumbnail" src="/Content/avatar/hinh-nen-may-tinh-11.jpg">
                            <label>Họ tên : <span class="text-info">${leader.studentName }</span></label><br>
                            <label>Email : <span class="text-info">${leader.email }</span></label><br>
                            <label>Chuyên ngành : <span class="text-info">${majorName } </span></label><br>
                            <label>Số điện thoại : <span class="text-info">${leader.phone }</span></label>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- ========================== Info GVHD ==========================-->
        <div class="modal fade" id="GVHD">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Thông tin GVHD</h4>
                    </div>
                    <div class="modal-body">
                        <img style="width: 92px;height:102px;" class="pull-right img-thumbnail" src="/Content/avatar/">
                        <label>Họ tên : <span class="text-info">${teacherIn.teacherName }</span></label><br>
                        <label>Chuyên ngành : <span class="text-info">${majorName }</span></label><br>
                        <label>Số điện thoại : <span class="text-info">${teacherIn.phone }</span></label><br>
                        <label>Email : <span class="text-info">${teacherIn.email }</span></label><br>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- ========================== Info GVPB ==========================-->
        <div class="modal fade" id="GVPB">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Thông tin GVPB</h4>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
    </c:if>
</div>