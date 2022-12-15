<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url value="/home" var="link"></c:url>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/home" var="link"></c:url>

                    <div id="left-content">
                        <div class="col-md-3">
                            <!-- Menu desktop -->
                            <div id="desktop-menu">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 id="mobile_home">Danh Mục</h4>
                                    </div>

                                    <a href="${link }" class="list-group-item"><img src="<c:url value="/assets/public/images/house-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Trang Chủ</a>
                                    <a href="${link }/loaidetai" class="list-group-item "><img src="<c:url value="/assets/public/images/Actions-view-calendar-list-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Danh sách đề tài</a>

                                    <a href="/Home/ThongTinGiangVien" class="list-group-item "><img src="<c:url value="/assets/public/images/Teacher-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin giảng viên</a>
                                    <a href="/Home/ThongTinSinhVien" class="list-group-item "><img src="<c:url value="/assets/public/images/Student-3-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin sinh viên</a>
                                    <a href="${link}/RegistrationInstructions" class="list-group-item "><img src="<c:url value="/assets/public/images/Actions-help-contents-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Hướng dẫn đăng ký</a>

                                    <a href="/Home/ThongKe" class="list-group-item "><img src="<c:url value="/assets/public/images/chart-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thống kê</a>
                                    <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="<c:url value="/assets/public/images/Search-icon.png"/>" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Tìm kiếm</a>
                                </div><!-- /panel-default -->

                                



                                <!--============================Bench==================-->
                                
                            <!-- Modal Who online -->
                            <div class="modal fade" id="who_online" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Online Users</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <td>STT</td>
                                                        <td>Tên SV</td>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ########################### Form ###########################-->
                            <!-- =========================Tìm kiếm box================================ -->
                            <div class="modal fade" id="seach_box">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">Tìm kiếm</h4>
                                        </div>
                                        <form action="/Home/TimKiem" method="get" id="cpa-form">
                                            <div class="modal-body">
                                                <div id="err_tk"></div>
                                                <select class="form-control text-center" name="param_option" id="tim_kiem_tong_hop">
                                                    <option value="timkiemgiangvien">Tìm kiếm giảng viên</option>
                                                    <option value="timkiemsinhvien">Tìm kiếm sinh viên</option>
                                                    <option value="timkiemdetai">Tìm kiếm đề tài</option>
                                                </select>
                                                <br />
                                                <label>Nhập từ khoá :</label>
                                                <input type="text" class="form-control" id="parameter1" name="param_textbox" value="" placeholder="Mọi thứ..." />
                                                <div class="clear"></div>
                                                <div id="search_advance">
                                                    <br />
                                                    <div id="type_detai" style="display: none;">
                                                        
                                                        <fieldset>
    <legend>Chọn loại đề tài</legend>
        <input type="radio" name="group_loaidt" value="1" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="3" /> <span>Đề t&#224;i tốt nghiệp | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="4" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 17 <br /></span>
        <input type="radio" name="group_loaidt" value="8" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 19 <br /></span>
    
</fieldset>;
                                                    </div><!-- End #search_advance -->
                                                </div><!--End body -->
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary" id="timkiem_btn">Tìm kiếm</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </form>
                                    
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                        </div><!-- ===================================Ajax========================= -->
                        <script>
                            $(document).ready(function () {
                                $("#cpa-form").submit(function (e) {
                                    if ($("#parameter1").val() == '') {
                                        $('#err_tk').html('<div class="alert alert-danger">Vui lòng nhập từ khoá tìm kiếm</div>');
                                        $("#parameter1").focus();
                                        return false;
                                    }
                                    if ($('#tim_kiem_tong_hop').val() == "timkiemdetai")
                                    {
                                        //$('*[name=group_loaidt]').is(":not(:checked)") kiểm tra radio chưa check

                                        if ($("*[name=group_loaidt]").is(":checked")) {
                                            return true;
                                        }
                                        else //radio chưa check
                                        {
                                            $('#err_tk').html('<div class="alert alert-danger">Vui lòng chọn loại đề tài</div>');
                                            return false;
                                        }
                                    }
                                });
                            })
                        </script>
                        
                    </div>
                </div>  

                                    
                </div>