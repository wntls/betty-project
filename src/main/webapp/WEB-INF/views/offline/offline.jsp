<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<style>
section {
	font-size: 0.8rem;
	vertical-align: middle;
}

.card-body {
	height: 300px
}

table {
	table-layout: fixed;
}

table th {
	text-align: center;
}

table td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	text-align: center;
	line-height: 1.8rem;
}
.seat tr td{
	background: #dc3545;
	border: 1px white solid !important;
}

.seat tr td:nth-child(2), .seat tr td:nth-child(5){
	background: none;
	border-top: 0 !important;
	border-bottom: 0 !important;
}
</style>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<h2 class="mb-5">
					<c:if test="${not empty user}">
						${user.name}님의 오프라인 화면
					</c:if>
				</h2>
				<div class="row row-cols-1 row-cols-md-2">
					<div class="col mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">도서 수령</h5>
								<table class="table">
									<thead>
										<tr>
											<th>도서명</th>
											<th>예약일</th>
											<th>수령하기</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<!-- book code, book num, user id -->
											<form action="${path}/offline/receipt" method="post">
												<input type="text" name="code" value="1244561244" hidden />
												<input type="text" name="num" value="002" hidden />
												<td>전생에 슬라임이었던 건에 대해서</td>
												<td>2022-08-31</td>
												<td><button class="btn btn-danger btn-sm" name="id"
														value="${user.id}">수령</button></td>
											</form>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">도서 반납</h5>
								<table class="table">
									<thead>
										<tr>
											<th>도서명</th>
											<th>반납예정일</th>
											<th>반납하기</th>
										</tr>
									</thead>
									<tbody>
										<!-- book code, book num, user id -->
										<tr>
											<form action="${path}/offline/return" method="post">
												<input type="text" name="code" value="6363531244" hidden />
												<input type="text" name="num" value="003" hidden />
												<td>강철의 연금술사</td>
												<td>2022-09-05</td>
												<td><button class="btn btn-danger btn-sm" name="id"
														value="${user.id}">반납</button></td>
											</form>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">스터디룸</h5>

								<table class="table seat">
									<tr>
										<td>1</td>
										<td></td>
										<td>2</td>
										<td>3</td>
										<td></td>
										<td>4</td>
									</tr>
									<tr>
										<td>5</td>
										<td></td>
										<td>6</td>
										<td>7</td>
										<td></td>
										<td>8</td>
									</tr>
									<tr>
										<td>9</td>
										<td></td>
										<td>10</td>
										<td>11</td>
										<td></td>
										<td>12</td>
									</tr>
									<tr>
										<td>13</td>
										<td></td>
										<td>14</td>
										<td>15</td>
										<td></td>
										<td>16</td>
									</tr>
								</table>

							</div>
						</div>
					</div>
					<div class="col mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">체크인 & 체크아웃</h5>
								<div class="d-flex flex-column" style="padding: 3rem">
									<button type="button" class="btn btn-danger btn-lg mb-3">체크인</button>
									<button type="button" class="btn btn-danger btn-lg">체크아웃</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>