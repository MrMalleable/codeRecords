<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.stuapp.entity.StudentType" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"
			+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/details.css">
    <script type="text/javascript" src="../js/details.js"></script>
	<title>学生信息管理系统</title>
	<script type="text/javascript">
		// 显示或隐藏二级菜单
		function menuClick( menuDiv ){
			$(".MenuLevel2").not( $(menuDiv).next() ).hide();
			$(menuDiv).next().toggle();
		}

		$(function(){
			// 默认只显示第1个二级菜单
			$(".MenuLevel2").hide();
			$(".MenuLevel2:first").show();
		});
	//<!-- 内容总宽度为 3px边框 * 2 + 155px内容 = 161px; -->
	</script>
	<script type="text/javascript">
        function load(){
            //若更新成功则会返回success_update
            var state="<%=request.getAttribute("update")%>";
            if("success_update"==state){
                history.pushState(history.state,null,"/inner/details_of_grade.jsp");
            }
        }
	</script>

	<!--判断输入的数据是否为空的js函数 2017-7-29 10:43-->
	<script type="text/javascript">
        function validate_required(field,alerttxt)
        {
            with (field)
            {
                if (value==null||value=="")
                {alert(alerttxt);return false}
                else {return true}
            }
        }

        function validate_form(thisform)
        {
            with (thisform)
            {
                if (validate_required(pwd,"密码输入栏不能为空")==false){
                    pwd.focus();return false
                }else if(validate_required(pwd_confirm,"确认密码输入栏不能为空")==false){
                    pwd_confirm.focus();return false
                }else if(validate_required(tel,"手机号码不能为空")==false){
                    tel.focus();return false
                }else if(validate_required(contact,"紧急联系人不能为空")==false){
                    contact.focus();return false
                }else if(validate_required(email,"邮箱不能为空")==false){
                    email.focus();return false
                }else if(validate_required(qq,"QQ不能为空")==false){
                    qq.focus();return false
                }else if(validate_required(address,"家庭住址不能为空")==false){
                    address.focus();return false
                }else{
                    return true
                }
            }
        }
	</script>
</head>
<body onload="load()">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <div id="container">
		<div id="top">
			<div class="t_left" onclick="location.href='http://localhost:8080/inner/index.jsp'">
				<div id="logo"></div>
				<div id="sname"><p>学生信息管理系统</p></div>
				</div>
				<div class="t_right">
						<div class="admin">
							<ul>
								<li class="drop-down">
									<a><img src="../images/adm.png" alt=""><p>东方不败</p></a>
									<ul class="drop-down-content">
										<li><a id="openmodal" data-toggle="modal" data-target="#myModal" data-backdrop="static" data-keyboard="false" class="operate">修改个人信息</a></li>
										<li><a href="http://localhost:8080/login.jsp" class="operate">切换账户</a></li>
									</ul>
								</li>
							</ul>
						</div>
						<div class="exit"><a href="http://localhost:8080/login.jsp"><img src="../images/close.png" alt=""><p>注销</p></a></div>
					</ul>
				</div>
		</div>
		<div id="main">
			<div id="lside">
				<ul id="Menu">
			    <li class="level1">
		            <div onClick="menuClick(this);" class="level1Style">
						<img src="../images/menu.gif"/> 
						系统菜单
					</div>
		            <ul class="MenuLevel2">
		            	<li class="level2">
		                    <a id="query" href='http://localhost:8080/displaygrade?username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>'>成绩查询</a>
						</li>
		                <li class="level2">
		                	<a id="classes" href='http://localhost:8080/displayclass?username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>'>选课系统</a>
						</li>
		            </ul>
		        </li>
		    </ul>
			</div>
			<div id="rside"></div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<!--提交一个表单-->
	<form class="form-inline" action='http://localhost:8080/modifyinfo?location=grade&username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>' onsubmit="return validate_form(this)" method="post">
		<div class="modal fade v-align" id="myModal" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:692px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							用户信息管理
						</h4>
					</div>
					<div class="modal-body">
						<div id="info_form">
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="username">用户名:</label>
								<!--晕，当设置为disabled属性时，不能通过request.getParameter("name")获取值，在这卡了好久啊，2017-7-30-->
								<input type="text" name="username" class="form-control" id="username" value="<%=((StudentType)session.getAttribute("studentType")).getUsername()%>" readonly>
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="stuid">学　号:</label>
								<input type="text" name="stuid" class="form-control" id="stuid" value="<%=((StudentType)session.getAttribute("studentType")).getStuid()%>" readonly>
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<!--删除label标签的for属性-->
								<label>性　别：</label>
								<select name="sex" class="form-control">
									<c:choose>
									    <c:when test='<%=((StudentType)session.getAttribute("studentType")).getSex().equals("男")%>'>
										    <option value="男" selected = "selected">男</option>
										    <option value="女">女</option>
									    </c:when>
									    <c:otherwise>
											<option value="女" selected = "selected">女</option>
										    <option value="男">男</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="academy">学　院:</label>
								<input type="text" name="academy" class="form-control" id="academy" value="<%=((StudentType)session.getAttribute("studentType")).getAcademy()%>" readonly>
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="class_in">所属班级:</label>
								<input type="text" name="class_in" class="form-control" id="class_in" value="<%=((StudentType)session.getAttribute("studentType")).getClass_in()%>" readonly>
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="pwd">新密码:</label>
								<input type="password" name="pwd" class="form-control" id="pwd" placeholder="" title="请输入新密码">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="pwd_confirm">确认密码:</label>
								<input type="password" name="pwd_confirm" class="form-control" id="pwd_confirm" placeholder="" title="请再次确认输入的密码">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="tel">手　机:</label>
								<input type="text" name="tel" class="form-control" id="tel" placeholder="18818219889" title="请输入您现在使用的手机号">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="contact">紧急联系人:</label>
								<input type="text" name="contact" class="form-control" id="contact" placeholder="" title="请输入您紧急联系人的手机号">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="email">邮　箱:</label>
								<input type="email" name="email" class="form-control" style="width: 256px" id="email" placeholder="" title="请输入您的常用邮箱">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="qq">QQ:</label>
								<input type="text" name="qq" class="form-control" style="width: 200px" id="qq" placeholder="" title="请输入您的QQ号码">
							</div>
							<div class="form-group" style="margin: 15px 15px 15px 0">
								<label for="address">地　址:</label>
								<input type="text" name="address" class="form-control" style="width: 480px" id="address" placeholder="" title="请输入您的家庭住址">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-primary">
							保存
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
	</form>
		<script type="text/javascript">
			$(function(){
				load_grade();
			});
			function load_grade(){
           		document.getElementById("rside").innerHTML = '<object type="text/html" data="/inner/grade.jsp" width="100%" height="100%"></object>';
      		}
		</script>
</body>
</html>