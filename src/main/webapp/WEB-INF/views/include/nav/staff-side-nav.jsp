<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	  <li class="nav-item">
	    <a class="nav-link disabled">직원 화면</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/${user.id}">내 정보</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/rentals">대여 현황</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/books">도서 현황</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/books/new">도서 입고</a>
	  </li>
	</ul>
</div>