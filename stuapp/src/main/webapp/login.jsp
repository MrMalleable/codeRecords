<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"
			+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/login.css">
	<title>学生管理系统登录界面</title>
	<!--登录错误的提示信息 2017-7-28 22:40-->
	<script type="text/javascript">
        function load() {
            <!--status是在servlet传入到jsp页面的参数，登录失败为failure-->
            var state="<%=(String )request.getAttribute("status")%>";
            if(state=="failure"){
                alert("登录失败，用户名或密码错误，请核对是否有该用户或密码输入错误！");
                <!--改变地址栏的值 2017-7-29 9:53-->
                window.location.href="login.jsp";
            }
        }
	</script>
</head>
<body onload="load()">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="./js/jquery-1.12.4.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./js/bootstrap.min.js"></script>
    <div class="top"></div>
    <div class="login_form">
		<div class="clear"></div>
		<div class="admin">
			<img src="../images/admin.jpg">
		</div>
		<form  action="http://localhost:8080/loginjudge?method=login" method="post" id="loginForm">
				<input type="text" class="name" name="username"value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
			<div class="key">
				<input type="password" class="password" name="pwd" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
			</div>
			<div class="signin">
				<input type="submit" value="登录">
			</div>
		</form>
    </div>
    <div class="copy_rights">
		<p>Copyright &copy; 2017. L&H all rights reserved.</p>
    </div>
</body>
</html>