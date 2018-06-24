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
</head>
<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <div class="top"></div>
    <div class="login_form">
		<div class="clear"></div>
		<div class="admin">
			<img src="../images/admin.jpg">
		</div>
		<form  action="${pageContext.request.contextPath}/loginjudge?method=login" method="post" id="loginForm">
				<input type="text" class="name" name="name"value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
			<div class="key">
				<input type="password" class="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
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