<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="product__page__title">
					<div class="row justify-content-between">
						<div class="col-auto">
							<div class="section-title">
								<h4>도서 현황</h4>
							</div>
						</div>
						<div class="col-auto">
							<button class="btn btn-danger" onclick="location.href='${path}/staff/books/new'">&#10009; 도서 등록</button>
						</div>
					</div>
				</div>
				
				
				
				<form>
					<table class="table table-borderless table-dark mb-5">
						<tbody>
							<!-- 1행 -->
							<tr>
								<th scope="row">장르지정</th>
								<td>
									<select>
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
								</td>
								<td></td>
							</tr>
							<!-- 2행 -->
							<tr>
								<th scope="row">도서 발행일 별</th>
								<td colspan="2">
									<div class="input-group text-secondary">
										<input type="date" id="dateSel" name="pubDate" style="height: 37px"/>
										<div class="input-group-append">
											<select>
												<option value="before">-이전</option>
												<option value="after">-이후</option>
											</select>
										</div>
									</div>
								</td>
							</tr>
							<!-- 3행 -->
							<tr>
								<th scope="row">검색</th>
								<td>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<select>
												<option value="">키워드 선택</option>
												<option value="title">도서명</option>
												<option value="auth">작가</option>
												<option value="pub">출판사</option>
											</select>
										</div>
										<input type="text" class="form-control" style="max-height: 36.5px">
								</td>
								<td></td>
								<td><input class="btn btn-danger" type="submit" value="검색" /></td>
							</tr>
						</tbody>
					</table>
				</form>
				

				
				
				
				<!-- table -->
				<h6 id="info"> * 책 표지나 테이블 클릭시 해당 도서의 수정페이지로 이동합니다</h6>
				<table id="blackTable"
					class="table-data-list table-striped table-dark text-center">
					<!-- 1블럭 -->
					<!-- 1 -->
					<thead>
					<tr onclick="location.href='${path}/staff/books/num/edit'">
						<td>번호</td>
						<td>책 표지</td>
						<td style="min-width: 130px">도서명</td>
						<td>ISBN</td>
						<td>작가</td>
						<td>출판사</td>
					</tr>
					</thead>
					<tbody>
					<!-- 2 -->
					<tr onclick="location.href='${path}/staff/books/num/edit'">
						<td rowspan="3">1</td>
						<td class="책 이미지" style="max-width: 135px" rowspan="3">
						<img src="${path}/resources/img/book/thumbnail/9772383984000.jpg" /></td>
						<td class="tempTitle" id="">{제목넘기기}</td>
						<td id="codetd">코드넘기자1</td>
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
						<td><input type="button" class="btn btn-danger" onclick="throwData(this)"
							data-toggle="modal" data-target="#bookCount"
							value="재고 수정" id="bookAdd" name="bookAdd{isbn등}" /></td>
							
						<td><input type="button" class="btn btn-danger"
							data-toggle="modal" data-target="#exampleModalCenter"
							value="도서 폐기" id="bookAdd" name="bookAdd{isbn등}" /></td>
					</tr>
					</tbody>
					
					<tbody>
					<!-- 2 -->
					<tr onclick="location.href='${path}/staff/books/num/edit'">
						<td rowspan="3">1</td>
						<td class="책 이미지" style="max-width: 135px" rowspan="3">
						<img src="${path}/resources/img/book/thumbnail/9772383984000.jpg" /></td>
						<td class="tempTitle" id="">{제목넘기기}</td>
						<td id="codetd">코드넘기자2</td>
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
						<td><input type="button" class="btn btn-danger" onclick="throwData(this)"
							data-toggle="modal" data-target="#bookCount"
							value="재고 수정" id="bookAdd" name="bookAdd{isbn등}" /></td>
							
						<td><input type="button" class="btn btn-danger"
							data-toggle="modal" data-target="#exampleModalCenter"
							value="도서 폐기" id="bookAdd" name="bookAdd{isbn등}" /></td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>

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

<script>

		function genreVal(){
			var val = $('#genreSel').val();
			console.log(val);
		}
		
		function throwData(ev){
			
			$(ev.closest("tbody")).find("#codetd").html("넘긴제목");
			/* let tr = ev.parentNode.parentNode.previousSibling.previousSibling.previousSibling.previousSibling;
			let title = tr.children[2].innerHTML;
			let code = tr.children[3].innerHTML;
			code = { "code" : code };			
			console.log(code);
			console.log($('.modal-title').text());
			$('.modal-title').text(title);
			$('.bookName').val(code);
			
		
			 */
			
		}
		
		function temp (){
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

