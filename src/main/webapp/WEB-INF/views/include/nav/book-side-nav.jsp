<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <style>
 .nav-item {
     margin-bottom: 0; 
}
 </style>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	  <li class="nav-item">
	    <a class="nav-link disabled">장르 선택</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books">전체</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=100">철학</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=200">종교</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=300">사회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=400">과학</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=500">공학</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=600">예술</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=700">외국어</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=800">소설</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${path}/books?genre=900">역사</a>
	  </li>
	</ul>
</div>