<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>学生信息管理平台</title>



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
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif" /> 学生信息列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/studenttype?method=search" method="post">
			<input type="text" name="id" title="请输入要查询的学生学号">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td align="center">学号</td>
					<td align="center">姓名</td>
					<td align="center">密码</td>
					<td align="center">性别</td>
					<td align="center">年龄</td>
					<td align="center">手机号码</td>
					<td align="center">邮箱</td>
					<td align="center">班级</td>
					<td align="center">执行操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
					<c:choose>
						<c:when test="${not empty requestScope.listStudentType}">
							
							<c:forEach var="studentType" items="${requestScope.listStudentType}">
								<tr align="center">
									<td align="center">${studentType.id }</td>
									<td align="center">${studentType.name}</td>
									<td align="center">${studentType.password }</td>
									<td align="center">${studentType.sex }</td>
									<td align="center">${studentType.age }</td>
									<td align="center">${studentType.phonenumber }</td>
									<td align="center">${studentType.email }</td>
									<td align="center">${studentType.in_which_class}</td>
									<td align="center">
										<a href="${pageContext.request.contextPath }/studenttype?id=${studentType.id}&&method=viewUpdate" class="FunctionButton">更新</a>
										<a href="${pageContext.request.contextPath }/studenttype?id=${studentType.id}&method=delete" class="FunctionButton">删除</a>
									</td>
								</tr>
							</c:forEach>
						
						</c:when>
						<c:otherwise>
							<tr align="center">
								<td align="center" colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
							</tr>
						</c:otherwise>
					</c:choose>
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath }/sys/type/studenttype_save.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
