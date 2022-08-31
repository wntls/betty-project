<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<hr/>
<div class="container-md spad-sm">
	<!-- 댓글 -->
	<div class="anime__details__review">
		<div class="section-title">
			<h5>후기</h5>
		</div>
		<div class="anime__review__item">
			<div class="anime__review__item__pic">
				<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
			</div>
			<div class="anime__review__item__text">
				<h6>
					유저 1 - <span>1 Hour ago</span>
				</h6>
				<p>whachikan Just noticed that someone categorized this as
					belonging to the genre "demons" LOL</p>
			</div>
		</div>
		<div class="anime__review__item">
			<div class="anime__review__item__pic">
				<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
			</div>
			<div class="anime__review__item__text">
				<h6>
					유저 2 - <span>5 Hour ago</span>
				</h6>
				<p>Finally it came out ages ago</p>
			</div>
		</div>
		
	</div>

	<div class="anime__details__form">
		<div class="section-title">
			<h5>후기 작성</h5>
		</div>
		<form id="book-comment" action="${path}/books/123/comment" method="POST">
			<input name="memberId" value="${user.id}" hidden>
			<input name="nickname" value="${user.nickname}" hidden>
			<input name="bookCode" value="123" hidden>
			<textarea id="" name="comment" placeholder="Your Comment"></textarea>
			<button type="submit">
				<i class="fa fa-location-arrow"></i> 확인
			</button>
		</form>
		<button id="testBtn" onclick="testadd()" value="댓글 입력"></button>
		<button id="testBtn" onclick="testlist()" value="댓글 리스트"></button>
	</div>

</div>

<script>
/* 
function testadd(){

	let comment = { memberId : "id001", nickname : "nick001", bookCode : "123", comment : "가자" };
	
	$.ajax({
		
		type: 'post',
		url: "${path}/books/123/comment",
		contentType : 'application/json',
		data: JSON.stringify(comment),
		dataType: 'json',
		success: function(data){
			alert(data.data);
		}
	})

} */


function testadd(){

	let comment = { memberId : "id001", nickname : "nick001", bookCode : "123", comment : "가자" };
	
	$.ajax({
		
		type: 'post',
		url: "${path}/books/123/comment",
		data: comment,
		dataType: 'json',
		success: function(data){
			alert(data.data);
		}
	})

}
/* function testlist(){
	
	$.ajax({
		type : 'get',
		url : "${path}/books/123/comments",
		dada : {
			bookCode : '123'
		},
		dataType : 'json',
		success : function(result){
			
		}
	})
} */

</script>





