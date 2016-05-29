<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showDept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function choice() {
			var dept = document.getElementsByName("dept");
			for(var i=0;i<dept.length;i++){
				if(dept[i].checked) {
					window.opener.receive(dept[i].value);
					window.close();
				}
			}
		}
	</script>
  </head>
  
  <body>
    <table border="1" width="60%">
    	<tr>
    		<td>选择</td>
    		<td>部门名称</td>
    		<td>所在地</td>
    	</tr>
    	<s:iterator value="depts">
    		<tr>
    			<td>
    				<input type="radio" name="dept" value="<s:property value="deptid"/>,<s:property value="deptname"/>"/>
    			</td>
    			<td>
    				<s:property value="deptname"/>
    			</td>
    			<td>
    				<s:property value="loc"/>
    			</td>
    		</tr>
    	</s:iterator>
   		<tr>
   			<td colspan="3">
   				<input type="button" value="确定" onclick="choice()"/>
   			</td>
   		</tr>
    </table>
  </body>
</html>
