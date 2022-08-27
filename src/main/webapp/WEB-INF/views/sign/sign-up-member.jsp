<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section class="signup spad">
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="col-md-auto">
				<div class="login__form">
					<h3>회원가입</h3>

					<form id="signUpForm" action="" method="post">
						<input type="text" name="rights" value="0" hidden/>
						아이디
						<div class="input__item">
							<span><i class="bi bi-person-circle"></i></span>
							<input type="text" name="id" id="id" placeholder="아이디를 입력 하세요" /> 
							<div class="result"></div>
						</div>
						비밀번호
						<div class="input__item">
							<span class="icon_lock"></span> 
							<input type="password" name="pw" id="pw" placeholder="비밀번호 입력하세요" />
							<div class="result"></div>
						</div>
						비밀번호 확인
						<div class="input__item">
							<span class="icon_lock"></span> 
							<input type="password" name="repw" id="repw" placeholder="비밀번호 재입력하세요" />
							<div class="result"></div>
						</div>
						이름
						<div class="input__item">
							<span class="icon_profile"></span> 
							<input type="text" name="name" id="name" placeholder="이름을 입력하세요" />
							<div class="result"></div>
						</div>
						닉네임
						<div class="input__item">
							<span><i class="bi bi-person-video2"></i></span> 
							<input type="text" name="nickname" id="nickname" placeholder="닉네임을 입력하세요" />
							<div class="result"></div>
						</div>
						생년월일
						<div class="input__item">
							<span><i class="bi bi-calendar3"></i></span>
							<input type="text" name="birth" id="birth" placeholder="19930516" /> 
							<div class="result"></div>
						</div>
						성별
						<div class="btn-group btn-group-toggle w-100 mb-3"  data-toggle="buttons">
							<label class="btn btn-primary text-white">
								<input type="radio" name="gender" id="male" value="male"> 남성
							</label>
							<label class="btn btn-primary ml-2 text-white">
								<input type="radio" name="gender" id="female" value="female"> 여성
							</label>
						<div class="result"></div>
						</div>
						
						주소
						<!-- <div class="input__item"> -->
							<!-- <span><i class="bi bi-house"></i></span> -->
							<div class="row addr-box">
								<div class="col-md-6">
									<input type="text" class="form-control" name="post" id="post"/>
								</div>
								<div class="col-md-4">
									<input type="button" class="form-control btn btn-light" onclick="sample6_execDaumPostcode();" value="주소찾기"/>
								</div>
							</div>
							<br/>
							<input type="text" class="form-control" name="addr" id="addr"/>
							<br/>
							<input type="text" class="form-control" name="addr_detail" id="addr_detail"/>
							
							<!-- <input type="text" name="addr" id="addr" placeholder="사랑시 고백구 행복동" /> -->
							<div class="result"></div> 
						<!-- </div> -->
						
						전화번호
						<div class="input__item">
							<span><i class="bi bi-phone"></i></span>
							<input type="text" name="phone" id="phone" placeholder="01012345678" /> 
							<input type="button" class="btn btn-danger" value="인증코드 전송" id="sendSMS" disabled/>
							<div class="result"></div>
						</div>
						
						<div class="input-group flex-nowrap justify-content-center mb-4" style="display: none" id="codeWrap">
							<input type="text" class="phone-code" />
							<input type="button" class="btn btn-secondary acceptCode" value="인증" />
						</div> 
						
						이메일
						<div class="input__item">
							<span class="icon_mail"></span>
							<input type="text" name="email" id="email" placeholder="이메일을 입력하세요" /> 
							<input type="button" class="btn btn-danger" value="이메일 인증" id="sendEmail" disabled/>
							<div class="result"></div>
						</div>
						
						<div class="input-group flex-nowrap justify-content-center mb-4" style="display: none" id="emailCodeWrap">
							<input type="text" class="user-email-code" />
							<input type="button" class="emailAcceptCode" value="인증" />
						</div>

						<div class="btn-group justify-content-center">
							<button type="submit" class="site-btn">가입 하기</button>
							<button type="button" class="cancel-btn">취소</button>
						</div>
					</form>
						<div id="test"></div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
