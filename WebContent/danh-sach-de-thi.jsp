<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="opp.quanly.QuanLyDeThi"%>
<%@ page import="opp.quanly.QuanLyMonHoc"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.Date"%>
<jsp:include page="/include/header.jsp" />
<%
Properties p = QuanLyDeThi.getProperties();
Properties pMonHoc = QuanLyMonHoc.getProperties();
Date date = new Date();
%>
<div class="content-wrapper">
	<section class="content-header">
		<h1>Quản lý đề thi</h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều
			khiển</a></li>
			<li class="active"><a href=""><i class="fa fa-pencil"></i>
			Đề thi</a></li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-block" data-toggle="modal" data-target="#myModal">Thêm mới</button>
						</div>
						</h3>
						<div class="box-tools pull-left">
							<form method="get" action="">
								<div class="input-group pull-left" style="width: 250px;">
									<input type="text" name="keyword" value="" class="form-control"
									placeholder="Search">
									<div class="input-group-btn">
										<button type="submit" value="action" class="btn btn-default">
										<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<form method="post" action="">
							<input type="hidden" name="ci_csrf_token" value="">
							<table class="table table-hover" id="diagnosis-list">
								<tbody>
									<tr class="ui-sortable-handle">
										<th>Tên đề thi</th>
										<th>Thời gian tạo</th>
										<th class="text-right">Thao tác</th>
									</tr>
									<%
									for (String key : p.stringPropertyNames()) {
									date.setTime(Long.parseLong(key));
									%>
									<tr>
										<td><div><%=p.getProperty(key)%></div></td>
										<td><div><%=date.toString() %></div></td>
										<td class="text-right" style="width:130px;">
											<div class="btn-group">
												<a href="" class="btn btn-default"
													ng-click="edit('<%=key%>')"> <i class="fa fa-edit"></i>
												</a> <a href="" class="btn btn-default"
												ng-click="delete('<%=key%>')"> <i class="fa fa-trash"></i>
											</a>
										</div>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</form>
				</div>
				<p>{{message}}</p>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
</section>
</div>
<div id="myModal" class="modal fade" role="dialog">
<div class="modal-dialog">
	<!-- Modal content-->
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Chọn môn học</h4>
		</div>
		<div class="modal-body" style="overflow:auto;">
			<select class="form-control" ng-model="maHocPhan">
				<option value="">--Chọn môn học--</option>
				<%for(String key : pMonHoc.stringPropertyNames()){ %>
				<option value="<%= key %>"><%= pMonHoc.getProperty(key) %></option>
				<%} %>
				
			</select>
			<br/>
			<div class="pull-right">
				
				<a href="danh-sach-mon-hoc">Quản lý môn học</a>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" ng-click="onclick('tuDong')" class="btn btn-primary">Tao tự động</button>
			<button type="button" ng-click="onclick('bangTay')" class="btn btn-primary">Tao bằng tay</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		</div>
	</div>
</div>
</div>
<!-- /.content-wrapper -->
<%@ include file="/include/footer.jsp"%>
<script type="text/javascript">
		app.controller('myCtrl', function($scope, $http, $window, $location) {
			$scope.delete = function(key){
				var req = {
					method : 'POST',
					url : 'danh-sach-de-thi',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
					data: $.param({
						maDeThi : key,
						action : "delete"
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
					// $window.location.reload();
				}, function(response){
					$scope.message = "error";
				});
			}
			$scope.edit = function(key){
				$window.open("sua-de-thi?maDeThi="+key, "_self");
			}
			$scope.onclick = function(str){
				if($scope.maHocPhan != null)
					$window.open("tao-de-thi?maHocPhan=" +  $scope.maHocPhan +"&taoDeThi=" + str, "_self");
			};
		});
</script>