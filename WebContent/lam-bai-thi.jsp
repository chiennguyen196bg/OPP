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

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>


<style rel="stylesheet" type="text/css">
	body { font: 15px / 20px Arial; margin: 0; background: #555; }
	.container { max-width: 1000px; margin: 0 auto; padding: 15px 30px; background: #FFF; min-height: 100vh; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; }
	h1 { text-align: center; }
	h3 { text-align: center; font-weight: normal; }
	.code { display: inline-block; border: 1px solid #CCC; padding: 5px 10px; }
	hr { border-top: 1px solid #CCC; }
	h4 { font-size: 20px; font-weight: normal; }
	.question { padding-left: 35px; }
	.question+.question { margin-top: 15px; padding-top: 15px; border-top: 1px solid #CCC; }
	.question .no { float: left; margin-left: -35px; font-weight: bold; display: inline-block; border: 1px solid #CCC; border-radius: 50%; width: 20px; text-align: center; background: #EEE; }
	.question .title { padding-bottom: 5px; font-size: 110%; }
	.question .choice { list-style: upper-alpha; }
	.question .choice li { margin: 5px 0 0; }
	.question .choice li label { display: inline-block; position: relative; vertical-align: top; padding-left: 40px; margin-left: -40px; }
	.question .choice li input[type=checkbox] { -webkit-appearance: none; -moz-appearance: none; appearance: none; border: 1px solid #CCC; height: 15px; width: 15px; margin: 0; outline: 0; position: absolute; top: 2px; left: 0; }
	.question .choice li input[type=checkbox]:checked:before, .question .choice li input[type=checkbox]:indeterminate:before { content: "\f00c"; font-family: FontAwesome; font-size: 12px; -webkit-font-smoothing: antialiased; text-align: center; line-height: 13px; color: #00a8e6; display: block; }
	.question .choice li input[type=checkbox][readonly] { background: #DDD; }
	.question .choice li.true { color: #009500; }
	.question .choice li.false { color: #BE2121; }
	.question .choice li.check { font-weight: bold; }
	.question .answer p { margin: 5px 0; }
	.question .answer textarea { width: 100%; resize: none; font-family: Arial; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box; }
	.question .answer textarea[readonly] { background: #DDD; }
	.finish { padding: 15px 0; margin: 15px auto 0; max-width: 400px; }
	.finish .submit { border: 0; background: #2196F3; color: #FFF; width: 100%; height: 35px; font-size: 120%; cursor: pointer; }
	.finish .submit:hover { background: #1C82D3; }
</style>
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
		<div class="question">
		<%for(int i = 0, size = dsCauHoi.size(); i < size; i++){ %>
			<span class="no"><%=i+1 %></span>
			<%CauHoi cauHoi = dsCauHoi.get(i); %>
			<div class="title"><%=cauHoi.getDeBai() %></div>
			<%if(cauHoi instanceof TracNghiem){ %>
			<ol class="choice">
				<%
				TracNghiem tn = (TracNghiem) cauHoi;
				ArrayList<DapAn> dsDapAn =  tn.getDsDapAn();
				%>
				<%for(int j = 0, size1 = dsDapAn.size(); j < size1; j++){ %>
				<%DapAn dapAn = dsDapAn.get(j); %>
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
		<%} %>
		</div><!-- .question -->
	</div>
	<p>{{list | json}}</p>
	<div class="finish"><button class="submit">Nộp bài</button></div>
</div>
</body>
</html>


<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
});
</script>
