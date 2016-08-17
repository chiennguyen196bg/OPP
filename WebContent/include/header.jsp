<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>BTL OOP</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link href="asset/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="asset/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="asset/dist/css/AdminLTE.min.css" rel="stylesheet" />
		<link href="asset/dist/css/AdminLTE.custom.css" rel="stylesheet" />
		<link href="asset/dist/css/skins/skin-blue.min.css" rel="stylesheet" />
		<script src="asset/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
		<script src="asset/jQuery/angular.min.js"></script>
	</head>
	<body class="hold-transition skin-blue sidebar-mini" ng-app="myApp" ng-controller="myCtrl">
		<script type="text/javascript">
			var app = angular.module('myApp', []);
		</script>
		<header>
			<section class="content-header text-center" style="padding-bottom:15px">
				<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Trang chủ</a>
				<a href="${pageContext.request.contextPath}/danh-sach-mon-hoc" class="btn btn-primary">Quản lý môn học</a>
				<a href="${pageContext.request.contextPath}/danh-sach-de-thi" class="btn btn-primary">Quản lý đề thi</a>
				<a href="${pageContext.request.contextPath}/chon-de-thi" class="btn btn-primary">Làm bài thi</a>
			</section>
		</header>
		<div class="wrapper">