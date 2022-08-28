<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<h2>자유게시판</h2>
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="row justify-content-between mb-2">
						<div class="col-auto">
								<div class="btn-group" id="subject">
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="">전체</button>
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="li">일상</button>
							  <button type="button" class="btn btn-secondary mr-1" name="abc" value="qu">질문</button>
							  <button type="button" class="btn btn-secondary" name="abc" value="re">후기</button>
							</div>
						</div>
						<div class="col-auto">
							<select id="perPageNum">
								<option selected="selected">5</option>
								<option>10</option>
								<option>20</option>
							</select>
						</div>
					</div>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<!-- 1 -->
							<tr>
								<td>1</td>
								<td>{일상} {title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
							</tr>
							<!-- 2 -->
							<tr>
								<td>2</td>
								<td>{일상} {title}</td>
								<td>{auth}</td>
								<td>{viewcnt}</td>
								<td>{regdate}</td>
							</tr>
						</tbody>
					</table>


				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-6">
					<form id="searchForm" action="${path}/">
						<div class="form-row input-group mb-3">
							<div class="input-group-prepend">
								<select id="searchType">
									<option value="t">제목</option>
									<option value="w">작성자</option>
									<option value="c">내용</option>
								</select>
							</div>
							<input type="text" class="form-control" id="keyword">
							<div class="input-group-append">
								<button type="submit" onclick="testPrint(event)" class="btn btn-primary">검색하기</button>
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

