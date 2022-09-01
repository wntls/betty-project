<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- BookDetails Section Begin -->
<section class="anime-details">
	<div class="container-md spad-sm">
		<div class="anime__details__content">
			<div class="row">
				<div class="col-md-4">
					<div class="anime__details__pic set-bg"
						data-setbg="${path}/resources/img/book/origin/${book.code}.jpg">
					</div>
				</div>
				<div class="col-md-8">
					<div class="anime__details__text">
						<div class="anime__details__title">
							<h3>${book.title}</h3>
							<span>${book.auth}</span>
						</div>
						<div class="anime__details__widget">
							<div class="row">
								<div class="col-md-6 col-md-6">
									<ul>
										<li><span>장르 : </span> ${book.genre}</li>
										<li><span>작가 : </span> ${book.auth}</li>
										<li><span>출판일 : </span> <f:formatDate value="${book.pubDate}" pattern="yyyy-MM-dd"/></li>
										<li><span>출판사 : </span> ${book.pub}</li>
									</ul>
								</div>
								<div class="col-md-6 col-md-6">
									<ul>
										<li><span>쪽수 :</span> ${book.page}쪽</li>
										<li><span>ISBN :</span> ${book.code}</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="anime__details__btn float-right">
							<button id="reservBtn" class="btn btn-danger">
								<input id="reserv">
							대여 예약</button>
						</div>
					</div>
				</div>

				<div class="col-md anime__details__content">
					<div class="anime__details__title">
						<h3>도서 소개</h3>
					</div>
					<p>${book.intro}</p>
				</div>
			</div>

		</div>
		<%@include file="/WEB-INF/views/book/fragment/book-detail-comment.jsp"%>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
$.datepicker.setDefaults($.datepicker.regional["ko"]);

$("#reserv").datepicker({
    dateFormat: 'yy-mm-dd' //달력 날짜 형태
    ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
    ,autoSize: false
    ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
    ,changeYear: true //option값 년 선택 가능
    ,changeMonth: true //option값  월 선택 가능                
    ,showAnim: "slideDown"
    ,buttonImage: "${path}/resources/img/assets/datepciekr/ui-icons_444444_256x240.png" // 버튼 이미지
    ,yearRange: 'c-0:c+1'
    ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함 
    ,buttonText: "선택" //버튼 호버 텍스트              
    ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
    ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
    ,minDate: "+1D"
    ,maxDate: "+14D" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
});   

$(function(){
	
	$('#reservBtn').on('click', function(){
		let isbn = '${board.code}';
		let memberId = '${user.id}';
		let date = $('#reserv').val();
		
		let data = { "memberId" : memberId, "isbn" : isbn, "date" : date };
		
		if(date == ''){
			return;
		} else {
			$.ajax({
				type: 'post',
				url: '${path}/rentals/reserve',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(data){
					alert("success");
					console.log(data);
				},
				error: function(request,status,error){
					alert("fail");
					console.log(request);
					console.log(status);
					console.log(error);
				}	
				
			})
		}
		
	})
	
})

</script>