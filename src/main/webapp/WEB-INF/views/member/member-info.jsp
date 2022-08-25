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
						data-toggle="modal"
						data-target="#withdrawMember" >탈퇴</button>
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
				<input type="text" class="form-control" name="id" readonly>
			</div>
			
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">이름</span>
				</div>
				<input type="text" class="form-control" name="name" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">닉네임</span>
				</div>
				<input type="text" class="form-control" name="nickname" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">성별</span>
				</div>
				<input type="text" class="form-control" name="gender" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">생년월일</span>
				</div>
				<input type="text" class="form-control" name="birth" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">주소</span>
				</div>
				<input type="text" class="form-control" name="addr" readonly>
			</div>
			
				<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">전화번호</span>
				</div>
				<input type="text" class="form-control" name="phone" readonly>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">이메일</span>
				</div>
				<input type="text" class="form-control" name="email" readonly>
			</div>

		</div>
	</div>
</div>

</html>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<div class="modal fade" id="withdrawMember" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">회원 탈퇴 확인란</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
        <p id="modal-body" style="color:black">회원 아이디를 입력하세요</p>
        <input class="form-control" name="id"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="withdrawMemberBtn">탈퇴 요청</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>

<script>
	$('#withdrawMemberBtn').click(function(){
		
		$.ajax({
			
			url: '${path}/members/num',
			type: 'delete',
			dataType: 'application/json',
			success: function(){
				location.href='${path}/';
			},
			fail: function(){
				
			}
			
			
		})
		
	});
</script>








