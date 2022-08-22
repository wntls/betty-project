<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <jsp:include page="./include/header.jsp"/> --%>
<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Slider Section Begin -->
<%@include file="/WEB-INF/views/include/section-slider.jsp"%>
<!-- Slider Section End -->
<style>
	.modal{
		color: graytext;
	}
</style>
<!-- 검색 -->
<div class="advance-search">
	<div class="container-md">
		<div class="row mt-5 justify-content-center">
			<form>
				<div class="form-row">
					<div class="input-group justify-content-center">
						<div class="input-group-prepend">
							<input type="text" class="form-control"
								placeholder="어떤 책을 찾으시나요?">
						</div>
						<button type="submit" class="btn btn-outline-danger mr-3">검색하기</button>
						<button type="button" class="btn btn-outline-danger"
						data-toggle="modal" data-target="#exampleModalCenter"
							id="modal_btn">상세 검색</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-black" id="exampleModalCenterTitle">상세
					검색</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="false">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<form>
					<div class="form-group">
						<label for="title">제목</label> <input type="text"
							class="form-control" id="title">
					</div>
					<div class="form-group">
						<label for="writer">저자</label> <input type="text"
							class="form-control" id="writer">
					</div>
					<div class="form-group">
						<label for="pub">출판사</label> <input type="text"
							class="form-control" id="pub">
					</div>
					<div class="form-group">
						<label for="pubDate">출간일</label>
						<div class="w-100"></div>
						<input type="date" class="form control mb-2" name="pubDate">
					</div>

				</form>

			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">검색</button>
				<button id="cancel-button" class="btn btn-secondary"
					data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<!-- Product Section Begin -->
<section class="product spad">
	<div class="container-md">
		<div class="row">
			<div class="col-md-8">
				<!-- 인기 도서 -->
				<div class="trending__product">
					<div class="row">
						<div class="col-md-8">
							<div class="section-title">
								<h4>인기 도서</h4>
							</div>
						</div>
						<div class="col-md-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">더보기 <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 댓글
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 조회수
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<!-- <li>책 카테고리</li> -->
										<li>장르</li>
										<li>작가</li>
									</ul>
									<h5>
										<a href="#">책 제목 적어야지</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 댓글
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 조회수
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<!-- <li>문학</li> -->
										<li>소설</li>
										<li>히가시노게이고</li>
									</ul>
									<h5>
										<a href="#">나미야 잡화점의 기적</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 댓글
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 조회수
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<!-- <li>문학</li> -->
										<li>소설</li>
										<li>무라카미 하루키</li>
									</ul>
									<h5>
										<a href="#">1Q84</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 추천 도서 -->
				<div class="popular__product">
					<div class="row">
						<div class="col-md-8">
							<div class="section-title">
								<h4>추천 도서</h4>
							</div>
						</div>
						<div class="col-md-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">더 보기 <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>IT</li>
										<li>구멍가게 코딩단</li>
									</ul>
									<h5>
										<a href="#">코드로 배우는 스프링 웹 프로젝트 개정판</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>IT</li>
										<li>신용권</li>
									</ul>
									<h5>
										<a href="#">혼자 공부하는 자바</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<!-- <div class="ep">18 / 18</div> -->
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>인문학</li>
										<li>마이클 샌델</li>
									</ul>
									<h5>
										<a href="#">정의란 무엇인가</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 최신 도서 -->
				<div class="recent__product">
					<div class="row">
						<div class="col-md-8">
							<div class="section-title">
								<h4>최신 도서</h4>
							</div>
						</div>
						<div class="col-md-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">Great Teacher Onizuka</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">Fate/stay night Movie: Heaven's Feel - II.
											Lost</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${path}/resources/img/book/800/9791158791919.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">Mushishi Zoku Shou: Suzu no Shizuku</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Section End -->

<%@include file="./include/footer.jsp"%>

</html>