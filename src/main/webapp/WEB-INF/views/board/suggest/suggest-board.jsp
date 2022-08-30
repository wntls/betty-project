<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="row justify-content-between">
					<div class="col-auto">
						<h2>건의사항 - ${pm.totalCount}</h2>
					</div>
					<div class="col-auto">
						<select id="pageNumSelect" name="perPageNum" class="form-control">
							<option value="${pm.cri.perPageNum}">${pm.cri.perPageNum}개씩보기</option>
							<option value="10">10개씩 보기</option>
							<option value="20">20개씩 보기</option>
							<option value="30">30개씩 보기</option>
						</select>
					</div>
				</div>
				<div class="table-responsive">
					<div class="table-wrapper" class="col-md-10">
						<table class="table-data-list table-striped table-dark table-bordered table-hover">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성 시간</th>
									<th>조회수</th>
									<th>회원등급?</th>
								</tr>
							</thead>
							<tbody id="comments">
								<c:choose>
									<c:when test="${!empty list}">
										<jsp:useBean id="n" class="java.util.Date" />
										<f:formatDate var="now" value="${n}" pattern="yyyy-MM-dd" />
										<!-- mav.addObject("list",list);  List<SuggestBoard> -->
										<c:forEach var="sugBoard" items="${list}">
											<tr>
												<td>${sugBoard.bno}</td>
												<td>${sugBoard.title}</td>
												<td>${sugBoard.memberId}</td>
												<td>
													<f:formatDate var="reg" pattern="yyyy-MM-dd" value="${sugBoard.regdate}" />
													<c:choose>
														<c:when test="${now eq reg}">
															<f:formatDate value="${sugBoard.regdate}" pattern="HH:mm" />
														</c:when>
														<c:otherwise>
													${reg}
												</c:otherwise>
													</c:choose>
												</td>
												<td>${sugBoard.viewcnt}</td>
												<td>VVIP</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="5">건의사항이 없습니다</td>
										</tr>
									</c:otherwise>
								</c:choose>
						</table>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-6">
						<form id="searchForm" >
							<div class="form-row input-group mb-3">
								<div class="input-group-prepend">
									<select id="typeSel" name="searchType">
										<option ${pm.cri.searchType == null ? 'selected' : ''} value="n">검색 조건</option>
										<option ${pm.cri.searchType == 't' ? 'selected' : ''} value="t">제목</option>
										<option ${pm.cri.searchType == 'c' ? 'selected' : ''} value="c">내용</option>
										<option ${pm.cri.searchType == 'w' ? 'selected' : ''} value="w">닉네임</option>
										<option ${pm.cri.searchType == 'tc' ? 'selected' : ''} value="tc">제목 &amp; 내용</option>
									</select>
								</div>
								<input type="text" class="form-control" id="keyword" name="keyword">
								<div class="input-group-append">
									<button id="btn" type="button" class="btn btn-primary">검색하기</button>
								</div>
							</div>
							<!-- 히든태그로 값 넣어준다. -->
							<input type="number" id="perPageNum" name="perPageNum" hidden="true"/>
							<input type="hidden" id="searchType" name="searchType" />
						</form>
					</div>
					<div class="w-100"></div>
					<!-- 페이징 처리 -->
					<div class="form-row">
						<ul class="pagination" id="pa">
							<c:if test="${pm.first}">
								<li><a href="${path}/boards/suggest${pm.makeQuery(1)}">First</a></li>
							</c:if>
							<c:if test="${pm.prev}">
								<li><a href="${path}/boards/suggest${pm.makeQuery(pm.startPage-1)}">Prev</a></li>
							</c:if>
							<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
								<li ${pm.cri.page == i ? 'class=active' : ''}><a href="${path}/boards/suggest${pm.makeQuery(i)}">${i}</a></li>
							</c:forEach>
							<c:if test="${pm.next}">
								<li><a href="${path}/boards/suggest${pm.makeQuery(pm.endPage+1)}">Next</a></li>
							</c:if>
							<c:if test="${pm.last}">
								<li><a href="${path}/boards/suggest${pm.makeQuery(pm.maxPage)}">Last</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>
<script>
	// 히든 태그를 이용하여 form 태그 
	$("#pageNumSelect").on('change', function() {
		$("#perPageNum").val($(this).val());
		$("#searchForm").submit();
	});
	
	$("#typeSel").on('change', function() {
		console.log($(this).val());
		$("#searchType").val($(this).val());
	});
/* 		$("#perPageNum").val($("#pageNumSelect").val()); */

	$("#btn").click(function(){
		var searchType = $("#searchType").val();
		var keyword = $("#keyword").val();
		var perPageNum = $("#pageNumSelect").val();
		location.href="suggest?searchType="+searchType+"&keyword="+keyword+"&perPageNum="+perPageNum;
	});
	
	
	

	
</script>