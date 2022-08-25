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
						아이디
						<div class="input__item">
							<input type="text" name="id" placeholder="아이디"> <span
								class="icon_profile"></span>
						</div>
						비밀번호
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
						  <button class="form-control" id="idFindModalPhoneCheck">인증하기</button>
						</div>
						
						<div class="input-group mt-3" style="display: flex" id="idCodeWrap">
							<div class="input-group-prepend">
							    <span class="input-group-text">인증번호</span>
							  </div>
							<input type="text" class="form-control phone-code" />
							<input type="button" class="form-control acceptCode" value="인증" />
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
							<input type="text" class="form-control" name="id">
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
						<!-- 입력태그 하나 -->
						<div class="input-group mt-3" style="display: flex" id="pwCodeWrap">
							<div class="input-group-prepend">
							    <span class="input-group-text">인증번호</span>
							  </div>
							<input type="text" class="form-control phone-code" />
							<input type="button" class="form-control acceptCode" value="인증" />
						</div> 
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
						data-toggle="modal"
						data-target="#updatePwModal"
						data-dismiss="modal"
						>확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		<!-- passFind modal/ -->
		
		
		<!-- updatePwModal -->
		<div class="modal fade" id="updatePwModal" data-backdrop="static"
			tabindex="-1" role="dialog"	aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				
				<div class="modal-content">
				
					<div class="modal-header">
						<h5 class="modal-title">비밀번호 변경</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<form class="form-group" action="${path}/members/edit" method="post">
						<div class="modal-body">
							<!-- 입력태그 하나 -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">아이디</div>
								</div>
								<input type="text" class="form-control" name="id" id="id">
							</div>
							
							<!-- 입력태그 하나 -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">비밀번호</div>
								</div>
								<input type="text" class="form-control" name="pw" id="pw">
							</div>
							
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">비밀번호 확인</div>
								</div>
								<input type="text" class="form-control" id="repw">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary">확인</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- updatePwModal/ -->



	</div>
</section>
<!-- Login Section End -->

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
$(function(){
	
	$('#sendSMS').removeAttr('hidden');
	
	//정규표현식 데이터 검증
	function checkRegex(elP, valP, regexP, messageP, ajaxP){
		// 정규 표현식이 일치 하지 않을 때
		if(regexP.test(valP) === false){
			showMessage(elP,messageP,false);
			return false;
		// 정규표현식 일치하고 ajax가 존재하지 않을 때
		}else if(regexP.test(valP) !== false
					&& ajaxP === null){
			showMessage(elP, "", true);
			return true;
		}else{
			if(ajaxP !== null){
				ajaxP(elP);
			}
		}
	}
	
	//메시지 출력 checkRegex() 내부에서 쓰임
	function showMessage(elP,messageP,isCheck){
		var html = "<sapn style='margin-left:5px;font-size:12px;";
		html += isCheck ? "color:green;" : "color:red;"
		html += "'>";
		html += messageP;
		html += "</span>";
		$(elP).html(html);		
	}
	
	// 전화번호 확인 여부
	var boolPhone = false;
	var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;					
	$("#phone").on("input", function(){
		var tempVal = $("#phone").val();
		var elP = $(this).parent().find(".result");
		var message = "-를 제외한 숫자만 입력해주세요.";
		boolPhone = checkRegex(elP, tempVal, regexMobile, message, null);
		
		if(boolPhone){
			$("#sendSMS").attr("disabled", false);
		}
	});
	
	// 인증 코드 저장
	var code = "";
	var boolSMS = false;
	$("#sendSMS").click(function(){
		if(!boolPhone){
			alert("전화번호를 먼저 확인해 주세요.");
			$("#phone").focus();
		}else{
			$("#sendSMS").attr("disabled", true);
			$("#codeWrap").show();
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "${path}/sendSMS",
				data :{
					phone : $("#phone").val()
				},
				success : function(data){
					if(data['result'] == 2000){ 
						code = data['code'];
					} 
					console.log(data);
					console.log(code);
				} // success end
			});	// ajax end
		}
	});
	
	// 인증 번호 검증과 ajax 처리를 담당해야한다.
	$(".acceptCode").click(function(){
		var userCode = $(".phone-code").val();
		if(code != "" 
				&& userCode.length != 0 
				&& code == userCode){
			alert("인증 완료");
			boolSMS = true;
			$("#codeWrap").hide();
			$(".phone-code").val("");
		}else{
			alert("발송된 인증코드를 다시 확인해 주세요.");
			$(".phone-code").focus();
		}
	});
	
	// 인증을 눌렀을 때 인증번호가 일치한다면
	// 현재 modal을 종료하고
	// 비밀번호 변경 modal을 show
	// 이때 적혀있던 id 값을 가져간다.
	// 여기에 검증 로직이 새로 나타나야한다.
	
	function onUpdatePwModal(){
		
	}
	
	// 유효성 검사(폰  / 이메일은 위에서 인증코드랑 같이해서 제외) 
	// - 주소는 api쓰면 따로 안해도 되서 일단 제외시킴
	$("#joinForm").validate({
		onkeyup : function(el){
			$(el).valid();
		},
		rules : {	
			id : { 
				required : true,
				remote : {
					type : "GET",
					url : "${path}/user/uidCheck"
				}
			}
			
		},
		messages : {
			id : {
				required : "아이디를 작성해주세요.",
				remote : "이미 존재하는 아이디입니다."
			}
			
		},
		errorClass : "text-danger",
		// error때 어떤 태그로 보여줄껀지 지정
		errorElement : "div",
		// error때 어디에다가 배치 시킬껀지 지정
		errorPlacement : function(error, element){	
				error.insertAfter(element);
		},
		//debug : true,	
		submitHandler : function(form){
			// submit 하기 전에 전처리 공간
			if(!boolSMS){
				alert("핸드폰 인증코드 확인 해주세요.");
			}else{
				$(form).submit();
			}
		}
	}); 
	
});
</script>
