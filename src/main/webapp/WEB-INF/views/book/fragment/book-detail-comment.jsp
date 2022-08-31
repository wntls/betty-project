<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<hr/>
<div class="container-md spad-sm">
	<!-- 댓글 -->
	<div class="anime__details__review">
		<div class="section-title">

			<h5>${pm}후기${list}</h5>

		</div>
		<div id="comments" class="anime__review__item">
			
		</div>		
		<ul id="pagination">
		
		</ul>
	</div>

	<div class="anime__details__form">
		<div class="section-title">
			<h5>후기 작성</h5>
		</div>
		<form id="book-comment" action="${path}/books/123/comment" method="POST">
			<input type="hidden" name="memberId" value="${user.id}">
			<input type="hidden" name="nickname" value="${user.nickname}">
			<input type="hidden" name="bookCode" value="">
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

$(function(){
	testlist(1);
});

function testadd(){

	let comment = { memberId : "id001", nickname : "nick001", bookCode : "123", comment : "가자" };
	
	$.ajax({
		
		type: 'post',
		url: "${path}/books/9772383984000/comment",
		data: comment,
		dataType: 'json',
		success: function(data){
			alert(data.data);
		}
	});

}

function testlist(pageNum){
	$.ajax({
		type : 'post',
		url : "${path}/books/9772383984000/comments",
		data : {
			page : pageNum
		},
		dataType : 'json',
		success : function(result){
			console.log(result.list);
			console.log(result.pm);
			printList(result.list);
			printPage(result.pm);
		}
	});
}

function printList(list){
	var str = "";
	$(list).each(function(){
		let img = this.img;
		let nickname = this.nickname;
		let date = new Date(this.regdate);
		let formatDate = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		let comment = this.comment;
		
		str += "<div class='anime__review__item__pic'>";
		str += "<img src='${path}/resources/img/member/thumbnail/"+img+"' alt=''>";
		str += "</div>";
		str += "<div class='anime__review__item__text'>";
		str += "<h6>";
		str += nickname + " - <span>" + formatDate + "</span>";
		str += "</h6>";
		str += "<p>" + comment + "</p>";
		str += "</div></div>";
		str += "<br>"
	});
	$("#comments").html(str);
}


function printPage(pm) {
	var str = "";
	if (pm.prev) {
		str  += "<li><a href='" + (pm.startPage - 1) + "'> << </a></li>";
	}
	
	for (var i = pm.startPage; i <= pm.endPage; i++) {
		if (pm.cri.page == i) {
			str  += "<li><a href='" + i + "' class='active'>" + i + "</a></li>";
		} else {
			str  += "<li><a href='" + i + "'>" + i + "</a></li>";
		}
	}
	
	if (pm.next) {
		str  += "<li><a href='" + (pm.endPage + 1) + "'> >> </a></li>";
	}
	
	$("#pagination").html(str);
}

$("#pagination").on("click", "li a",function(e){																
	e.preventDefault();						
	var commentPage = $(this).attr("href");
	page = commentPage;
	testlist(page);
});




</script>





