<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<h2>자유게시판</h2>
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="row justify-content-between mb-2">
						<div class="col-auto">
								<div class="btn-group" id="subject">
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="">전체</button>
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="li">일상</button>
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="qu">질문</button>
							  <button type="button" class="btn btn-secondary" name="abc" value="re">후기</button>
							</div>
						</div>
						<div class="col-auto">
							<select id="perPageNum">
								<option selected="selected">5</option>
								<option>10</option>
								<option>20</option>
							</select>
						</div>
					</div>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<!-- 1 -->
							<tr>
								<td>1</td>
								<td>{일상} {title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
							</tr>
							<!-- 2 -->
							<tr>
								<td>2</td>
								<td>{일상} {title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
							</tr>
						</tbody>
					</table>


				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-6">
					<form id="searchForm" action="${path}/">
						<div class="form-row input-group mb-3">
							<div class="input-group-prepend">
								<select id="searchType">
									<option value="t">제목</option>
									<option value="w">작성자</option>
									<option value="c">내용</option>
								</select>
							</div>
							<input type="text" class="form-control" id="keyword">
							<div class="input-group-append">
								<button type="submit" onclick="testPrint(event)" class="btn btn-primary">검색하기</button>
							</div>
						</div>
					</form>
				</div>
				<div class="w-100"></div>

				<!-- 페이징 처리 -->
				<div class="form-row">
					<ul class="pagination" id="pa">
						<li><a href="#">Previous</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
<<<<<<< HEAD
</html>

<script>
<!--
let searchSet =  어떻게 말머리, 펄페이지넘, 폼데이터를 잘 모았어, 현재 페이지 번호까지 모았어 
{ subject : re, perPageNum : 5 }
	$.ajax({
		type: 'get',
		url: "${path}/boards/free/getList",
		data: searchSet,
		success: function(result){
			tr 생성도 해야되고
			생성한 tr에 번호도 넣어야되고
					
			result[0].
			
			for (let i=0; i< result.length; i++){
			String createTr = `
					<tr>
						<td id="title">
							${result[i].nickname}				
						</td>
					</tr>
			
			`
			comment.ref
			
			id="mainhead"
			
			$('#mainhead').appent(createTr)
			
			
			}
		}
	});



$("button[name=abc]").on("click",function(event){
	console.log(this.value);
	this.setAttribute("active","");
	
	
});

	$('#searchForm').on("submit",function(event){
		event.preventDefault();
		let focusBtn = $('#subject button :active').val();
		console.log("10 focusBtn = "+$(':focus').val());
		console.log("11 focusBtn = "+$('.focus').val());
		console.log("12 button:active = "+$('button:active').val());
		console.log("13 selected = "+$('.selected').val());
		console.log("14 checkd = "+$('.checked').val());
		console.log("15 focusBtn = "+$('button:focus').val());
		console.log("16 $(this).val()"+$(this).val());
		console.log("17 this.value"+this.value);
		let formData = new FormData();
		formData.append('searchType', $('#searchType').val());
		formData.append('keyword', $('#keyword').val());
		console.log("18 서치타입 = "+formData.get('searchType'));
		console.log("19 키우드 = "+formData.get('keyword'));
		console.log("20 "+formData['searchType']);
		
		 /* form 입력 데이터와 perPageNum, 말머리 */ 
	});
	
	function testPrint(event){
		console.log("1 focusBtn = "+$(':focus').val());
		console.log("2 focusBtn = "+$('.focus').val());
		console.log("3 button:active = "+$('button:active').val());
		console.log("4 selected = "+$('.selected').val());
		console.log("5 checkd = "+$('.checked').val());
		console.log("6 focusBtn = "+$('button:focus').val());
		console.log("7 "+event);
		console.log("8 "+event.value);
		console.log("9 "+$('#keyword').val());
	}
	-->
	
</script>
=======
>>>>>>> dev

