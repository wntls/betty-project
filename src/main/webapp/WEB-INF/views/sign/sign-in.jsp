<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- 로그인 화면 윗 공간 -->
<section class="normal-breadcrumb set-bg"
	data-setbg="img/normal-breadcrumb.jpg">
	<div class="container-md">
		<div class="row">
			<div class="col-md-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>환영합니다!</h2>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- Login Section Begin -->
<section class="login">
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="login__form">
				<form>
					<div class="list-group justify-content-center">
						<div class="input__item">
							<input type="text" name="memberId" placeholder="아이디"> <span
								class="icon_profile"></span>
						</div>
						<div class="input__item">
							<input type="password" name="pw" placeholder="비밀번호"> <span
								class="icon_lock"></span>
						</div>
						<div class="form-check" style="width: 100%; text-align: center">
							<input class="form-check-input" type="checkbox" name="cookie"
								id="loginCookie"> <label class="form-check-label"
								for="loginCookie">로그인시 쿠키 저장</label>
						</div>

						<!-- 버튼 크기 == input__itme 크기 -->
						<div class="row justify-content-center">
							<button type="submit" class="common-btn btn" style="width: 50%">로그인</button>
						</div>
					</div>
				</form>
				<!-- login form의 right 정렬 -->
				<ul
					class="list-group list-group-horizontal-md justify-content-center">
					<li class="list-group-item"><a data-toggle="modal"
						data-target="#idFindModal">아이디 찾기</a></li>
					<li class="list-group-item"><a data-toggle="modal"
						data-target="#passFindModal">비밀번호 찾기</a></li>
				</ul>
			</div>
		</div>

		<!-- idFind Modal -->
		<div class="modal fade" id="idFindModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">아이디 찾기</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- 입력태그 하나 -->
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">이름</div>
							</div>
							<input type="text" class="form-control" name="name">
								
						</div>
						
						<div class="input-group mt-3">
						  <div class="input-group-prepend">
						    <span class="input-group-text">전화번호</span>
						  </div>
						  <input type="text" class="form-control" name="phone">
						  <button id="idFindModalPhoneCheck">인증하기</button>
						</div>
						
						<br />
						<!-- 입력태그 하나 -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		<!-- id Find Modal/ -->


		<!-- passFindModal -->
		<div class="modal fade" id="passFindModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">비밀번호 찾기</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- 입력태그 하나 -->
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<div class="input-group-text">아이디</div>
							</div>
							<input type="text" class="form-control" name="memberId">
						</div>
						
						<!-- 입력태그 하나 -->
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<div class="input-group-text" id="passFindInputPass">전화번호
								</div>
							</div>
							<input type="text" class="form-control" name="phone">
							<button id="idFindModalPhoneCheck">인증하기</button>
						</div>
						<br />
						<!-- 입력태그 하나 -->

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		<!-- passFind modal/ -->



	</div>
</section>
<!-- Login Section End -->

<%@include file="/WEB-INF/views/include/footer.jsp"%>
