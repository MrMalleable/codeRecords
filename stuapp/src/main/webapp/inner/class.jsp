<%@ page import="java.util.List" %>
<%@ page import="cn.stuapp.entity.SubjectType" %>
<%@ page import="cn.stuapp.entity.StudentType" %>
<%@ page import="javax.security.auth.Subject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"
			+request.getServerPort()+path+"/";
%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../css/grade.css">
    <script src="../js/mypage.js"></script>
	<title>学生信息管理系统</title>
</head>
<body onload="jumpPage(1,1,2)">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-1.12.4.js" charset="UTF-8"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
   <div id="container">
    	<div id="show">
    		<img src="../images/findsm.png" alt="">
    		<span>选课系统</span>
    	</div>
	    <div id="query">
			<form action='http://localhost:8080/displayclass?method=search&username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>' class="form-inline" method="post">
			  <div class="form-group">
			    <label for="subject_id">课程编号：</label>
			    <input type="text" name="subject_id" class="form-control" id="subject_id" size="10" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="subject_name">课程名称：</label>
			    <input type="text" name="subject_name" class="form-control" id="subject_name" size="10" placeholder="">
			  </div>
			  <div class="checkbox">
			    <label>
			      <input type="checkbox" name="isFull" value="false">人数未满
			    </label>
			  </div>
			  <button type="submit" class="btn btn-info" style="margin-left: 12px">查询</button>
			</form>
	    </div>
	    <div class="table-responsive" >
			<table class="table table-hover">
				<thead>
				<tr class="info">
				  <td >课程编号</td>
				  <td >课程名称</td>
				  <td >上课时间</td>
				  <td >上课地点</td>
				  <td >课程容量</td>
				  <td >教师</td>
				  <td >操作</td>
				</tr>
				</thead>
				<tbody id="databody">
				<%--<c:choose>
					<c:when test="${not empty sessionScope.subjectTypeList}">
						<c:forEach var="subjectType" items="${sessionScope.subjectTypeList}">
					        <tr>
								<td>${subjectType.subjectid }</td>
								<td>${subjectType.subjectname}</td>
								<td>${subjectType.starttime }</td>
								<td>${subjectType.subjectplace}</td>
								<td>${subjectType.capacity}</td>
								<td>${subjectType.teacher}</td>
								<td ><input class="btn btn-success btn-sm" type="submit" value="选择" data-toggle="modal" data-target="#choose" data-backdrop="static" data-keyboard="false"></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
						</tr>
					</c:otherwise>
				</c:choose>--%>
				<!--jsp-->
				<%
					List<SubjectType> subjectTypeList=(List<SubjectType>) session.getAttribute("subjectTypeList");
					if(subjectTypeList.isEmpty()){
					    out.print("<tr>");
					    out.print("<td colspan=\"3\">没有你要找找的数据，请先保存记录再查看！</td>");
					    out.print("<tr>");
					}else {
						for (SubjectType subjectType : subjectTypeList) {
						    out.print("<tr>");
						    out.print("<td>"+subjectType.getSubjectid()+"</td>");
						    out.print("<td>"+subjectType.getSubjectname()+"</td>");
						    out.print("<td>"+subjectType.getStarttime()+"</td>");
						    out.print("<td>"+subjectType.getSubjectplace()+"</td>");
						    out.print("<td>"+subjectType.getCapacity()+"</td>");
						    out.print("<td>"+subjectType.getTeacher()+"</td>");
						    out.print("<td ><input id=\"" + subjectType.getSubjectid() + "\"name=\""+subjectType.getSubjectname()+"\" time=\"" + subjectType.getStarttime() + "\" choosenum=\"" + subjectType.getChoosen_num() + "\" capacity=\"" + subjectType.getCapacity() + "\" class=\"btn btn-success btn-sm\" type=\"button\" value=\"选择\" data-toggle=\"modal\" data-target=\"#choose\" data-backdrop=\"static\" data-keyboard=\"false\" onclick=\"changeModalInputValues(this)\"></td>\n");
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
	<!-- Modal -->
	<form action='http://localhost:8080/chooseclass?username=<%=((StudentType)session.getAttribute("studentType")).getUsername()%>' method="post">
	<div class="modal fade v-align" id="choose" tabindex="-1" role="dialog" aria-labelledby="chooseLabel">
	  <div class="modal-dialog" style="width:80%;" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h2 class="modal-title" id="chooseLabel">选课</h2>
	      </div>
	      <div class="modal-body">
	        <form class="form-inline">
			  <div class="form-group">
                  <!--为避免绑定出错，修改下面label标签的for属性和input标签的id属性 2017.7.27 21:13-->
			    <label for="subjectid">课程编号：</label>
			    <input type="text" class="form-control" name="subjectid" id="subjectid" placeholder="001324" size="8" readonly>
			  </div>
			  <div class="form-group">
			    <label for="subjectname">课程名称：</label>
			    <input type="text" class="form-control" name="subjectname" id="subjectname" placeholder="数学" size="8" readonly>
			  </div>
			  <div class="form-group">
			    <label for="starttime">上课时间：</label>
			    <input type="text" class="form-control" name="starttime" id="starttime" placeholder="2017-07-27" size="10" readonly>
			  </div>
			  <div class="form-group">
			    <label for="choosen_num">已选人数：</label>
			    <input type="text" class="form-control" name="choosen_num "id="choosen_num" placeholder="24" size="1" readonly>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">选择</button>
	      </div>
	    </div>
	  </div>
	</div>
	</form>
	<script>
		//根据每一条记录后面的选择按钮给模态框赋相应的值
		function changeModalInputValues(obj){
		    var subjectname=obj.getAttribute("name");
		    var subjectid=obj.getAttribute("id");
		    var starttime=obj.getAttribute("time");
		    var choosen_num=obj.getAttribute("choosenum");
		    var capacity=obj.getAttribute("capacity");
		    document.getElementById("subjectid").value=subjectid;
		    document.getElementById("subjectname").value=subjectname;
		    document.getElementById("starttime").value=starttime;
		    document.getElementById("choosen_num").value=choosen_num;
		    if(parsInt(choosen_num)>=parseInt(capacity)){
		        document.getElementsByClassName("btn btn-primary").disabled=true;
            }
		}
	</script>
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