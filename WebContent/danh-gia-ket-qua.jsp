<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="vi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kết quả</title>

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
	.question.true .no { background: #8BC34A; border-color: #8BC34A; color: #FFF; }
	.question.false .no { background: #F44336; border-color: #F44336; color: #FFF; }
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
<body>
<form action="" method="POST" class="container">
	<h1>Đề thi môn XXXXX học kì 11111</h1>
	<h3><span class="code">Mã đề thi: YYYYY</span></h3>
	<h3>Thời gian: 111 phút</h3>
	<hr />
	<h4>Trắc nghiệm: đúng <b>11/22</b> câu</h4>
	<div class="question-list">
		<div class="question true">
			<span class="no">1</span>
			<div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores voluptatibus tempore aut aliquid a quam, laboriosam laudantium possimus accusamus odio atque eum fuga ipsum laborum nostrum iure, culpa modi ducimus!</div>
			<ol class="choice">
				<li class="true"><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li class="false"><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li class="true check"><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
			</ol>
		</div><!-- .question -->
		<div class="question false">
			<span class="no">2</span>
			<div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores voluptatibus tempore aut aliquid a quam, laboriosam laudantium possimus accusamus odio atque eum fuga ipsum laborum nostrum iure, culpa modi ducimus!</div>
			<ol class="choice">
				<li><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
				<li><label><input type="checkbox" name="" value="" readonly /> Nihil ipsam tempore deleniti itaque doloremque vitae, ea id veritatis.</label></li>
			</ol>
		</div><!-- .question -->
	</div>
	<br />
	<h4>Tự luận: <b>111</b> câu</h4>
	<div class="question-list">
		<div class="question">
			<span class="no">3</span>
			<div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores voluptatibus tempore aut aliquid a quam, laboriosam laudantium possimus accusamus odio atque eum fuga ipsum laborum nostrum iure, culpa modi ducimus!</div>
			<div class="answer">
				<p>Câu trả lời:</p>
				<textarea name="" id="" rows="10" readonly>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Modi suscipit, consectetur consequatur dolore, a qui animi optio amet beatae voluptas tempore tenetur mollitia porro inventore, id totam libero deleniti hic.</textarea>
			</div>
		</div><!-- .question -->
		<div class="question">
			<span class="no">4</span>
			<div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores voluptatibus tempore aut aliquid a quam, laboriosam laudantium possimus accusamus odio atque eum fuga ipsum laborum nostrum iure, culpa modi ducimus!</div>
			<div class="answer">
				<p>Câu trả lời:</p>
				<textarea name="" id="" rows="10" readonly></textarea>
			</div>
		</div><!-- .question -->
	</div>
</form>
</body>
</html>