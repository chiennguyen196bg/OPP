<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/include/header.jsp" />
			
			<div class="content-wrapper">
				<section class="content-header">
					<h1>Thêm mới đề thi</h1>
					<ol class="breadcrumb">
						<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều khiển</a></li>
						<li class="active"><a href=""><i class="fa fa-file-o"></i> Đề thi</a></li>
					</ol>
				</section>
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="form-horizontal" method="post" action="">
								<div class="nav-tabs-custom">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab-info" data-toggle="tab">Danh sách câu hỏi môn học</a></li>
									</ul>
									<div class="box-body">
										<div class="tab-content">
											<div class="tab-pane active" id="tab-info">
												
													<div class="col-md-12">
													<div class="form-group">
														<label for="kiHoc" class="col-md-4">Dạng đề thi:</label>
														<div class="col-md-6">
															<label class="radio-inline">
															<input ng-model="dangCauHoi" type="radio" name="optradio" value="1">Trắc nghiệm
															</label>
															<label class="radio-inline">
															<input ng-model="dangCauHoi" type="radio" name="optradio" value="2">Tự luận
															</label>
															<label class="radio-inline">
															<input ng-model="dangCauHoi" type="radio"  name="optradio" value="0">Cả hai
															</label>
														</div>
													</div>
													<div class="form-group" ng-show="dangCauHoi == 0">
														<label for="kiHoc" class="col-md-4">Hình thức:</label>
														<div class="col-md-6">
															<label class="radio-inline">
															<input ng-model="sapXep" type="radio" name="optradio2" value="0">Trắc nghiệm và tự luận riêng
															</label>
															<label class="radio-inline">
															<input ng-model="sapXep" type="radio" name="optradio2" value="1">Trắc nghiệm và tự luận chung
															</label>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group" >
														<label class="col-sm-3 control-label">Số câu</label>
														<div class="col-sm-7">
														<input ng-model="soCau" type="number" step="1" class="form-control" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label">Độ khó:</label>
														<div class="col-sm-7">
															<select ng-model="doKho" class="form-control">
																<option value="0">Bất kì</option>
																<option value="1">Rất dễ</option>
																<option value="2">Dễ</option>
																<option value="3">Trung Binh</option>
																<option value="4">KHó</option>
																<option value="5">Rất khó</option>
															</select>
														</div>
													</div>
												</div>
												<!-- <div class="col-md-8">
													<label class="radio-inline"><input type="checkbox" name="optradio3">Số chương mỗi câu bất kì</label>
													<div class="col-md-8 pull-right">
														<div class="form-group" >
															<label class="col-sm-5 control-label">Số câu</label>
															<div class="col-sm-4"><input type="number" step="1" class="form-control" /></div>
														</div>
														<div class="form-group" >
															<label class="col-sm-5 control-label">Số câu</label>
															<div class="col-sm-4"><input type="number" step="1" class="form-control" /></div>
														</div>
														<div class="form-group" >
															<label class="col-sm-5 control-label">Số câu</label>
															<div class="col-sm-4"><input type="number" step="1" class="form-control" /></div>
														</div>
													</div>
												</div> -->
												<div class="col-md-12">
													<button ng-click="taoDeThi();getCauHoiDeThi();getDeThi()" class="btn btn-info pull-right">Tạo đề thi</button>
												</div>
												
											</div>
											<!-- /.tab-pane -->
										</div>
										<!-- /.tab-content -->
									</div>
								</div>
								<!-- nav-tabs-custom -->
								<div class="nav-tabs-custom">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab-manual" data-toggle="tab">Danh sách câu hỏi trong đề</a></li>
									</ul>
									<div class="box-body">
										
										<div class="col-md-5">
											<div style="overflow: auto; max-height:200px;">
												<div class="list-group">
													<button ng-repeat="x in listCauHoiTrongDe.list" ng-click="selectDeThi($index)" class="list-group-item">{{x.deBai}}</button>
												</div>
											</div>
											<div style="padding: 5px; overflow: auto;">
												<button ng-click="thayThe();getCauHoiDeThi();getDeThi()" class="btn btn-info">Thay thế tương đương</button>
										<button ng-click="xoaCauHoi();getCauHoiDeThi();getDeThi()" class="btn btn-danger pull-right">Xóa khởi đề thi</button>
											</div>
											<p>Thông tin đề thi</p>
											<div>
												<div class="form-group">
													<label class="col-sm-2 control-label">Thời gian</label>
													<div class="col-sm-4"><input type="number" ng-model="thoiGian" class="form-control" /></div>
													
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label">Học kì</label>
													<div class="col-sm-3"><input type="text" ng-model="hocKi" class="form-control" /></div>
												</div>
												<div class="form-group">
													<label for="kiHoc" class="col-md-4">Kì học:</label>
													<div class="col-md-6">
														<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio" value="1">1</label>
														<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio" value="2">2</label>
														<label class="radio-inline"><input ng-model="ki" type="radio" name="optradio"
														 value="3">Hè</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-7">
											<div>
												<textarea ng-bind="deThi" cols="40" rows="6" class="form-control" readonly style="width:100%;font-size:14px;line-height:18px;border:1px solid rgb(221,221,221);padding:10px"></textarea>
											</div>
											<button name="update" ng-click="daoCauHoi();getCauHoiDeThi();getDeThi()" class="btn btn-info">Đảo câu hỏi</button>
										</div>
									</div>
									<div class="box-footer">
										<button name="update" ng-click="save()" class="btn btn-info">Lưu</button>
										<button name="update" ng-click="delete()" class="btn btn-danger pull-right">Xóa</button>
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

		$scope.diem = 0;
		$scope.ki = 1;
		
		$scope.cauHoiInfo = "";
		$scope.listCauHoi = {
			type: "0",
			list : []
		};
		$scope.listCauHoiTrongDe = {

			list : []
		};
		$scope.deThi = "";
		
		$scope.doKho = "0";
		$scope.dangCauHoi = "0";
		$scope.soCau = 1;
		$scope.sapXep = "0";


		$scope.select = function($index){
			$scope.listCauHoi.index = $index;
		};
		$scope.selectDeThi = function($index){
			$scope.listCauHoiTrongDe.index = $index;
		};

		
		$scope.getCauHoiDeThi = function(){
			var req = {
				method : 'POST',
				url : 'tao-de-thi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "getCauHoiDeThi"
				})
			};
			$http(req).then(function(response){
				$scope.listCauHoiTrongDe.list = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

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

		$scope.xoaCauHoi = function(){
			var req = {
				method : 'POST',
				url : 'tao-de-thi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "xoaCauHoi",
					index : $scope.listCauHoiTrongDe.index
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.thayThe = function(){
			var req = {
				method : 'POST',
				url : 'tao-de-thi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "thayThe",
					index : $scope.listCauHoiTrongDe.index
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.save = function(){
			var req = {
				method : 'POST',
				url : 'tao-de-thi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "save",
					thoiGian : $scope.thoiGian,
					hocKi : $scope.hocKi,
					ki : $scope.ki
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
				$window.open("danh-sach-de-thi", "_self");
			}, function(response){
				$scope.message = "error";
			});
		};
		$scope.delete = function(){
			var req = {
				method : 'POST',
				url : 'tao-de-thi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "delete"
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.taoDeThi = function(){
			var index = $scope.listCauHoi.index;
			var req = {
				method : 'POST',
				url : 'them-tu-dong',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "taoDeThi",
					doKho : $scope.doKho,
					dangCauHoi : $scope.dangCauHoi,
					soCau : $scope.soCau,
					sapXep : $scope.sapXep
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
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
					action: "xaoTronCauHoi",
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