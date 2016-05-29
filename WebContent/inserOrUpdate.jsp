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
    
    <title>My JSP 'inserOrUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT type="text/javascript">
		function chodept() {
			window.open('dept!queryAll.action','','width=400;height=50')
		}
		
		function receive(depts) {
			var s = depts.split(",");
			document.getElementById("employee.dept.deptid").value = s[0];
			document.getElementById("employee.dept.deptname").value = s[1];
		}
	</SCRIPT>
  </head>
  
  <body>
    <s:form action="employee!inserOrUpdate.action" method="post" theme="simple">
    	<s:hidden name="employee.dept.deptid" id="employee.dept.deptid"></s:hidden>
    	<s:hidden name="employee.empid"></s:hidden>
    	员工姓名：<s:textfield name="employee.empname"></s:textfield><br/>
    	员工工资：<s:textfield name="employee.sal"></s:textfield><br/>
    	所在部门：<s:textfield name="employee.dept.deptname" id="employee.dept.deptname"></s:textfield>
    	<input type="button" value="选择部门" onclick="chodept()"/><br/>
    	<s:submit value="确定"></s:submit>
    </s:form>
  </body>
</html>
