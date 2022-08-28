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
							<input type="text" class="form-control" name="addr_detail" id="addr_detail" placeholder="상세주소를 입력해주세요"/>
							
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

<script>
$(function(){
	
	$('#sendSMS').removeAttr('hidden');
	
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
	
	function showMessage(elP,messageP,isCheck){
		var html = "<sapn style='margin-left:5px;font-size:12px;";
		html += isCheck ? "color:green;" : "color:red;"
		html += "'>"; // 여기까지가 style 임
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
	
	// 이메일 인증확인
	var boolEmail = false;
	var regexEmail =/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;  // 이메일
	$("#email").on("input", function(){
		var tempVal = $("#email").val();
		var elP = $(this).parent().find(".result");
		var message = "이메일을 제대로 확인 주세요";
		boolEmail = checkRegex(elP, tempVal, regexEmail, message, null);
		
		if(boolEmail){
			$("#sendEmail").attr("disabled", false);
		}
	});
	
	var boolEmailCode = false;
	$("#sendEmail").click(function(){
		if(!boolEmail){
			alert("이메일을 확인해 주세요.");
			$("#email").focus();
		}else{
			$("#sendEmail").attr("disabled", true);
			
			$.ajax({
				type : "GET",
				url : "${path}/checkEmail",
				data : {
					email : $("#email").val()
				},
				dataType : "json",
				success : function(data){
						if(data){
							code = data;
							console.log(code);
							alert("메일 발송 완료 \n메일을 확인 해주세요.");
							$("#emailCodeWrap").show();
						}else{
							alert("메일 발송 실패 \n관리자에게 문의해주세요.");
						}
				}
			}); // ajax end
		} // if end
	});
	
	$(".emailAcceptCode").click(function(){
		var userCode = $(".user-email-code").val();
		console.log("code : " + code);
		console.log("userCode : " + userCode);
		if(code != ""
				&& userCode.length != 0
				&& code == userCode){
			alert("이메일 인증 완료");
			boolEmailCode = true;
			$("#emailCodeWrap").hide();
			$(".user-email-code").val("");
		}else{
			alert("발송된 이메일 인증코드를 다시 확인해 주세요.");
			$(".user-email-code").focus();
		}
	});
	
	$.validator.addMethod("regex",function(value,element,regexpr){
		return regexpr.test(value);
	});
	
	var regexBirth = /^[0-9]{4}[0-9]{2}[0-9]{2}$/;	
	var regexID = /^[0-9a-zA-Z]{3,10}$/;
	
	
	// 유효성 검사(폰  / 이메일은 위에서 인증코드랑 같이해서 제외) 
	// - 주소는 api쓰면 따로 안해도 되서 일단 제외시킴
	$("#signUpForm").validate({
		onkeyup : function(el){
			$(el).valid();
		},
		rules : {	
			id : { 
				required : true,
				remote : {
					type : "GET",
					url : "${path}/user/uidCheck"
				},
				regex : regexID
			}, 
			
			pw : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			repw : {
				required : true,
				minlength : 6,
				maxlength : 20,
				equalTo : "#pw"
			},
			
			name : {
				required : true,
				rangelength : [2,6]
			},
			
			nickname : {
				required : true,
				remote :{
					type : "GET",
					url : "${path}/user/nicknameCheck"
				},
				rangelength : [2,10]
			},
			
			birth :{
				required : true,
				regex : regexBirth
			},
			
			gender : {
				required : true
			},
			
			addr : {
				required : true
			},
			
			phone : {
				required : true
			},  
			
			email : {
				required : true
			}  
		 
		},
		messages : {
			id : {
				required : "아이디를 작성 해주세요.",
				remote : "이미 존재하는 아이디입니다.",
				regex : "특수 문자 제외하고 영어와 숫자로 3~10글자 이내로 작성해주세요."
			},
			
			pw : {
				required : "비밀번호를 작성 해 주세요.",
				minlength : "비밀번호는 최소 6자리 이상입니다.",
				maxlength : "비밀번호는 최대 20자리까지 가능합니다."
			},
			repw : {
				required : "비밀번호를 작성 해 주세요.",
				minlength : "비밀번호는 최소 6자리 이상입니다.",
				maxlength : "비밀번호는 최대 20자리까지 가능합니다.",
				equalTo : "비밀번호가 일치하지 않습니다."
			},
			
			name : {
				required : "이름을 입력 해 주세요.",
				rangelength : "이름은 2~6글자 이내 작성해주세요."
			},
			
			nickname : {
				required : "닉네임을 입력 해 주세요.",
				remote : "이미 존재하는 닉네임 입니다.",
				rangelength : "닉네임은 2~10글자 이내 작성해주세요."
			},
			
			birth : {
				required : "생일을 입력 해 주세요.",
				regex : "19930516형식으로 입력해주세요"
			},
			
			gender : {
				required : "성별을 확인 해 주세요."
			},
			
			addr : {
				required : "주소를 입력 해 주세요."
			},
			
			phone : {
				required : "전화번호를 입력 해 주세요."
			},
			
			email : {
				required : "이메일을 입력 해 주세요."
			} 
			
		},
		errorClass : "text-danger",
		// error때 어떤 태그로 보여줄껀지 지정
		errorElement : "div",
		// error때 어디에다가 배치 시킬껀지 지정
		errorPlacement : function(error, element){	
			if(element.prop("type") === 'radio'){ 
				element.removeClass("text-danger");
				error.insertAfter(element.parent(),parent());
			}else{
				error.insertAfter(element);
			}
		},
		//debug : true,	
		submitHandler : function(form){
			// submit 하기 전에 전처리 공간
			if(!boolSMS){
				alert("핸드폰 인증코드 확인 해주세요.");
			}else if(!boolEmailCode){
				alert("이메일 인증코드 확인 해주세요.");
			}else{
				$(form).submit();
			}
		}
	}); 
	
});
</script>
