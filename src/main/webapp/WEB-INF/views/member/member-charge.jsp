<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="section-title">
				<div class="row justify-content-between">
					<div class="col-auto">
						<h4>포인트 충전 화면</h4>
					</div>
					<div class="col-auto">
						<button class="btn btn-danger"
							onclick="location.href='${path}/members/num/edit'">확인</button>
						<button class="btn btn-secondary"
							onclick="location.href='${path}/members/num'">취소</button>
					</div>
				</div>
			</div>

			<img class="img-thumbnail" alt="..."
				src="${path}/resources/img/member/profile_male.png" />
			<div class="w-100 mb-5"></div>

			<div>
				<div class="membership_title">
					<h2>멤버십 가입</h2>
				</div>
				
				<div class="card-deck">
					<!-- 브론즈 -->
					<div class="membership-box">
						<i class="bi bi-hexagon"></i>
						<span class="membership-bronze">bronze</span>
						<h3 class="membership-class-title">무료</h3>
						<!-- <div class="row align-content-between"> -->
							<ul class="ul">
								<li class="mebership-li">
									<i class="bi bi-check-circle">
										<span>7일 동안 최대 1권 대여 가능</span>
									</i>
								</li>
								<li class="mebership-li">
									<i class="bi bi-check-circle">
										<span>대여 비용 1,000원</span>
									</i>
								</li>
							</ul>
							<button class="btn btn-danger" 
								onclick="location.href='#'">브론즈 등급 가입</button>
						<!-- </div>  -->
					</div>
					
					<!-- 실버 -->
					<div class="membership-box">
						<i class="bi bi-gift-fill"></i>
						<span class="membership-silver">silver</span>
						<h3 class="membership-class-title">월 50,000원</h3>
						
						<ul class="ul">
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>스터디룸 하루에 최대 4시간 이용 가능</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>14일 동안 최대 2권 대여 가능</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>대여 비용 500원</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>연체시 10% 할인</span>
								</i>
							</li>
						</ul>
						<button class="btn btn-danger" 
							onclick="location.href='#'">브론즈 등급 가입</button>
					</div>
					
					<!-- vip -->
					<div class="membership-box">
						<i class="bi bi-gem"></i>
						<span class="membership-vip">vip</span>
						<h3 class="membership-class-title">월 150,000원</h3>
						
						<ul class="ul">
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>스터디룸 자유롭게 이용 가능</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>30일 동안 최대 3권 대여 가능</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>대여 비용 없음</span>
								</i>
							</li>
							<li class="mebership-li">
								<i class="bi bi-check-circle">
									<span>연체시 20% 할인</span>
								</i>
							</li>
						</ul>
						<button class="btn btn-danger" 
							onclick="location.href='#'">브론즈 등급 가입</button>
					</div>
					
				</div><!-- .card-deck end -->
				
			</div>
		</div>
	</div>
</div>

</html>

<%@include file="/WEB-INF/views/include/footer.jsp"%>