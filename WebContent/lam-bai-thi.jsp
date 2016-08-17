<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="opp.model.DeThi" %>
<%@ page import="opp.model.DapAn" %>
<%@ page import="opp.model.CauHoi" %> 
<%@ page import="opp.model.TracNghiem" %> 
<%@ page import="opp.model.TuLuan" %> 
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>   

<!DOCTYPE html>
<html lang="vi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Thi thứ</title>

<link href="asset/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="asset/dist/css/thithu.css" rel="stylesheet" />
<script src="asset/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="asset/jQuery/angular.min.js"></script>
</head>

<%
DeThi deThi = (DeThi) session.getAttribute("deThi");
ArrayList<CauHoi> dsCauHoi = deThi.getDsCauHoi();
%>
<body ng-app="myApp" ng-controller="myCtrl">
<div class="container" >
	<h1><%=deThi.getTenDeThi() %></h1>
	<h3><span class="code">Mã đề thi: <%=deThi.getMaDeThi() %></span></h3>
	<h3>Thời gian: <%=deThi.getThoiGian() %> phút</h3>
	<hr />
	<div class="question-list">
		
		<%for(int i = 0, size = dsCauHoi.size(); i < size; i++){ %>
		<div class="question">
			<span class="no"><%=i+1 %></span>
			<%CauHoi cauHoi = dsCauHoi.get(i); %>
			<div class="title"><%=cauHoi.getDeBai() %></div>
			<%if(cauHoi instanceof TracNghiem){ %>
				<ol class="choice">
					<%
					TracNghiem tn = (TracNghiem) cauHoi;
					ArrayList<DapAn> dsDapAn =  tn.getDsDapAn();
					%>
					<%for(int j = 0, size1 = dsDapAn.size(); j < size1; j++){ 
					DapAn dapAn = dsDapAn.get(j); %>
					<li><label><input type="checkbox" ng-model="list[<%=i %>][<%=j %>]"/><%=dapAn.getNoiDung() %></label></li>
					<%} %>
				</ol>
			<%} else {%>
				<%TuLuan tl = (TuLuan) cauHoi; %>
				<div class="answer">
					<p>Câu trả lời:</p>
					<textarea ng-model="list[<%=i %>]" rows="10"></textarea>
				</div>
			<%} %>
			</div><!-- .question -->
		<%} %>
		
	</div>
	<p>{{list | json}}</p>
	<p>{{message}}</p>
	<div class="finish"><button ng-click="submit()" class="submit">Nộp bài</button></div>
</div>
</body>
</html>

<script type="text/javascript">
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http, $window){
	$scope.submit = function(){
		var req = {
			method : 'POST',
			url : 'lam-de-thi',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			data : $.param({
				answer : JSON.stringify($scope.list)
			})
		};
		$http(req).then(function(response){
			$scope.message = response.data;
			$window.open("danh-gia-ket-qua","_self");
		},function(response){
			$scope.message = "error";
		});
	};
});

</script>