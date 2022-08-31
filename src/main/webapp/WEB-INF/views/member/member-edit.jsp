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
							<input type="text" id="datepicker" />
					</form>
					
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
	function test(ev){
		console.log(ev.value);
		
	}

$(function(){
	
	
	$("#birth").datepicker({
        dateFormat: 'yy-mm-dd' //달력 날짜 형태
        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
        ,autoSize: false
        ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
        ,changeYear: true //option값 년 선택 가능
        ,changeMonth: true //option값  월 선택 가능                
        ,showAnim: "slideDown"
        	,buttonImage: "${path}/resources/img/assets/datepciekr/ui-icons_444444_256x240.png" // 버튼 이미지
        		 ,yearRange: 'c-100:c+0'
        ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함 
        ,buttonText: "선택" //버튼 호버 텍스트              
        ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
        ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
        ,maxDate: "0" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
    });                    
    
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

 
 <script>
 		console.log('${user.gender}');
 	if('${user.gender}' == 'man'){
 		console.log("male");
 		$('#male').prop('checked','true');
 	} else {
 		console.log("female");
 		$('#female').prop('checked','true');
 	}
 </script>


