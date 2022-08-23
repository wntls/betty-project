
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="product__page__title">
					<div class="row">
						<div class="col-md-8 col-md-8 col-md-6 title__align__center">
							<div class="section-title">
								<h4>대여 현황</h4>
							</div>
						</div>
					</div>
				</div>


				<form>
					<table class="table table-borderless table-dark mb-5">
						<tbody>
							<!-- 1행 -->
							<tr>
								<th scope="row">대여 상태</th>
								<td colspan="2">
									<div class="btn-group btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-secondary active"> <input
											type="radio" name="rental" value="all" checked> 전체
										</label> <label class="btn btn-secondary"> <input type="radio"
											name="rental" value="rent"> 대여중인 도서
										</label> <label class="btn btn-secondary"> <input type="radio"
											name="rental" value="reserv"> 예약중인 도서
										</label>
									</div>
								</td>
								<td></td>
							</tr>
							<!-- 2행 -->
							<tr>
								<th scope="row">도서 발행일 별</th>
								<td colspan="3">
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
				<h6 id="info">* 책 표지나 테이블 클릭시 해당 도서를 상세보기 할수 있습니다</h6>
				<table id="blackTable"
					class="table-data-list table-striped table-dark text-center">
					<!-- 1 -->
					<tr>
						<td>번호</td>
						<td>도서명</td>
						<td>ISBN</td>
						<td>대여여부</td> <!-- Y : 대여자,  R : 예약자 , N : none -->
						<td>대여자</td> <!-- stat.equals('R') => 예약자 -->
						<td>도서 대여일</td>
						<td>반납 예정일</td>
					</tr>
					<!-- 2 -->
					<tr>
						<td>1</td>
						<td>리 제로부터ㅁㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㄹ 시작하는 이세계 생활</td>
						<td>123456789098</td>
						<td>R</td>
						<td>김선기</td>
						<td>2022-08-23</td>
						<td>2022-09-15</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>

