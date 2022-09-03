<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<form id="boardForm">
					<div class="row justify-content-between">
						<div class="col-auto">
							<h2>공지사항</h2>
						</div>
						<div class="col-auto">
							<select id="pageNumSelect" name="perPageNum">
								<option value="${pm.cri.perPageNum }">${pm.cri.perPageNum}개씩</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="20">20</option>
							</select>
						</div>
					</div>
					<div class="table-responsive">
						<div class="table-wrapper">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>조회수</th>
										<th>작성일</th>
									</tr>
								</thead>
								<tbody id="tableBody">
								</tbody>
							</table>
						</div>
					</div>
				</form>
				<div class="row">
					<input type="button" value="글작성" id="notice-write" />
				</div>
				<div class="row justify-content-center">
					<div class="form-row">
						<ul class="pagination" id="pagenation">
						
						
							<c:if test="${pm.first }">
								<li><a href="${path}/boards/notice${pm.makeQuery(1)}">&laquo;&laquo;</a></li>
							</c:if>
							<c:if test="${pm.prev }">
								<li><a href="${path}/boards/notice${pm.makeQuery(pm.startPage-1) }">&laquo;</a></li>
							</c:if>
							<c:forEach var="i" begin="${pm.startPage }" end="${pm.endPage }">
								<li ${pm.cri.page == i ? 'class=active' : '' }><a href="${path}/boards/notice${pm.makeQuery(i) }"> ${i }</a></li>
							</c:forEach>
							<c:if test="${pm.next }">
								<li><a href="${path}/boards/notice${pm.makeQuery(pm.endPage+1) }">&raquo;</a></li>
							</c:if>
							<c:if test="${pm.last }">
								<li><a href="${path}/boards/notice${pm.makeQuery(pm.maxPage) }">&raquo;&raquo;</a></li>
							</c:if>
							
							
						</ul>
					</div>
					<div class="w-100"></div>
					<div class="col-6">
						<form id="searchTypeForm">
							<div class="form-row input-group mb-3">
								<div class="input-group-prepend">
									<select name="searchType">
										<option ${pm.cri.searchType == 't' ? 'selected' : ''} value="t">제목</option>
										<option ${pm.cri.searchType == 'w' ? 'selected' : ''} value="w">작성자</option>
										<option ${pm.cri.searchType == 'c' ? 'selected' : ''} value="c">내용</option>
									</select>
								</div>
								<input type="text" class="form-control" name="keyword" value="${pm.cri.keyword}">
								<div class="input-group-append">
									<button type="submit" id="searchTypeBtn" class="btn btn-primary">검색하기</button>
								</div>
							</div>
							<input type="hidden" name="perPageNum" value="${param.perPageNum}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>
<script>
	$("#notice-write").click(function() {
		location.href = '${path}/boards/notice/new'
	});
	
	$("#pageNumSelect").on('change', function() {
		$("#boardForm").submit();
	});
	
	/* 	function noticeBoardList(){
	var list;
	
	var perPageNum = $("#pageNumSelect").val();
	var totalCount = ${pm.totalCount};
	var page = "";
	console.log("per : "+perPageNum+" total : "+totalCount+" page : "+page);
	
	$.ajax({
		url : "${path}/boards/notice/boardList",
		type : "POST",
		data : {"page" : page, "perPageNum" : perPageNum},
		dataType : "json",
		success : function(data){
			console.log(data);
			list = JSON.parse(data);
			console.log(list);
		}
	});
	
} */



/* function perPage(event){
	console.log(event.value);
	location.href='${path}/boards/notice?perPage=' + event.value;
} */

</script>
