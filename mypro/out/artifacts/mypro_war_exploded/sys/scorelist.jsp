<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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

<!--
JDBC 驱动名及数据库 URL
数据库的用户名与密码，需要根据自己的设置
useUnicode=true&characterEncoding=utf-8 防止中文乱码
 -->
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/mypro?useUnicode=true&characterEncoding=utf-8"
                   user="root"  password="jiaojiao.667"/>

<sql:query dataSource="${snapshot}" var="result">
    select * from score where name=?;
    <sql:param value="${requestScope.name}"/>
</sql:query>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif" /> 各科分数
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <c:choose>
                <c:when test="${not empty requestScope.columnNameList}">

                    <c:forEach var="columnName" items="${requestScope.columnNameList}">
                        <td align="center">${columnName}</td>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <td align="center" colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
                </c:otherwise>
            </c:choose>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <tr>
            <c:choose>
                <c:when test="${not empty requestScope.columnValueList}">
                    <c:forEach var="columnValue" items="${requestScope.columnValueList}">
                        <td>${columnValue}</td>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <td colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
