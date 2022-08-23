<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-md">
	<div class="row justify-content-center">
		<div class="col-md-10">
			<br />
			<div class="section-title">
				<br />
				<h4>직원별 회원 정보</h4>
				<br />
			</div>
			<div class="row">
				<div class="col-md-11 col-md-4" id="imgs">
					<img class="img-thumbnail" alt="..."
						src="${path}/resources/img/member/profile_male.png" />
					<button type="button" class="btn btn-secondary btn-md btn-block">프로필
						사진 변경</button>
				</div>
				<div class="col-md-11 col-md-7">
					<div class="product__page__title">
					<div class="row">
						<div class="col-md-8 col-md-8 col-md-6 title__align__center">
							<div class="section-title">
								<h4>회원 정보</h4>
							</div>
						</div>
						<div class="col-md-4 col-md-4 col-md-6 anime__details__btn">
							<button class="follow-btn float-right">+ 회원 등록</button>
						</div>
					</div>
				</div>

					<div class="staffInfoList">
						<ul class="list-group list-group-horizontal">
							<li class="list-group-item">직원 이름</li>
							<li class="list-group-item">박주신</li>
						</ul>
						<br />
						<ul class="list-group list-group-horizontal">
							<li class="list-group-item">직원 번호</li>
							<li class="list-group-item">010-1234-1234</li>
						</ul>
						<br />
						<ul class="list-group list-group-horizontal">
							<li class="list-group-item">직원 이름</li>
							<li class="list-group-item">박주신</li>
						</ul>
						<br />
						<ul class="list-group list-group-horizontal">
							<li class="list-group-item">직원 이름</li>
							<li class="list-group-item">박주신</li>
						</ul>
						<br />
						<ul class="list-group list-group-horizontal">
							<li class="list-group-item">직원 이름</li>
							<li class="list-group-item">박주신</li>
						</ul>
						<br />
					</div>
				</div>
				<div class="col-md-10">
					<div class="section-title">
						<br /> <br />
						<h4>뭐시깽이 : ㅁㄴㅇㄹ</h4>
						<br /> <br />
						<h4>뭐시깽이 : ㅁㄴㅇㄹ</h4>
						<br /> <br />
						<h4>뭐시깽이 : ㅁㄴㅇㄹ</h4>
						<br /> <br />
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

</html>

<%@include file="/WEB-INF/views/include/footer.jsp"%>