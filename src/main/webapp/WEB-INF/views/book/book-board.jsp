<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

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
			
				<div class="row justify-content-around">
					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>

					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>

					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>


					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>
				</div>
					
					<div class="w-100 mb-5"></div>
				
				<div class="row justify-content-around">

					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>

					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>

					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
						</div>
					</div>


					<div class="card col-md-2">
						<img src="${path}/resources/img/book/medium/9772383984000.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">{title}</p>
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