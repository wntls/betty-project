<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	   <li class="nav-item">
	    <a class="nav-link disabled" href="#">마이페이지</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/dashboard">대시보드</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/charge">포인트충전</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/rentals">대여 이력</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}">회원정보</a>
	  </li>
	</ul>
</div>