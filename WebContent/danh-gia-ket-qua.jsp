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
<title>Đánh giá kết quả</title>

<link href="asset/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="asset/dist/css/thithu.css" rel="stylesheet" />
<script src="asset/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="asset/jQuery/angular.min.js"></script>
</head>
<%!
public static int tinhSoCauTracNghiem(ArrayList<CauHoi> list){
	int sum = 0;
	for(CauHoi cauHoi : list){
		if(cauHoi instanceof TracNghiem)
			sum++;
	}
	return sum;
}
%>
<%
DeThi deThi = (DeThi) session.getAttribute("deThi");
String answer = (String) session.getAttribute("answer");
ArrayList<CauHoi> dsCauHoi = deThi.getDsCauHoi();
ArrayList<CauHoi> dsCauHoiDung = (ArrayList<CauHoi>) request.getAttribute("dsCauHoiDung");
%>
<body ng-app="myApp" ng-controller="myCtrl">
<div class="container" >
	<h1><%=deThi.getTenDeThi() %></h1>
	<h3><span class="code">Mã đề thi: <%=deThi.getMaDeThi() %></span></h3>
	<h3>Thời gian: <%=deThi.getThoiGian() %> phút</h3>
	<hr />
	<h4>Trắc nghiệm: đúng <b><%=dsCauHoiDung.size() %>/<%=tinhSoCauTracNghiem(dsCauHoi) %></b> câu</h4>
	<div class="question-list">
		
		<%for(int i = 0, size = dsCauHoi.size(); i < size; i++){ %>
			<%CauHoi cauHoi = dsCauHoi.get(i); %>
			<%if(cauHoi instanceof TuLuan) { %>
				<div class="question">
			<%} else if(dsCauHoiDung.contains(cauHoi)) { %>
				<div class="question true">
			<%} else { %>
				<div class="question false">
			<%} %>
			
			<span class="no"><%=i+1 %></span>
			
			<div class="title"><%=cauHoi.getDeBai() %></div>
			<%if(cauHoi instanceof TracNghiem){ %>
			<ol class="choice">
				<%
				TracNghiem tn = (TracNghiem) cauHoi;
				ArrayList<DapAn> dsDapAn =  tn.getDsDapAn();
				%>
				<%for(int j = 0, size1 = dsDapAn.size(); j < size1; j++){ %>
				<%DapAn dapAn = dsDapAn.get(j); %>
				<%if(dapAn.isDapAnDung()){ %>
					<li class="true check">
				<%} else { %>
					<li>
				<%} %>
				<label><input type="checkbox" ng-model="list[<%=i %>][<%=j %>]" readonly disabled/><%=dapAn.getNoiDung() %></label></li>
				<%} %>
			</ol>
			<%} else {%>
				<%TuLuan tl = (TuLuan) cauHoi; %>
				<div class="answer">
					<p>Câu trả lời:</p>
					<textarea ng-bind="list[<%=i %>]" rows="10" readonly disabled></textarea>
					<p>Đáp án:</p>
					<textarea placeholder="<%=tl.getGoiY() %>" rows="10" readonly disabled></textarea>
				</div>
			<%} %>
			</div><!-- .question -->
		<%} %>
		
	</div>
</div>
</body>
</html>


<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.list = <%=answer%>
});
</script>
