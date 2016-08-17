<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<jsp:include page="/include/header.jsp" />
<%@ page import="opp.quanly.QuanLyDeThi"%>
<%@ page import="opp.model.DeThi"%>

<%
DeThi deThi = (DeThi) session.getAttribute("deThi");
QuanLyDeThi ql = new QuanLyDeThi(deThi);
%>
<div class="content-wrapper">
	<section class="content-header">
		<h1>Sửa đề thi</h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều khiển</a></li>
			<li class="active"><a href=""><i class="fa fa-file-o"></i> Đề thi</a></li>
		</ol>
	</section>
	<section class="content" ng-init="getDeThi()">
		<div class="row">
			<div class="col-md-12">
				<div class="form-horizontal" method="post" action="">

					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab-manual" data-toggle="tab">Thông tin đề thi</a></li>
						</ul>
						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2 control-label">Tên đề thi</label>
								<div class="col-sm-4"><input type="text" ng-model="tenDeThi" class="form-control" /></div>
								<label class="col-sm-2 control-label">Thời gian</label>
								<div class="col-sm-2"><input type="number" ng-model="thoiGian" class="form-control" /></div>
							</div>

							<div class="form-group">
								<label for="kiHoc" class="col-md-2 control-label">Kì học:</label>
								<div class="col-md-4">
									<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio" value="1">1</label>
									<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio" value="2">2</label>
									<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio" value="3">Hè</label>
									</div>
									<label class="col-sm-2 control-label">Năm học</label>
									<div class="col-sm-2"><input type="text" ng-model="namHoc" class="form-control" /></div>
								</div>

								<div class="form-group">
								<div class="col-sm-12"><textarea ng-bind="deThi" rows="10" readonly style="width:100%;padding:10px;background:#EEE"></textarea></div>
								</div>
							</div>
							<div class="box-footer">
								<div class="pull-left">
									<button name="update" ng-click="daoCauHoi();getDeThi()" class="btn btn-primary">Đảo câu hỏi</button>
									<button name="update" ng-click="daoDapAn();getDeThi()" class="btn btn-primary">Đảo đáp án</button>
									<button name="update" ng-click="xuatDeThi()" class="btn btn-primary">Xuất ra file</button>
								</div>
								<div class="pull-right">
									<button name="update" ng-click="save()" class="btn btn-info">Lưu</button>
									<a href="danh-sach-de-thi" class="btn btn-default">Trở về</a>
								</div>
							</div>
							<!-- /.box-footer -->
						</div>
						<!-- nav-tabs-custom -->
					</div>
					<p>{{message}}</p>
					<p></p>
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
			$scope.tenDeThi = "<%=deThi.getTenDeThi() %>";
			$scope.thoiGian = <%=deThi.getThoiGian() %>;
			$scope.namHoc = "<%=deThi.getNamHoc() %>";
			$scope.ki = <%=deThi.getKy() %>;
			
			$scope.getDeThi = function(){
				var req = {
					method : 'POST',
					url : 'tao-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data : $.param({
						action: "getDeThi"
					})
				};
				$http(req).then(function(response){
					$scope.deThi = response.data;
				}, function(response){
					$scope.message = "error";
				});
			};

			

			$scope.save = function(){
				var req = {
					method : 'POST',
					url : 'sua-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data : $.param({
						action: "save",
						tenDeThi : $scope.tenDeThi,
						thoiGian : $scope.thoiGian,
						namHoc : $scope.namHoc,
						ki : $scope.ki
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
					$window.open("danh-sach-de-thi", "_self")
				}, function(response){
					$scope.message = "error";
				});
			};
			

			$scope.daoCauHoi = function(){
				var req = {
					method : 'POST',
					url : 'tao-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data : $.param({
						action: "xaoTronCauHoi"
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
				}, function(response){
					$scope.message = "error";
				});
			};

			$scope.daoDapAn = function(){
				var req = {
					method : 'POST',
					url : 'tao-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data : $.param({
						action: "daoDapAn"
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
				}, function(response){
					$scope.message = "error";
				});
			};

			$scope.xuatDeThi = function(){
				var req = {
					method : 'POST',
					url : 'tao-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data : $.param({
						action: "inRaFile"
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
				}, function(response){
					$scope.message = "error";
				});
			};

		});
	</script>