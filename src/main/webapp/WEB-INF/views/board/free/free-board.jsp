<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<h2><s:message code="text.board.free"/></h2>
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="row justify-content-between mb-2">
							<div class="col-auto">
								<div class="btn-group" id="subject">
									<button type="button" class="btn btn-secondary mr-1" name="abc"
										value=""><s:message code="text.all"/></button>
									<button type="button" class="btn btn-secondary mr-1" name="abc"
										value="li">일상</button>
									<button type="button" class="btn btn-secondary mr-1" name="abc"
										value="qu">질문</button>
									<button type="button" class="btn btn-secondary" name="abc"
										value="re">후기</button>
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
							<!-- 게시글 list -->
							<thead>
								<tr>
									<th>#</th>
									<th><s:message code="text.board.title"/></th>
									<th><s:message code="text.writer"/></th>
									<th><s:message code="text.views"/></th>
									<th><s:message code="text.board.regdate"/></th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty list}">
										<c:forEach var="board" items="${list}">
											<c:choose>
												<c:when test="${!empty list}">
													<c:forEach var="board" items="${list}">
														<c:choose>
															<c:when test="${board.showboard eq 'y'}">
																<tr>
																	<td>${board.bno}</td>
																	<td><a
																		href="free/${board.bno}?${pm.makeQuery(pm.cri.page)}">${board.tag}&nbsp;&nbsp;${board.title}</a>
																	</td>
																	<td>${board.nickname}</td>
																	<td>${board.viewcnt}</td>
																	<td><f:formatDate value="${board.regdate}"
																			pattern="yyyy-MM-dd (E) hh:mm" /></td>
																</tr>
															</c:when>
															<c:otherwise>
																<tr>
																	<td></td>
																	<td>삭제된 게시물 입니다.</td>
																	<td></td>
																	<td></td>
																	<td></td>
																</tr>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<tr>
														<td></td>
														<td>등록된 게시물이 없습니다.</td>
														<td></td>
														<td></td>
														<td></td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:when>
								</c:choose>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<input type="button" class="btn btn-secondary" value="글작성"
					id="free-write" />
			</div>
			<div class="row justify-content-center">

				<div class="col-6">
					<div class="form-row input-group mb-3">
						<div class="input-group-prepend">
							<select>
								<option value="t"><s:message code="text.board.title"/></option>
								<option value="w"><s:message code="text.writer"/></option>
								<option value="c">내용</option>
							</select>
						</div>
						<input type="text" class="form-control" id="keyword">
						<div class="input-group-append">
							<button type="submit" id="searchBtn" class="btn btn-primary">검색하기</button>
						</div>
					</div>
				</div>
				<div class="w-100"></div>
				<!-- 페이징 처리 -->
				<div class="form-row">
					<ul class="pagination" id="pa">
						<c:if test="${pm.first}">
							<li><a href="free${pm.makeQuery(1)}">&laquo;&laquo;</a></li>
						</c:if>
						<c:if test="${pm.prev}">
							<li><a href="free${pm.makeQuery(pm.startPage-1)}">Previous</a></li>
						</c:if>
						<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
							<li><a href="free${pm.makeQuery(i)}">${i}</a></li>
						</c:forEach>
						<c:if test="${pm.next}">
							<li><a href="free${pm.makeQuery(pm.endPage+1)}">Next</a></li>
						</c:if>
						<c:if test="${pm.last}">
							<li><a href="free${pm.makeQuery(pm.maxPage)}">&raquo;&raquo;</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
<script>
	$("#searchBtn").click(
			function() {
				var searchType = $(
						".input-group-prepend select option:selected").val();
				var keyword = $("#keyword").val();
				console.log("selectType : " + searchType);
				console.log("keyword : " + keyword);
				location.href = "free?searchType=" + searchType + "&keyword="
						+ keyword;
			});

	$("#perPageNum").on('change', function() {
		$("#boardForm").submit();
	});

	$("#free-write").click(function() {
		location.href = '${path}/boards/free/new'
	});
</script>
