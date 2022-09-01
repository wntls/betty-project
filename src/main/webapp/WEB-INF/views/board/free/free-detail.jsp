<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Blog Details Section Begin -->
<h2>${pm.cri.page}</h2>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			
			
			<div class="col-md-8">
			<div class="board-detail board-title text-secondary">
				<span>자유 게시판</span>
			</div>
			<div class="w-100"></div>
			
					<input class="board-detail board-title" type="text" value="${board.title}" readonly>
					<hr />
					<div class="row">
						<div class="col-md-6">
							<div class="blog__details">
								<div class="thumb-list-profile">
								<!-- 게시글 데이터 수정 필요 -->
									<img src="${path}/resources/img/member/thumbnail/${img}" /> <span
										class="text-white">${board.nickname}</span>
								</div>
							</div>
						</div>
						<div class="col-md-6 text-white"
							style="line-height: 50px; text-align: right">
								<f:formatDate value="${board.regdate}" pattern="yyyy-MM-dd (E) hh:mm"/>
							</div>
					</div>
					
					<div class="spad-sm">
						<c:out value="${board.content}" escapeXml="false"></c:out>
					</div>
			

			<div class="w-100"></div>

			<div class="blog__details__btns">
				<div class="row justify-content-between">
					<div class="col-md float-left">
						<button type="button" class="btn btn-danger">목록</button>
						<button type="button" id="testBtn" class="btn btn-danger">테스트</button>
					
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
			
			<h4>총 2개의 댓글</h4>
			<div class="blog__details__comment">
			<div id="commentBox"></div>
			<div class="blog__details__comment__item">
				<div class="anime__review__item__pic">
					<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
				</div>
				<div class="blog__details__comment__item__text">
					<span>comment.regdate</span>
					<h5>comment.nickname</h5>
					<p>comment.content</p>
					<a href="#">답글</a> <a href="#">삭제</a>
				</div>
			</div>
			<div class="blog__details__form">
				<h4>댓글 작성란</h4>
				<form action="#">
					<div class="row" style="display: block">
						<div class="col-md-12">
							<textarea id="commentArea" placeholder="Message"></textarea>
							<button id="addBtn" type="submit" class="site-btn">작성</button>
						</div>
					</div>
				</form>
			</div>
		</div>
			</div>
		</div>
	</div>
</section>


<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>

	$("#testBtn").click(function(){
		location.href='${path}/boards/free?${pm.makeQuery(pm.cri.page)}';
		console.log('${pm.cri.page}');
	});
	
	$(function(){
		$.ajax({
			type: "get",
			url: "${path}/boards/free/${board.bno}/comments",
			dataType: 'json',
			success: function(data){
				console.log(data);
				console.log(data.length);
				let comment = "";
				let sessionUser = '${user.id}';
				for(let i = 0; i < data.length; i++){
					console.log(i);
					console.log(data[i].nickname);
					comment = 
						`<div class="blog__details__comment__item 
							\${data[i].origin == 0 ? '' : 'blog__details__comment__item--reply'}">
								<div class="anime__review__item__pic">
								<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
							</div>
							<div class="blog__details__comment__item__text">
								<span>\${data[i].regdate}</span>
								<h5>${user.nickname}</h5>
								<p>\${data[i].comment}</p>
								<a href="#">답글</a>
							\${ ((data[i].origin != 0) && (data[i].memberId == sessionUser)) ? 
									'<a href="#">삭제</a>' 
									: 
									''}
							</div>
						</div>`;
						
						$('#commentBox').append(comment);
				}
			},
			error: function(){
				alert("호출 실패");
			}
		});
	});
	

	$("#addBtn").click(function() {
		var commentArea = $("#commentArea").val();
		
		$.ajax({
			type : "POST",
			url : "${path}/boards/free/${board.bno}/comments",
			dataType : "text",
			data : {
				freeBno : ${board.bno},
				comment : commentArea
			},
			success : function(result) {
				
			}
		});
	});
	
</script>

















