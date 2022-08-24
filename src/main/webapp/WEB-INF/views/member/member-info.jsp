<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="section-title">
				<div class="row justify-content-between">
					<div class="col-auto">
						<h4>회원 정보</h4>
					</div>
					<div class="col-auto">
						<button class="btn btn-danger"
							onclick="location.href='${path}/members/num/edit'">수정</button>
						<button class="btn btn-secondary ml-3"
							onclick="location.href='${path}/members/num'">탈퇴</button>
					</div>
				</div>
			</div>

			<img class="img-thumbnail" alt="..."
				src="${path}/resources/img/member/origin/profile_male.jpg" />
			<div class="w-100 mb-5"></div>


			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">아이디</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">닉네임</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">성별</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">생년월일</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">전화번호</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">이메일</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">가입일</span>
				</div>
				<input type="text" class="form-control" readonly>
			</div>

		</div>
	</div>
</div>

</html>

<%@include file="/WEB-INF/views/include/footer.jsp"%>