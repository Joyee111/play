<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  name = "form1" onSubmit="return juge()" action="checkInfo">
<h2>Id:</h2>
<input type = "text" name = "username" id = "username"/>
<h2>Password:</h2>
<input type = "password" name = "password" id = "password"/>
<label><input type = "submit" name = "login" value = "Login" onclick = "juge()"></label>
<a href = "http://localhost:8088/play-web/register">register</a>
</form>
</body>
<script type="text/javascript">
function juge()
{
	var username = document.getElementById("username");
	var password = document.getElementById("password");
if(username.value=="")
{
alert("id can't be null");
username.focus();
return false;
}
if(password.value=="")
{
  alert("password can't be null");
 	password.focus();
  return false;
}
return true;
}

</script>
</html>