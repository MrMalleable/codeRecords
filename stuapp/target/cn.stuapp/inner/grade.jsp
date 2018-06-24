<%@ page import="cn.stuapp.entity.ScoreType" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.stuapp.entity.StudentType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../css/grade.css">
    <script src="../js/mypage.js"></script>
	<title>学生信息管理系统</title>
</head>
<body onload="jumpPage(1,1,2)">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-1.12.4.js" charset="UTF-8"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.js" charset="UTF-8">
    </script>
    <script src="../js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" ></script>
    <div id="container">
    	<div id="show">
    		<img src="../images/findsm.png" alt="">
    		<span>成绩查询</span>
    	</div>
	    <div id="query">
			<form action='http://localhost:8080/displaygrade?method=search&username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>' class="form-inline" method="post">
			  <div class="form-group">
			    <label for="subjectid">课程编号：</label>
			    <input type="text" name="subjectid" class="form-control" id="subjectid" size="10" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="subjectname">课程名称：</label>
			    <input type="text" name="subjectname" class="form-control" id="subjectname" size="10" placeholder="">
			  </div>
			  <div class="form-group">
                <label for="testtime" >考试时间：</label>
                <div class="input-group date form_date col-md-5" data-date="2017-7-28" data-date-format="yyyy-MM-dd" data-link-field="testtime" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="36" type="text" name="testtime" id="testtime" value="">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
            </div>
			  <button type="submit" class="btn btn-info">查询</button>
			</form>
	    </div>
	    <div class="table-responsive" >
			<table class="table table-hover">
				<thead>
				<tr class="info">
				  <td >课程编号</td>
				  <td >课程名称</td>
				  <td >考试时间</td>
				  <td >分数</td>
				  <td >状态</td>
				</tr>
				</thead>
				<tbody id="databody">
				<%--<c:choose>
					<c:when test="${not empty sessionScope.scoreTypeList}">
						<c:forEach var="scoreType" items="${sessionScope.scoreTypeList}">
							<tr>
								<td>${scoreType.subjectid }</td>
								<td>${scoreType.subjectname}</td>
								<td>${scoreType.testtime }</td>
								<td>${scoreType.score }</td>
								<c:choose>
									<c:when test="${scoreType.score>=60}">
										<td>已通过</td>
									</c:when>
									<c:otherwise>
										<td>未通过</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr align="center">
							<td align="center" colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
						</tr>
					</c:otherwise>
				</c:choose>--%>
				<%
					List<ScoreType> scoreTypeList=(List<ScoreType>) session.getAttribute("scoreTypeList");
					if(scoreTypeList.isEmpty()){
						out.print("<tr>");
						out.print("<td colspan=\"3\">没有你要找找的数据，请先保存记录再查看！</td>");
						out.print("<tr>");
					}else {
						for (ScoreType scoreType : scoreTypeList) {
							out.print("<tr>");
							out.print("<td>"+scoreType.getSubjectid()+"</td>");
							out.print("<td>"+scoreType.getSubjectname()+"</td>");
							out.print("<td>"+scoreType.getTesttime()+"</td>");
							out.print("<td>"+scoreType.getScore()+"</td>");
							if(scoreType.getScore()>=60){
							    out.print("<td>已通过</td>");
							}else{
							    out.print("<td>未通过</td>");
							}
						    out.print("</tr>");
						}
					}
				%>
				</tbody>
			</table>
		</div>
        <div id="barcon" name="barcon"></div>
		<div id="pages">
			<nav aria-label="Page navigation">
		  <ul class="pagination" id="dividepage">
		  </ul>
		</nav>
	    </div>
	</div>
	<script type="text/javascript">
        function paginationClick(pagination_id){
            var pagenumber = $('#'+pagination_id+'').attr('pagenumber');
            var totalpage = $('#'+pagination_id+'').attr('totalpage');
            // alert('zmy通用分页测试：当前id：'+pagination_id+' , pagenumber:'+pagenumber+' , totalpage:'+totalpage);
        }
        $(function(){
            $('#pages').attr('pagenumber','1');
            $('#pages').attr('totalpage','5');
            $('#pages').attr('paginationMaxLength','3');
            paginationInit();
        });
        $('.form_datetime').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
        $('.form_date').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        $('.form_time').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
	</script>
</body>
</html>