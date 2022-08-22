<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Blog Details Section Begin -->
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			
			
			<div class="col-md-8">
			<div class="board-detail board-title text-secondary">
				<span>자유 게시판</span>
			</div>
			<div class="w-100"></div>
			
					<input class="board-detail board-title" type="text" value="제목" readonly>
					<hr />
					<div class="row">
						<div class="col-md-6">
							<div class="blog__details">
								<div class="thumb-list-profile">
									<img src="${path}/resources/img/member/thumb_profile_male.png" /> <span
										class="text-white">닉네임</span>
								</div>
							</div>
						</div>
						<div class="col-md-6 text-white"
							style="line-height: 50px; text-align: right">2050-12-10</div>
					</div>
					<div class="board-detail row spad-sm">
						<textarea id="textArea" readonly>
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							[자유 게시판 내용]
							</textarea>
					</div>
			

			<div class="w-100"></div>

			<div class="blog__details__btns">
				<div class="row justify-content-between">
					<div class="col-md float-left">
						<button type="button" class="btn btn-danger">목록</button>
					
					</div>
					<div class="col-md">
						<div class="btn-group float-right" role="group">
							<button class="btn btn-danger">수정</button>
							<button class="btn btn-secondary ml-3">삭제</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="w-100"></div>
			
			<%@include file="/WEB-INF/views/board/free/fragment/free-detail-comment.jsp" %>
			</div>
		</div>
	</div>
</section>


<%@include file="/WEB-INF/views/include/footer.jsp"%>

</html>

<script>
	$(document).ready(function (){
		console.log("0");
		var ta = $("#textArea");
		console.log("1");
		console.log("ta "+ta);
		console.log("2");
		ta.css('height','auto');
		console.log("3");
		var taH = ta.prop('scrollHeight');
		console.log("4");
		console.log("taH " + taH);
		ta.css('height', taH);
		console.log("5");
	});
</script>