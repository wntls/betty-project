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
			
					<input class="board-detail board-title" type="text" value="자유게시판 제목" readonly>
					<hr />
					<div class="row">
						<div class="col-md-6">
							<div class="blog__details">
								<div class="thumb-list-profile">
								<!-- 게시글 데이터 수정 필요 -->
									<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" /> <span
										class="text-white">${user.nickname}</span>
								</div>
							</div>
						</div>
						<div class="col-md-6 text-white"
							style="line-height: 50px; text-align: right">2050-12-10</div>
					</div>
					
					<div class="spad-sm">
						<c:out value="${board.content}" escapeXml="false"></c:out>
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
