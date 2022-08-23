<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<br />
			<div class="section-title">
					<h4>회원 정보 수정</h4>
			</div>
				<img class="img-thumbnail" alt="..."
					src="${path}/resources/img/member/profile_male.png" />
			<div class="w-100 mb-5"></div>


				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >아이디</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >닉네임</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >성별</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >생년월일</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >전화번호</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >이메일</span>
					</div>
					<input type="text" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >가입일</span>
					</div>
					<input type="text" class="form-control">
				</div>

		</div>
	</div>
</div>
</div>
</div>

</html>

<%@include file="/WEB-INF/views/include/footer.jsp"%>