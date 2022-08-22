
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>



<section class="blog-details spad">
	<div class="container-md">
		<div class="row d-flex justify-content-center">

			<div class="col-md-8 blog__details__form spad">
				<form>
					<div class="col-md-8 section-title">
						<h4>[자유게시판 등록 제목]</h4> 
						
					</div>
					
					<div class="row justify-content-end">
			                        <select class="search_input_select">
		                                <option value="1">말머리</option>
		                                <option value="2">말머리1</option>
		                                <option value="3">말머리2</option>
		                            </select>
			                    </div>
					
					<input class="col-md-6 form-control" type="text"
						placeholder="제목을 작성하세요." />
								
						
					<div class="col-md-8 section-title">
						<h4>[자유게시판 등록 내용]</h4>
					</div>
					
					<textarea id="editor" class="col-md-6 form-control"
						style="resize: none;" placeholder="내용을 작성하세요."></textarea>
					<div class="normal-breadcrumb">	
						<button type="button" id="tempBtn" class="site-btn">등록</button>
						<button type="button" id="testBtn" class="site-btn">취소</button>
					</div>
						
				</form>
			</div>
		</div>
	</div>
</section>




<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>

<script>
	var ckeditor_config = {
		resize_enabled : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		filebrowserUploadUrl : "resources/ckUpload.do",
		filebrowserUploadMethod : 'form'
	};
	CKEDITOR.replace('editor', ckeditor_config);
	
	$("#testBtn").click(function(){
		console.log("hello");
		console.log($("#editor"));
		console.log($("textarea"));
		console.log($("#editor").editor);
		console.log($("#editor.editor"));
		let data = CKEDITOR.instances.editor.getData();
		console.log("data = " + data);
		
	});
	
</script>












