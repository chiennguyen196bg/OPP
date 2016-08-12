<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="opp.model.MonHoc"%>
<jsp:include page="/include/header.jsp" />


<%
	MonHoc monHoc = (MonHoc) request.getAttribute("monHoc");
	boolean edit = ((String) request.getAttribute("action")).equals("edit");
	String maHocPhan = (String) request.getParameter("maHocPhan");
%>
<div class="content-wrapper">
	<section class="content-header">
		<h1><%=edit? "Chỉnh sửa" : "Thêm mới" %> môn học</h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều
					khiển</a></li>
			<li class="active"><a href=""><i class="fa fa-pencil"></i>
					Môn học</a></li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab-info" data-toggle="tab">Thông
								tin câu hỏi</a></li>
					</ul>
					<div class="form-horizontal" method="post"
						action="monhoc_themmoi.html">
						<div class="box-body">
							<div class="tab-content">
								<div class="tab-pane active" id="tab-info">
									<div class="box-body">
										<div class="form-group">
											<label class="col-sm-2 control-label">Tên môn học</label>
											<div class="col-sm-8">
												<input type="text" ng-model="tenMonHoc" ng-value="tenMonHoc" 
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Mã học phần</label>
											<div class="col-sm-8">
												<input type="text" ng-model="maHocPhan" ng-value="maHocPhan"
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Số chương</label>
											<div class="col-sm-1">
												<input type="number" ng-model="soChuong" ng-value="soChuong"
													class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Giới thiệu</label>
											<div class="col-sm-8">
												<textarea type="text" ng-model="gioiThieu" class="form-control"
													rows="5" id="gioiThieu" ng-value="gioiThieu"></textarea>
											</div>
										</div>
									</div>
									<p>{{message}}</p>
									<!-- /.box-body -->
								</div>
								<!-- /.tab-pane -->
							</div>
							<!-- /.tab-content -->
						</div>
						<div class="box-footer">
							<button ng-click="submit()"
								class="btn btn-info pull-right"><%=edit? "Chỉnh sửa" : "Thêm mới" %></button>
						</div>
						<!-- /.box-footer -->
						
					</div>
				</div>
				<!-- nav-tabs-custom -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
</div>
<!-- /.content-wrapper -->


<%@ include file="/include/footer.jsp"%>

<script type="text/javascript">
	app.controller('myCtrl', function($scope, $http, $window, $location) {
		$scope.tenMonHoc = "<%=monHoc.getTenMonHoc() %>";
		$scope.maHocPhan = "<%=monHoc.getMaHocPhan() %>";
		$scope.soChuong = <%=edit? monHoc.getSoChuong(): "1" %>;
		$scope.gioiThieu = "<%=(monHoc.getGioiThieu())==null? "" : monHoc.getGioiThieu()%>";
		$scope.submit = function(){
			var req = {
				method : 'POST',
				url : 'them-sua-mon-hoc',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
 				data: $.param({
 					action : "<%=edit? "edit" : "add"%>",
					tenMonHoc : $scope.tenMonHoc,
					maHocPhan : $scope.maHocPhan,
					soChuong : $scope.soChuong,
					gioiThieu : $scope.gioiThieu,
					old_maHocPhan : "<%=maHocPhan%>"
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
				// $window.open("danh-sach-cau-hoi","_self");
			}, function(response){
				$scope.message = "error";
			});
		}
	});
</script>