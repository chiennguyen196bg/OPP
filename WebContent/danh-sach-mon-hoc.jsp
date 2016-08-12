<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="opp.quanly.QuanLyMonHoc"%>
<%@ page import="java.util.Properties"%>
<jsp:include page="/include/header.jsp" />

<%
	Properties p = QuanLyMonHoc.getProperties();
%>
<div class="content-wrapper">
	<section class="content-header">
		<h1>Quản lý môn học</h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều
					khiển</a></li>
			<li class="active"><a href=""><i class="fa fa-pencil"></i>
					Môn học</a></li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title pull-right">
							<div class="btn-group">
								<a href="them-sua-mon-hoc" class="btn btn-default btn-flat"><i
									class="fa fa-plus"></i> Thêm mới</a>
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
										<th>Tên môn học</th>
										<th>Mã học phần</th>
										<th class="text-right">Thao tác</th>
									</tr>
									<%
										for (String key : p.stringPropertyNames()) {
									%>
									<tr>
										<td><div><%=p.getProperty(key)%></div></td>
										<td><%=key%></td>
										<td class="text-right">
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
					<!-- /.box-body -->

				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
</div>
<!-- /.content-wrapper -->

<%@ include file="/include/footer.jsp"%>

<script type="text/javascript">
		app.controller('myCtrl', function($scope, $http, $window, $location) {
			$scope.delete = function(key){
				var req = {
					method : 'POST',
					url : 'danh-sach-mon-hoc',
					headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	 				data: $.param({
						maHocPhan : key,
						action : "delete"
					})
				};
				$http(req).then(function(response){
					$scope.message = response.data;
					$window.location.reload();
				}, function(response){
					$scope.message = "error";
				});
			}
			$scope.edit = function(key){
				$window.open("them-sua-mon-hoc?maHocPhan="+key, "_self");
			}
		});
</script>