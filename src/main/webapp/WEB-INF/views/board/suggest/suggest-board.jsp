<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="row justify-content-between">
				<div class="col-auto">
					<h2>건의사항</h2>
				</div>
				<div class="col-auto">
					<select>
						<option selected="selected">5</option>
						<option>10</option>
						<option>20</option>
					</select>
				</div>
			</div>


			<div class="table-responsive">
				<div class="table-wrapper">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>추천수</th>
							</tr>
						</thead>
						<tbody>
							<!-- 1 -->
							<tr>
								<td>1</td>
								<td>{title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
								<td>{recommend}</td>
							</tr>
							<!-- 2 -->
							<tr>
								<td>2</td>
								<td>{title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
								<td>{recommend}</td>
							</tr>
						</tbody>
					</table>


				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-6">
					<form>
						<div class="form-row input-group mb-3">
							<div class="input-group-prepend">
								<select>
									<option value="">제목</option>
									<option value="">작성자</option>
									<option value="">내용</option>
								</select>
							</div>
							<input type="text" class="form-control">
							<div class="input-group-append">
								<button type="submit" class="btn btn-primary">검색하기</button>
							</div>
						</div>
					</form>
				</div>
				<div class="w-100"></div>

				<!-- 페이징 처리 -->
				<div class="form-row">
					<ul class="pagination" id="pa">
						<li><a href="#">Previous</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>

