<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>BTL OOP</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<script src="asset/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	</head>
	<body class="hold-transition skin-blue sidebar-mini" ng-app="myApp" ng-controller="myCtrl">
		<script type="text/javascript">
			var app = angular.module('myApp', []);
		</script>
		<div class="wrapper" ng-init="updateListCauHoi()">
		<button ng-click="updateListCauHoi()">List</button>
<button ng-click="addToDeThi()">Them</button>
<button ng-click="xoaCauHoi()">Xóa</button>
<button ng-click="getDeThi()">Check</button>
<button ng-click="thayThe();getDeThi()">Thay The </button>
<p>{{message}}</p>
</div>
</body>
</html>


<script type="text/javascript">
	app.controller('myCtrl', function($scope, $http, $window, $location) {
		
		
		$scope.cauHoiInfo = "";
		$scope.listCauHoi = {
			type: 0,
			list : []
		};
		$scope.listCauHoiTrongDe = {
				list : []
		};
		$scope.deThi = "";
		

		$scope.select = function($index){
			$scope.listCauHoi.index = $index;
		};
		$scope.selectDeThi = function($index){
			$scope.listCauHoiTrongDe.index = $index;
		};

		$scope.updateListCauHoi = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action : "getCauHoiList",
					type : $scope.listCauHoi.type
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.getInfo = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "getCauHoiInfo",
					index1 : 1,
					index2 : 0
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
			
		};




		$scope.addToDeThi = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "addToDeThi",
					index1 : 0,
					index2 : 0,
					diem : 3.5
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.getCauHoiDeThi = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "getCauHoiDeThi"
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.getDeThi = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "getDeThi"
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.xoaCauHoi = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "xoaCauHoi",
					index : 0
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};

		$scope.thayThe = function(){
			var req = {
				method : 'POST',
				url : 'them-bang-tay',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data : $.param({
					action: "thayThe",
					index : 0
				})
			};
			$http(req).then(function(response){
				$scope.message = response.data;
			}, function(response){
				$scope.message = "error";
			});
		};		
		$scope.updateListCauHoi;		
	});
</script>

