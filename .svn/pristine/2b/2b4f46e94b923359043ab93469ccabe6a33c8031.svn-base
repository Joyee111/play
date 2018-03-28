<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modifyInfo">
	姓名：<input type = "text"  name = "name" id = "name" value = "${UserInfoEntity.name}" readonly = "true">
	年龄：<input type = "text"  name = "age" id = "age" value = "${UserInfoEntity.age}" readonly = "true">
	地址：<input type = "text"  name = "address" id = "address" value = "${UserInfoEntity.address}" readonly = "true">
	<input type = "hidden" value = ${UserInfoEntity.userInfoId} id = "userInfoId" name = "userInfoId">
	<input type = "hidden" name = "save" id = "save" value = "保存">
</form>
	<button  onclick = "modify()">修改</button>
</body>
<script type="text/javascript">
function modify(){
	$('input').removeAttr("readonly");

	$('input[name = save]').attr("type", "submit");
	}
</script>
</html>