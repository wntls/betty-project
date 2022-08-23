<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<!-- 섹션 -->
				<!-- 타이틀 부분 -->
				<div class="product__page__title">
					<div class="row">
						<div class="col-md-8 col-md-8 col-md-6 title__align__center">
							<div class="section-title">
								<h4>도서 현황</h4>
							</div>
						</div>
						<div class="col-md-4 col-md-4 col-md-6 anime__details__btn">
							<button class="follow-btn float-right">&#10009; 도서 등록</button>
						</div>
					</div>
				</div>
				<form>
					<div class="row justify-content-center spad">
						<table class="table-detail-search text-center">
							<!-- 1행 -->
							<tr>
								<th>장르 지정</th>
								<td class="text-align-left " colspan="3">
									<div class="input-group mb-3">
										<select id="genreSel" onchange="genreVal()" >
											<option selected>장르 선택</option>
											<option value="100">철학(100)</option>
											<option value="200">종교(200)</option>
											<option value="300">사회(300)</option>
											<option value="400">과학(400)</option>
											<option value="500">공학(500)</option>
											<option value="600">예술(600)</option>
											<option value="700">외국어(700)</option>
											<option value="800">소설(800)</option>
											<option value="900">역사(900)</option>
										</select>
									</div>
								</td>
							</tr>

							<!-- 3행 -->
							<tr>
								<th>도서 발행일 별</th>
								<td>
									<div class="input-group text-secondary">
										<input type="date" id="dateSel" name="pubDate" />
										<div class="input-group-append">
											<!-- <label class="input-group-text" for="dateSel">입고일 선택</label> -->
											<select class="keywordSelect"
												onchange="pubDateSort(this.value);">
												<option value="before">-이전</option>
												<option value="after">-이후</option>
											</select>
										</div>
									</div>
								</td>
							</tr>
							<!-- 4행 -->

							<tr>
								<th>검색,{searchText}</th>
								<!--  value : 선택된 밸류값 -->
								<td><select class="keywordSelect"
									onchange="searchText(this.value);">
										<option value="">키워드 선택</option>
										<option value="title">도서명</option>
										<option value="auth">작가</option>
										<option value="pub">출판사</option>
								</select> <input class="float-left" /></td>
							</tr>
						</table>
						<input class="btn btn-primary" type="submit" value="검색" />
					</div>
				</form>
				

				<!-- 도서재고 수정 -->
				<div class="modal fade" id="bookCount" data-backdrop="static"
					tabindex="-1" role="dialog"
					 aria-hidden="true">
					<div
						class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
						role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">보유 권수 수정</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="false">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<!-- 입력태그 하나 -->
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<div class="input-group-text">현재 도서 권수 -</div>
									</div>
									<input type="text" class="form-control"
									 	 value="{num이나 bookNum}"
										readonly="readonly">
								</div>
								<br />
								<!-- 입력태그 하나 -->
								<!-- 입력태그 하나 -->
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<div class="input-group-text">수정된 권수</div>
									</div>
									<input type="number" id="{도서재고 수정 입력받을값}">
								</div>
								<br />
								<!-- 입력태그 하나 -->

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">{transferSubmit}</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">{cancel}</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 도서재고 수정 -->


				
				
				
				<!-- table -->
				<h6 id="info"> * 책 표지나 테이블 클릭시 해당 도서의 수정페이지로 이동합니다</h6>
				<table id="blackTable"
					class="table-data-list table-striped table-dark text-center">
					<!-- 1블럭 -->
					<!-- 1 -->
					<tr onclick="location.href='${path}/staff/books/num/edit'">
						<td>번호</td>
						<td>책 표지</td>
						<td style="min-width: 130px">도서명</td>
						<td>ISBN</td>
						<td>작가</td>
						<td>출판사</td>
					</tr>

					<!-- 2 -->
					<tr onclick="location.href='${path}/staff/books/num/edit'">
						<td rowspan="3">1</td>
						<td class="책 이미지" style="max-width: 135px" rowspan="3">
						<img src="${path}/resources/img/book/origin/9788935213344.jpg" /></td>
						<td class="tempTitle">{제목넘기기}</td>
						<td>코드넘기자</td>
						<td>{auth}</td>
						<td>{pub}</td>
					</tr>
					<tr id="tr3">
						<td style="min-width: 130px">출판일</td>
						<td style="min-width: 130px">장르</td>
						<td style="min-width: 130px">보유 권수</td>
						<td style="min-width: 130px">기타</td>
					</tr>
					<tr id="tr4">
						<td>{pub_date}</td>
						<td>{genre}</td>
						<td><input type="button" class="btn btnText" onclick="throwData(this)"
							data-toggle="modal" data-target="#bookCount"
							value="보유권수 수정" id="bookAdd" name="bookAdd{isbn등}" /></td>
						<td><input type="button" class="btn btnText"
							data-toggle="modal" data-target="#exampleModalCenter"
							value="도서 삭제" id="bookAdd" name="bookAdd{isbn등}" /></td>
					</tr>
					
					
					<!-- 1블럭 -->
					<!-- 1 -->
					<tr class="text-center">
						<td>번호</td>
						<td>책 표지</td>
						<td style="width: 130px">도서명</td>
						<td>ISBN</td>
						<td>작가</td>
						<td>출판사</td>
					</tr>
					<!-- 2 -->
					<tr>
						<td rowspan="3">1</td>
						<td style="max-width: 135px" rowspan="3" class="책 이미지"><img
							src="${path}/resources/img/book/origin/9788935213344.jpg" /></td>
						<td>{title}</td>
						<td>{code}</td>
						<td>{auth}</td>
						<td>{pub}</td>
					</tr>
					<!-- 3 -->
					<tr>
						<td style="width: 130px">출판일</td>
						<td style="width: 130px">장르</td>
						<td style="width: 130px">보유 권수</td>
						<td style="width: 130px">기타</td>
					</tr>
					<!-- 4 -->
					<tr>
						<td>{pub_date}</td>
						<td>{genre}</td>
						<td>{보유권수}</td>
						<td>{기타 넣을거}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>

		function genreVal(){
			var val = $('#genreSel').val();
			console.log(val);
		}
		
		function throwData(ev){
			
			console.log(ev.closest("#tr2"));
			let tr = ev.parentNode.parentNode.previousSibling.previousSibling.previousSibling.previousSibling;
			let title = tr.children[2].innerHTML;
			let code = tr.children[3].innerHTML;
			code = { "code" : code };			
			console.log(code);
			console.log($('.modal-title').text());
			$('.modal-title').text(title);
			$('.bookName').val(code);
			
		
			
			$.ajax({
				url: '${path}/staff/books/plz',
				type: 'put',
				data: code,
				contentType: "application/json",
				dataType: 'json',
				success: function(result){
					$('.modal-title').text(result.title);
					$('.bookName').val(result.content);
				}
			})
		}

</script>

