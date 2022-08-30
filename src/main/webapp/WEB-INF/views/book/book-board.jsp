<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<style>
	.card{
		padding:1rem;
		width: 170px;
		height: 300px;
		overflow: hidden;
	}

	.card-img-top{
		width:136px;
		height:200px;
	}
	
	.card-body, .card-title{
		font-size: 1rem !important;
		padding: 0;
	}
	
	.card-title{
		margin-top:1rem;
	}
</style>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-10">
			<div class="btn-group btn-group-toggle mb-5" data-toggle="buttons">
			  <label class="btn btn-secondary active">
			    <input type="radio" name="genre" value="" checked> 전체
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="100"> 철학
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="200"> 종교
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="300"> 사회
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="400"> 과학
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="500"> 공학
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="600"> 예술
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="700"> 외국어
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="800"> 소설
			  </label>
			  <label class="btn btn-secondary">
			    <input type="radio" name="genre" value="900"> 역사
			  </label>
			</div>
				<div class="row row-cols-1 row-cols-md-4">
				  <div class="col mb-3">
				    <div class="card">
				      <img src="${path}/resources/img/book/origin/9772383984000.jpg" class="card-img-top">
				      <div class="card-body">
				        <h5 class="card-title">양자역학은 어떻게 세상을 바꾸ㅂㅈㄷㅂㅈㅈㅂㄷㅂ431234112412241214124ㅈㄷㅈㄷㅈㅂㄷ는가</h5>
				      </div>
				    </div>
				  </div>
				  <div class="col mb-3">
				    <div class="card">
				      <img src="${path}/resources/img/book/origin/9772383984000.jpg" class="card-img-top">
				      <div class="card-body">
				        <h5 class="card-title">Card title</h5>
				      </div>
				    </div>
				  </div>
				  <div class="col mb-3">
				    <div class="card">
				      <img src="${path}/resources/img/book/origin/9772383984000.jpg" class="card-img-top">
				      <div class="card-body">
				        <h5 class="card-title">Card title</h5>
				      </div>
				    </div>
				  </div>
				  <div class="col mb-4">
				    <div class="card">
				      <img src="${path}/resources/img/book/origin/9772383984000.jpg" class="card-img-top">
				      <div class="card-body">
				        <h5 class="card-title">Card title</h5>
				      </div>
				    </div>
				  </div>
				</div>
				<div class="row justify-content-between mt-5">
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
<!-- Product Section End -->

<%@include file="/WEB-INF/views/include/footer.jsp"%>

</html>