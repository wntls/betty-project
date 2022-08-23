
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
								<h4>대여 현황 및 예약 정보</h4>
							</div>
						</div>

						<div class="col-md-4 col-md-4 col-sm-6 anime__details__btn">
							<button class="follow-btn float-right"> 회원 리스트 </button>
						</div>
					</div>
				</div>

				<form>
					<div class="row justify-content-center spad">
						<table class="table-detail-search">
							<!-- 1행 -->
							<tr>
								<th>ISBN 범위 지정</th>
								<td class="text-align-left " colspan="3">
									<div class="input-group mb-3">
										<select class="custom-select" id="ISBNSel">
											<option selected>ISBN 범위 등등...</option>
											<option id="ISBN1">ISBN100~</option>
											<option id="ISBN2">ISBN200~</option>
											<option id="ISBN3">ISBN300~</option>
											<option id="ISBN4">ISBN400~</option>
											<option id="ISBN5">ISBN500~</option>
											<option id="ISBN6">ISBN600~</option>
										</select>
									</div>
								</td>
							</tr>
							<!-- 2행 -->
							<tr>
								<th>대여 여부</th>
								<td class="text-align-left"><input type='radio' name='all'
									value='전체' checked />전체 <input type='radio' name='rent'
									value='대여중' />대여중인 도서<input type='radio' name='reserv'
									value='예약중' />예약 중인 도서</td>
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
								<th>검색,{search}</th>
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

				<!-- table -->
				<h6 id="info"> * 책 표지나 테이블 클릭시 해당 도서를 상세보기 할수 있습니다</h6>
				<table id="blackTable"
					class="table-data-list table-striped table-dark text-center">
					<!-- 1블럭 -->
					<!-- 1 -->
					<!-- onclick 지정- 클릭시 북디테일로 넘어갈수있게 -->
					<tr onclick="location.href='${path}/books/num'">
						<td>번호</td>
						<td>책 표지</td>
						<td style="width: 130px">도서명</td>
						<td>ISBN</td>
						<td>작가</td>
						<td>출판사</td>
					</tr>
					<!-- 2 -->
					<!-- onclick 지정- 클릭시 북디테일로 넘어갈수있게 -->
					<tr onclick="location.href='${path}/books/num'">
						<td rowspan="3">{num}</td>
						<td class="책 이미지" style="max-width: 135px" rowspan="3"><img
							src="${path}/resources/img/book/origin/9788935213344.jpg" /></td>
						<td>{title}</td>
						<td>{code}</td>
						<td>{auth}</td>
						<td>{pub}</td>
					</tr>
					<!-- 3 -->
					<tr>
						<td style="width: 130px">보유중 /총 권수(복잡하면빼자)</td>
						<td style="width: 130px">대여여부</td>
						<td style="width: 130px">대여자</td>
						<td style="width: 130px">반납예정일</td>
					</tr>
					<!-- 4 -->
					<tr>
						<td>{보유권수} / {소장 권수}</td>
						<td>{대여여부나 대여중인 권수}</td>
						<td>{대여자}</td>
						<td>{반남 예정일}</td>
					</tr>
					<!-- 1블럭 -->
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
						<td rowspan="3">{num}</td>
						<td class="책 이미지" style="max-width: 135px" rowspan="3"><img
							src="${path}/resources/img/book/origin/9791190826556.jpg" /></td>
						<td>{title}</td>
						<td>{code}</td>
						<td>{auth}</td>
						<td>{pub}</td>
					</tr>
					<!-- 3 -->
					<tr>
						<td style="width: 130px">보유중 /총 권수</td>
						<td style="width: 130px">대여여부</td>
						<td style="width: 130px">대여자</td>
						<td style="width: 130px">반납예정일</td>
					</tr>
					<!-- 4 -->
					<tr>
						<td>{소장 권수} / {보유권수}</td>
						<td>{rental}</td>
						<td>{대여자}</td>
						<td>{반남 예정일}</td>
					</tr>
					<!-- 1블럭 -->
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
						<td class="책 이미지" style="max-width: 135px" rowspan="3"><img
							src="${path}/resources/img/book/origin/9788935213344.jpg" /></td>
						<td>{title}</td>
						<td>{code}</td>
						<td>{auth}</td>
						<td>{pub}</td>
					</tr>
					<!-- 3 -->
					<tr>
						<td style="width: 130px">총 소장 권수(같은 이름의 책) / 현재 보유 권수</td>
						<td style="width: 130px">대여여부</td>
						<td style="width: 130px">대여자</td>
						<td style="width: 130px">반납예정일</td>
					</tr>
					<!-- 4 -->
					<tr>
						<td>{소장 권수} / {보유권수}</td>
						<td>{대여여부나 대여중인 권수}</td>
						<td>{대여자}</td>
						<td>{반남 예정일}</td>
					</tr>
					<!-- 1블럭 -->

				</table>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>

