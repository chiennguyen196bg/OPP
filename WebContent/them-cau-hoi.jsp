<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="opp.model.MonHoc" %>
<%@ page import="opp.model.CauHoi" %>

<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>

<% MonHoc monHoc = (MonHoc) request.getAttribute("monHoc"); %>
<jsp:include page="/include/header.jsp" />
<div class="content-wrapper">
	<section class="content-header">
		<h1>Thêm mới câu hỏi <%= monHoc.getTenMonHoc() %></h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều
					khiển</a></li>
			<li class="active"><a href="">Câu hỏi</a></li>
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
					<div class="form-horizontal" method="post" action="">
						<div class="box-body">
							<div class="tab-content">
								<div class="tab-pane active" id="tab-info">
									<div class="box-body">
										<div class="form-group">
											<label class="col-sm-2 control-label">Loại câu hỏi</label>
											<div class="col-sm-8">
												<label class="radio-inline"> <input type="radio"
													ng-model="type" name="loaiCauHoi" ng-value="0">Trắc
													nghiệm
												</label> <label class="radio-inline"> <input type="radio"
													ng-model="type" name="loaiCauHoi" ng-value="1">Tự
													luận
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Đề bài</label>
											<div class="col-sm-8">
												<textarea name="" ng-model="deBai" cols="40" rows="6"
													class="textarea"
													style="width: 100%; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px"
													placeholder="Đề bài"></textarea>
											</div>
										</div>
										<!-- Trắc nghiệm -->
										<div class="form-group" ng-show="type==0">
											<label class="col-sm-2 control-label">Đáp án</label>
											<div class="col-sm-8">
												<div id="multipleChoiceList">
													<div class="answer">

														<div class="row" ng-repeat="x in dsDapAn"
															style="padding: 5px 0 0 0;">
															<div class="col-sm-7">
																<input type="text" ng-model="x.noiDung"
																	class="form-control" ng-value="x.noiDung" />
															</div>
															<div class="col-sm-3">
																<label>Đáp án đúng <input type="checkbox"
																	ng-model="x.dapAnDung" ng-value="x.dapAnDung" />
																</label>
															</div>
															<div class="col-sm-2">
																<button class="btn btn-danger btn-xs btn-block"
																	ng-click="remove($index)">Xóa</button>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-4">
														<div ng-click="add()" class="btn btn-default btn-block"
															id="addChoice">
															<i class="fa fa-plus"></i> &nbsp; Thêm đáp án
														</div>
													</div>
												</div>
											</div>

										</div>
										<div class="form-group" ng-show="type==0">
											<div class="col-sm-2"></div>
											<div class="col-sm-8">
												<label><input type="checkbox"
													ng-model="coTheDaoDapAn"> Có thể xáo trộn đáp án</label>
											</div>
										</div>
										<!-- Tự luận -->
										<div class="form-group" ng-show="type==1">
											<label class="col-sm-2 control-label">Gợi ý đáp án</label>
											<div class="col-sm-8">
												<textarea ng-model="goiY" name="" cols="40" rows="3"
													class="textarea"
													style="width: 100%; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px"
													placeholder="Gợi ý đáp án"></textarea>
											</div>
										</div>
										<hr />
										<div class="form-group">
											<label class="col-sm-2 control-label">Độ khó</label>
											<div class="col-sm-3">
												<select name="" class="form-control" ng-model="doKho">
													<option value="1">1/5 - Cực Dễ</option>
													<option value="2">2/5 - Dễ</option>
													<option value="3">3/5 - Trung Bình</option>
													<option value="2">4/5 - Khó</option>
													<option value="2">5/5 - Cực Khó</option>
												</select>
											</div>
											<label class="col-sm-2 control-label">Chương</label>
											<div class="col-sm-3">
												<select ng-model="chuong" class="form-control">
												<%for(int i = 1, size = monHoc.getSoChuong(); i <= size; i++){%>
													<option value="<%=i%>">Chương <%=i%></option>
												<%}%>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Câu hỏi tương
												đương</label>
											<div class="col-sm-8">
												<!-- <div class="col-sm-2 pull-right"> -->
												<i>{{dsCauHoiTuongDuong[cauHoiTuongDuong].deBai}}</i>
												<button type="button" ng-click="change()"
													class="btn btn-default pull-right" data-toggle="modal"
													data-target="#myModal">
													<i class="fa fa-edit"></i>
												</button>
												<!-- </div> -->
											</div>
										</div>

									</div>
									<!-- /.box-body -->
									<p>{{cauHoi | json}}</p>

									<p>{{cauHoiTuongDuong}}</p>
									<p>{{message}}</p>
								</div>
								<!-- /.tab-pane -->

							</div>
							<!-- /.tab-content -->
						</div>

					</div>
					<div class="box-footer">
						<button ng-click="submit()" class="btn btn-info pull-right">Thêm
							mới</button>
					</div>
					<!-- /.box-footer -->
				</div>
				<!-- nav-tabs-custom -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</section>
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Chọn câu hỏi tương đương</h4>
				</div>
				<div class="modal-body" style="overflow: auto;">
					<select class="form-control" ng-model="cauHoiTuongDuong">
						<option value="-1">-Chọn câu hỏi tương đương-</option>
						<option ng-repeat="x in dsCauHoiTuongDuong" ng-value="{{$index}}">
							{{dsCauHoiTuongDuong[$index].deBai}}</option>

					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.content-wrapper -->


<%@ include file="/include/footer.jsp"%>



<script type="text/javascript">
	app.controller('myCtrl', function($scope, $http, $window, $location) {
		$scope.type = 0;
		$scope.doKho = "1";
		$scope.chuong = "1";
		$scope.coTheDaoDapAn = false;
		$scope.dsDapAn = [];
		$scope.dsCauHoiTuongDuong = [
		    <% ArrayList<LinkedList<CauHoi>> dsCauHoi = monHoc.getDsCauHoi(); %>
			<%for(int i = 0, size = dsCauHoi.size(); i < size; i++) { %> 
				{
					deBai: "<%= dsCauHoi.get(i).getFirst().getDeBai() %>"
				} <%if(i < size - 1) out.print(','); %>
				
					
			<%}%>
		];
		

		$scope.cauHoiTuongDuong = "-1";
		$scope.submit = function() {
			$scope.cauHoi = {};
			$scope.cauHoi.deBai = $scope.deBai;
			$scope.cauHoi.doKho = $scope.doKho;
			$scope.cauHoi.chuong = $scope.chuong;

			if ($scope.type)
				$scope.cauHoi.goiY = $scope.goiY;
			else {
				$scope.cauHoi.coTheDaoDapAn = $scope.coTheDaoDapAn;
				$scope.cauHoi.dsDapAn = $scope.dsDapAn;
			}

			var req = {
				method : 'POST',
				url : 'them-cau-hoi',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
 				data: $.param({
				
					cauHoi : JSON.stringify($scope.cauHoi),
					type : $scope.type,
					cauHoiTuongDuong : $scope.cauHoiTuongDuong
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
				// $window.open("danh-sach-cau-hoi","_self");
			}, function(response){
				$scope.message = "error";
			});
			
			
		};
		$scope.remove = function(i) {
			$scope.dsDapAn.splice(i, 1);
		};
		$scope.add = function() {
			dapAn = {};
			dapAn.noiDung = "";
			dapAn.dapAnDung = false;
			$scope.dsDapAn.push(dapAn);
		}

	});
</script>