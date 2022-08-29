<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="section-title">
				<div class="row justify-content-between">
					<div class="col-auto">
						<h4>회원 정보 수정</h4>
					</div>
					<div class="col-auto">
						<button class="btn btn-danger"
							onclick="location.href='${path}/staff/num/edit'">확인</button>
						<button class="btn btn-secondary"
							onclick="location.href='${path}/staff/num'">취소</button>
					</div>
				</div>
			</div>

			<form id="staffModify" method="post" action="">
				<input type="hidden" name="id" value="" />
				
				<img class="img-thumbnail" alt="..."
					src="${path}/resources/img/member/origin/profile_male.jpg" />
				<div class="w-100 mb-5"></div>
	
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >아이디</span>
					</div>
					<input type="text" class="form-control" readonly />
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >성별</span>
					</div>
					<input type="text" class="form-control" readonly />
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >닉네임</span>
					</div>
					<input type="text" name="nickname" id="nickname" value=""  class="form-control" />
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >주소</span>
					</div>
				
					<div class="row addr-box w-75">
						<div class="col-md-6">
							<input type="text" class="form-control" name="post" id="post"/>
						</div>
						<div class="col-md-4">
							<input type="button" class="form-control btn btn-light" onclick="sample6_execDaumPostcode();" value="주소변경"/>
						</div>
					</div>
				</div>
				<div class="input-group mt-3">
					<input type="text" class="form-control" name="addr" id="addr"/>
					<input type="text" class="form-control" name="addr_detail" id="addr_detail" placeholder="상세주소를 입력해 주세요"/>
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >생년월일</span>
					</div>
					<input type="text" class="form-control" readonly />
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >전화번호</span>
					</div>
					<input type="text" name="phone" id="phone" value="" class="form-control" />
				</div>
				
				<div class="input-group mt-3">
					<div class="input-group-prepend">
						<span class="input-group-text" >이메일</span>
					</div>
					<input type="text" class="form-control" readonly />
				</div>
			</form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
$(function(){
	 // 추가할 메소드 이름 | 사용자가 입력한 값 | 유효성검사 체크 되면 보여지는 친구 | rule에서 검증된 값
	$.validator.addMethod("regex",function(value,element,regexpr){
		return regexpr.test(value);
	});
	
	/* 수정 가능한 목록
	 - 닉네임 | 폰 | 주소
	  -> 주소는 없길래 일단 없는대로 냅두긴함
	 - 아이디 | 성별 | 생일 | 이메일은 바뀌면 안됨
	 
	 * 변경사항들이 필수는 아님
	  -> 현재 내가 사용 하고 있는 닉네임을 계속 사용 할 수도 바꿀 수도 있지만,
	  기존 db에 등록된 닉네임은 사용 못하게 해야됨.
	  => if(로그인한 회원.회원번호 == 현재 수정하고자 하는 회원번호  
	  		 && 로그인한 회원.닉네임 == 변경하고자 하는 닉네임){
		  	DB에 등록되어 있는 닉네임(원래 회원의 닉네임)을 계속 쓸 수 있게 함
	  	}else{
	  		이미 등록되어 있는 닉네임이라고 알려주고
	  		해당 닉네임 변경 못하게 해줘야됨
	  	}
	  	
	  닉네임 뿐만 아니라 폰 , 주소도 그렇게 해줘야됨.
	 근데 이걸 어케 하냐???
	 그것보다 내가 원하는게 저 if문이 맞냐??
	*/
	 
	var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;
	var regexNick = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,10}$/;
	
	$("#staffModify").validate({
		onkeyup: function(element) {
            this.element(element);
		},
		rules : {
			nickname : {
				remote : {
					type : "GET",
					url : "${path}/staff/nicknameCheck"
				},
				regex : regexNick
			},
			
			phone : {
				regex : regexMobile
			}
		},
		messages : {
			nickname : {
				remote : "이미 등록된 닉네임 입니다.",
				regex : "2~10자 사이의 단어를 입력 해 주세요"
			},
			
			phone : {
				regex : "올바른 형식의 번호가 아닙니다."
			}
		},
		errorClass : "text-danger",
		errorElement : "div",
		errorPlacement : function(error, el){
			error.insertAfter(el.parent());
		}
		
		
	});
	
	$.validator.setDefaults({
		submitHandler : function(){
			$("#staffModify").submit();
		}
	});
});
</script>