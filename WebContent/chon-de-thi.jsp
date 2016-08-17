<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="opp.quanly.QuanLyDeThi"%>
<%@ page import="opp.quanly.QuanLyMonHoc"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.Date"%>
<jsp:include page="/include/header.jsp" />
<%
Properties p = QuanLyDeThi.getProperties();
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
						<!-- <h3 class="box-title pull-right">
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
						</div> -->
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
										<th class="text-center">Thao tác</th>
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
												<a href="lam-de-thi?maDeThi=<%=key%>" class="btn btn-default">
													 <i class="fa fa-file-o"></i>
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

</div>
<!-- /.content-wrapper -->
<%@ include file="/include/footer.jsp"%>
<script type="text/javascript">
		app.controller('myCtrl', function($scope, $http, $window, $location) {
			
		});
</script>