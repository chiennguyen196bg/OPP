<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Properties" %>

<%@ page import="opp.model.MonHoc" %>
<%@ page import="java.lang.Object" %>
<%@ page import="opp.quanly.QuanLyMonHoc" %>



<jsp:include page="/include/header.jsp" />



<%
	Properties p = QuanLyMonHoc.getProperties();
%>
<div class="content-wrapper">
				<section class="content-header">
					<h1>Bảng điều khiển</h1>
					<ol class="breadcrumb">
						<li class="active"><a href=""><i class="fa fa-dashboard"></i> Bảng điều khiển</a></li>
					</ol>
				</section>
				<section class="content">
					<div class="col-md-12">
						<div class="col-md-6 col-md-offset-3">
							<button type="button" class="btn btn-default btn-block" data-toggle="modal" data-target="#myModal" ng-click="link = 'danh-sach-cau-hoi'">Soạn câu hỏi</button>
							<button type="button" class="btn btn-default btn-block" data-toggle="modal" data-target="#myModal" ng-click="link = '/danh-sach-cau-hoi.html'">Xây dựng đề thi</button>
							<button type="button" class="btn btn-default btn-block" data-toggle="modal" data-target="#myModal" ng-click="link = '/danh-sach-cau-hoi.html'">Button 1</button>
						</div>
					</div>
					
				</section>
			</div>
			<!-- /.content-wrapper -->
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
								<%for(String key : p.stringPropertyNames()){ %>
								<option value="<%= key %>"><%= p.getProperty(key) %></option>
								<%} %>
								
							</select>
							<br/>
							<div class="pull-right">
								
								<a href="danh-sach-mon-hoc">Quản lý môn học</a>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" ng-click="onclick()" class="btn btn-primary">OK</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
<%@ include file="/include/footer.jsp"%>

<script>
	
	app.controller('myCtrl', function($scope, $http, $window, $location) {
		// $scope.maMonHoc == "it2030";
		// $scope.check = $scope.maMonHoc == null;
		$scope.onclick = function(){
			if($scope.maHocPhan != null)
				$window.open($scope.link + "?maHocPhan=" + $scope.maHocPhan, "_self");
			
		};
	});
	</script>
