<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row row-cols-md-2">
			<div class="col mb-4">
				<div class="card h-100">
				  <img src="${path}/resources/img/member/profile_male.png" 
				  style="width:18rem"
				  class="card-img-top" alt="...">
				  <div class="card-body">
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				  </div>
				</div>
			</div>
			<div class="col mb-4">

				<div class="card h-100">
					<div class="card-header">Quote</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Integer posuere erat a ante.</p>
								
							<footer class="blockquote-footer">
								Someone famous in <cite title="Source Title">Source Title</cite>
							</footer>
						</blockquote>
					</div>
				</div>

			</div>


			<div class="col mb-4">

				<div class="card h-100">
					<div class="card-header">Quote</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Integer posuere erat a ante.</p>
							<footer class="blockquote-footer">
								Someone famous in <cite title="Source Title">Source Title</cite>
							</footer>
						</blockquote>
					</div>
				</div>

			</div>

			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header" 고객 센터</h5>
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btn-danger">이메일 상담하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>

