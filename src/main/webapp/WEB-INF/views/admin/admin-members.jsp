<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 관리자가 보는 회원 정보 화면 -->

<%@include file="/WEB-INF/views/include/header.jsp"%>



<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="product__page__title">
					<div class="row">
						<div class="col-md-8 col-md-8 col-md-6 title__align__center">
							<div class="section-title">
								<h4>회원 정보</h4>
							</div>
						</div>
					</div>
				</div>

				<form>
					<table class="table table-borderless table-dark mb-5">
						<tbody>
							<tr>
								<th scope="row">가입 승인</th>
								<td colspan="2">
									<div class="btn-group btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-secondary active"> 
											<input type="radio" name="" value="" checked> 전체
										</label> 
										<label class="btn btn-secondary"> 
											<input type="radio"	name="" value=""> 승인 
										</label> 
										<label class="btn btn-secondary"> 
											<input type="radio" name="" value=""> 미승인
										</label>
									</div>
								</td>
								<td></td>
							</tr>

							<!-- 2행 -->
							<tr>
								<th scope="row">대여 상태</th>
								<td colspan="2">
									<div class="btn-group btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-secondary active"> 
											<input type="radio" name="" value="all" checked> 전체
										</label> 
										<label class="btn btn-secondary"> 
											<input type="radio"	name="" value=""> 일반회원
										</label> 
										<label class="btn btn-secondary"> 
											<input type="radio"name="" value=""> 직원
										</label>
									</div>
								</td>
								<td></td>
							</tr>
							<!-- 3행 -->
							<tr>
								<th scope="row">회원 등급</th>
								<td colspan="3">
									<div class="input-group text-secondary">
										<select>
											<option value="">전체</option>
											<option value="bronze">브론즈</option>
											<option value="siver">실버</option>
											<option value="VIP">VIP</option>
										</select>
									</div>
								</td>
							</tr>
							<!-- 4행 -->
							<tr>
								<th scope="row">검색</th>
								<td>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<select>
												<option value="">키워드 선택</option>
												<option value="id">아이디</option>
												<option value="name">이름</option>
												<option value="addr">주소</option>
											</select>
										</div>
										<input type="text" class="form-control"
											style="max-height: 36.5px">
								</td>
								<td></td>
								<td><input class="btn btn-danger" type="submit" value="검색" /></td>
							</tr>
						</tbody>
					</table>
				</form>


				<!-- table -->
				<table class="table-data-list table-striped table-dark">
					<!-- 1 -->
					<tr class="text-center">
						<td>번호</td>
						<td>회원사진</td>
						<td>아이디</td>
						<td>닉네임</td>
						<td>이름</td>
						<td>성별</td>
						<td>생년월일</td>
						<td>전화번호</td>
						<td>이메일</td>
						<td colspan="2">주소</td>
					</tr>

					<!-- 2 -->
					<tr>
						<td rowspan="3">1</td>
						<td rowspan="3" class="thumb-list-profile"><img
							src="${path}/resources/img/member/thumbnail/profile_male.jpg" /></td>
						<td>namu6747</td>
						<td>namu6747</td>
						<td>박재민</td>
						<td>남</td>
						<td>960205</td>
						<td>01056556747</td>
						<td>namu6747@naver.com</td>
						<td colspan="2">부산시 금정구 남산동 1234-5</td>
					</tr>

					<!-- 3 -->
					<tr>
						<td>회원구분</td>
						<td>회원등급</td>
						<td>포인트</td>
						<td>대여권수</td>
						<td>대여횟수</td>
						<td>체크인여부</td>
						<td>회원가입일</td>
						<td>가입승인</td>
						<td>블랙리스트</td>
					</tr>

					<!-- 4 -->
					<tr>
						<td>일반</td>
						<td>VIP</td>
						<td>30000</td>
						<td>2</td>
						<td>8</td>
						<td>OK</td>
						<td>2022-08-18</td>
						<td>OK</td>
						<td>NO</td>
					</tr>

					<!-- 1 -->
					<tr class="text-center">
						<td>번호</td>
						<td>회원사진</td>
						<td>아이디</td>
						<td>닉네임</td>
						<td>이름</td>
						<td>성별</td>
						<td>생년월일</td>
						<td>전화번호</td>
						<td>이메일</td>
						<td colspan="2">주소</td>
					</tr>

					<!-- 2 -->
					<tr>
						<td rowspan="3">1</td>
						<td rowspan="3" class="thumb-list-profile"><img
							src="${path}/resources/img/member/thumbnail/profile_male.jpg" /></td>
						<td>namu6747</td>
						<td>namu6747</td>
						<td>박재민</td>
						<td>남</td>
						<td>960205</td>
						<td>01056556747</td>
						<td>namu6747@naver.com</td>
						<td colspan="2">부산시 금정구 남산동 1234-5</td>
					</tr>
					<!-- 3 -->
					<tr>
						<td>회원구분</td>
						<td>회원등급</td>
						<td>포인트</td>
						<td>대여권수</td>
						<td>대여횟수</td>
						<td>체크인여부</td>
						<td>회원가입일</td>
						<td>가입승인</td>
						<td>블랙리스트</td>
					</tr>
					<!-- 4 -->
					<tr>
						<td>일반</td>
						<td>VIP</td>
						<td>30000</td>
						<td>2</td>
						<td>8</td>
						<td>OK</td>
						<td>2022-08-18</td>
						<td>OK</td>
						<td>NO</td>
					</tr>
				</table>


				<!-- col-md-10 -->
			</div>
		</div>
		<!-- container -->
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>

</html>