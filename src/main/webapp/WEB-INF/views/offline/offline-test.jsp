<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<h1>offline-main</h1>

				<div class="row card-deck row-cols-1 row-cols-md-2">
					<div class="col">
						<div class="card">
							<h5 class="card-header book-rantal">도서 수령</h5>
							<div class="card-body">
								<img src="${path}/resources/img/book/medium/9788952790033.jpg" 
									class="card-img-top anime__details__title" alt="..." /><br /> 
								<a href="#" class="btn btn btn-primary book-btn">대여 하기</a>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card">
							<h5 class="card-header book-return">도서 반납</h5>
							<div class="card-body">
								<img src="${path}/resources/img/book/medium/9791169250719.jpg" 
									class="card-img-top anime__details__title" alt="..." /> <br /> 
								<a href="#" class="btn btn btn-danger book-btn">반납 하기</a>
							</div>
						</div>
					</div>
					
					<div class="card-deck off-line">
						<div class="study-room">
							<!-- room01 -->
							<table class="room01">
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
							</table>
							
							<!-- room02 -->
							<table class="room02">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
							
							<!-- room03 -->
							<table class="room03">
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</section>
