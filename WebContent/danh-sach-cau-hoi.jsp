<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="opp.model.MonHoc"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="opp.model.CauHoi"%>

<jsp:include page="/include/header.jsp" />


<%
	MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
	ArrayList<LinkedList<CauHoi>> dsCauHoi = monHoc.getDsCauHoi();
%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>Quản lý câu hỏi</h1>
		<ol class="breadcrumb">
			<li><a href=""><i class="fa fa-dashboard"></i> Bảng điều
					khiển</a></li>
			<li class="active"><a href=""><i
					class="fa fa-question-circle"></i> Câu hỏi</a></li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title pull-right">
							<div class="btn-group">
								<a href="them-cau-hoi" class="btn btn-default btn-flat"><i
									class="fa fa-plus"></i> Thêm mới</a>
							</div>
						</h3>

					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<form method="post" action="">
							<input type="hidden" name="ci_csrf_token" value="">
							<table class="table table-hover" id="diagnosis-list">
								<tbody>
									<tr class="ui-sortable-handle">
										<th>Đề bài</th>
										<th>Độ khó</th>
										<th class="text-right">Thao tác</th>
									</tr>
								<%for(int i1 = 0, size1 = dsCauHoi.size(); i1 < size1; i1++){ %>
									<% LinkedList<CauHoi> dsTuongDuong = dsCauHoi.get(i1); %>
									<%for(int i2 = 0, size2 = dsTuongDuong.size(); i2 < size2; i2++){ %>
									<%CauHoi cauHoi = dsTuongDuong.get(i2); %>
									<tr>
										<td style="min-width: 300px; max-width:400px"><p><%= cauHoi.getDeBai() %></p></td>
										<td><b><%= cauHoi.getDoKho() %></b>/5</td>
										<td class="text-right inline pull-right">

											<div class="btn-group" style="margin-top: 5px;">
												<a href="" class="btn btn-default" ng-click="edit(<%= i1%>, <%= i2%>)"> <i
													class="fa fa-edit"></i>
												</a> <a href="" class="btn btn-default" ng-click="delete(<%= i1%>, <%= i2%>)">
													<i class="fa fa-trash"></i>
												</a>
											</div>
										</td>
									</tr>
									<%} %>
								<%} %>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
</div>
<!-- /.content-wrapper -->
<p>{{message}}</p>

<%@ include file="/include/footer.jsp"%>

<script type="text/javascript">
			app.controller('myCtrl', function($scope, $http, $window, $location) {

				$scope.delete = function(i1, i2){
					
					var req = {
						method : 'POST',
						url : 'danh-sach-cau-hoi',
						headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		 				data: $.param({
							index1 : i1,
							index2 : i2,
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
				$scope.edit = function(i1, i2){
					$window.open("sua-cau-hoi?index1="+i1+"&index2="+i2,"_self");
				}
			});
		</script>