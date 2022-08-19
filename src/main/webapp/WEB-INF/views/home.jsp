<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="/resources/ckeditor/ckeditor.js"></script>
	<script>
		var ckeditor_config = {
				resize_enable : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/common/ckUpload"
		};
	</script>
</head>
<body>
<h1>HOME</h1>
<textarea name="bookIntro" id="bookIntro_textarea"></textarea>
<script>
	CKEDITOR.replace("bookIntro_textarea", ckeditor_config);
</script>

</body>
</html>
