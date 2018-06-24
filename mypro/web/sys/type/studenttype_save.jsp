<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
	
<title>学生信息管理</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css" />
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/>  添加学生基本信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/studenttype?method=addStudentType" method="post">
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/sys/style/images/item_point.gif"> 学生信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="80px">学号</td>
							<td>
								<input type="text" name="id" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">姓名</td>
							<td>
								<input type="text" name="name" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">密码</td>
							<td>
								<input type="text" name="password" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">性别</td>
							<td>
								<input type="text" name="sex" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">年龄</td>
							<td>
								<input type="text" name="age" class="InputStyle" value=""/>*
							</td>
						</tr>
						<tr>
							<td width="80px">手机号码</td>
							<td>
								<input type="text" name="phonenumber" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">邮箱</td>
							<td>
								<input type="text" name="email" class="InputStyle" value=""/> *
							</td>
						</tr>
						<tr>
							<td width="80px">班级</td>
							<td>
								<input type="text" name="in_which_class" class="InputStyle" value=""/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			<input type="submit" value="添加" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>




</body>
</html>
