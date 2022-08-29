<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
	#profileImgDiv {
		position: relative;
		border-raius: 1rem;
		width: 300px;
		height: 300px;
		margin-right: 2rem;
		background-repeat: no-repeat;
		background-size: cover;
		background-position: top center;
		box-sizing: border-box;
	}
</style>

<%@include file="/WEB-INF/views/include/header.jsp"%>


<section class="signup spad">
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="col-md-auto">
				<div class="section-title">
						<h4>회원 정보 수정</h4>
				</div>

				<div class="login__form">
					<div class="row justify-content-center spad-sm">
					<div class="img-thumbnail" id="profileImgDiv" style="background-image: url('${path}/resources/img/member/origin/${user.img}');"></div>
					</div>
					<form id="editForm" action="" method="post" enctype="multipart/form-data">
							
						<div class="input-group mb-3">
						  <div class="custom-file">
						    <input type="file" class="custom-file-input" name="profileImg" id="profileImg" accept="image/*">
						    <label class="custom-file-label" for="profileImg">프로필 이미지를 등록하세요</label>
						  </div>
						</div>
						<div class="input__item">
							<span><i class="bi bi-person-video2"></i></span>
							<input type="text" name="id" id="id" value="${user.id}" readonly/> 
							<div class="result"></div>
						</div>

						<div class="input__item">
							<span class="icon_lock"></span> 
							<input type="password" name="pw" id="pw"/>
							<div class="result"></div>
						</div>

						<div class="input__item">
							<span class="icon_lock"></span> 
							<input type="password" name="repw" id="repw"/>
							<div class="result"></div>
						</div>

						<div class="input__item">
							<span class="icon_profile"></span> 
							<input type="text" name="name" id="name" value="${user.name}"/>
							<div class="result"></div>
						</div>

						<div class="input__item">
							<span class="icon_profile"></span> 
							<input type="text" name="nickname" id="nickname" value="${user.nickname}"/>
							<div class="result"></div>
						</div>

						<div class="input__item">
							<span><i class="bi bi-calendar3"></i></span>
							<input type="text" name="birth" id="birth" 
									value="<f:formatDate pattern="yyyy-MM-dd" value="${user.birth}"/>"/> 
							<div class="result"></div>
						</div>
					
						 <div class="row ml-2 mb-3">
							 <div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="gender" id="male" value="male">
							  <label class="form-check-label" for="male">남성</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="gender" id="female" value="female">
							  <label class="form-check-label" for="female">여성</label>
							</div>
						</div>
						 
						 <script>
						 		console.log(${user.gender});
						 	if(${user.gender} == 'male'){
						 		console.log("male");
						 	} else {
						 		console.log("female");
						 	}
						 </script>
						 
						<div class="input__item mt-3">
							<span><i class="bi bi-house"></i></span>
							<input type="text" name="addr" id="addr"/> 
						</div>
						
						<div class="input__item">
							<span><i class="bi bi-phone"></i></span>
								<input type="text" name="phone" id="phone" value="${user.phone}" readonly/> 
						</div>
						
						<div class="input__item">
							<span class="icon_mail"></span>
							<input type="text" name="email" id="email" value="${user.email}" readonly/> 
						</div>

						<div class="btn-group">
							<button type="submit" class="btn btn-danger mr-2">수정하기</button>
							<button type="button" class="btn btn-secondary">취소</button>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
$(function(){
	
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
	
	$("#editForm").validate({
		onkeyup : function(el){
			$(el).valid();
		},
		rules : {	
			
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
				rangelength : [2,10]
			},
			
			birth :{
				required : true
			},
			
			gender : {
				required : true
			},
			
			addr : {
				required : true
			},  
		 
		},
		messages : {
			
			pw : {
				required : "비밀번호를 작성해 주세요.",
				minlength : "비밀번호는 최소 6자리 이상입니다.",
				maxlength : "비밀번호는 최대 20자리까지 가능합니다."
			},
			repw : {
				required : "비밀번호를 작성해 주세요.",
				minlength : "비밀번호는 최소 6자리 이상입니다.",
				maxlength : "비밀번호는 최대 20자리까지 가능합니다.",
				equalTo : "비밀번호가 일치하지 않습니다."
			},
			
			name : {
				required : "이름을 입력해 주세요.",
				rangelength : "이름은 2~6글자 이내 작성해주세요."
			},
			
			nickname : {
				required : "닉네임을 입력해 주세요.",
				rangelength : "닉네임은 2~10글자 이내 작성해주세요."
			},
			
			birth : {
				required : "생일을 선택해 주세요."
			},
			
			gender : {
				required : "성별을 확인해 주세요."
			},
			
			addr : {
				required : "주소를 입력해 주세요."
			} 
			
		},
		errorClass : "text-danger",
		errorElement : "div",
		errorPlacement : function(error, element){	
			if(element.prop("type") === 'radio'){ 
				element.removeClass("text-danger");
				error.insertAfter(element.parent().parent());
			}else{
				error.insertAfter(element);
			}
		},
		submitHandler : function(form){
				$(form).submit();
		}
	}); 
	
});
</script>



