<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pageQueryEmp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT type="text/javascript">
		function goPage(pagenum) {
			document.getElementById("page.pagenum").value = pagenum;
			document.getElementById("myform").submit();
		}
	</SCRIPT>
  </head>
  
  <body>
  	<s:form action="employee!pageQuery.action" method="post" theme="simple" id="myform">
  		<s:hidden name="page.pagesize" value="5"></s:hidden>
  		<s:hidden name="page.pagenum" id="page.pagenum"></s:hidden>
  		<table border="1" width="60%">
  			<tr>
  				<td>员工姓名</td>
  				<td>
  					<s:textfield name="employee.empname"></s:textfield>
  				</td>
  				<td>所属部门</td>
  				<td>
  					<s:textfield name="employee.dept.deptname"></s:textfield>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<s:submit value="查询"></s:submit>
  				</td>
  			</tr>
  		</table>
  	
    <table border="1" width="60%">
    	<tr>
    		<td>员工姓名</td>
    		<td>员工工资</td>
    		<td>所属部门</td>
    		<td>操作</td>
    	</tr>
    	<s:if test="page.data!=null && page.data.size()!=0">
    		<s:iterator value="page.data">
    			<tr>
    				<td>
    					<s:property value="empname"/>
    				</td>
    				<td>
    					<s:property value="sal"/>
    				</td>
    				<td>
    					<s:property value="dept.deptname"/>
    				</td>
    				<td>
    					<a href="employee!preUpdate.action?employee.empid=<s:property value="empid"/>">修改</a>
    					<a href="employee!delete.action?employee.empid=<s:property value="empid"/>">删除</a>
    					<a href="employee!view.action?employee.empid=<s:property value="empid"/>">查看</a>
    				</td>
    			</tr>
    		</s:iterator>
    	</s:if>
    	<s:else>
    		<tr>
    			<td colspan="4">查不到数据</td>
    		</tr>
    	</s:else>
    	<tr>
    		<td colspan="4">
    			共有条<s:property value="page.recordcount"/>记录，
    			每页显示<s:property value="page.pagesize"/>条，
    			当前在第<s:property value="page.pagenum"/>页
    			<s:if test="page.pagenum!=1">
    				<a href="javascript: goPage(1);">首页</a>
    				<a href="javascript: goPage('<s:property value="page.pagenum-1"/>');">上一页</a>
    			</s:if>
    			<s:if test="page.pagenum!=page.pagecount">
    				<a href="javascript: goPage('<s:property value="page.pagecount"/>');">尾页</a>
    				<a href="javascript: goPage('<s:property value="page.pagenum+1"/>');">下一页</a>
    			</s:if>
    		</td>
    	</tr>
    </table>
    <a href="inserOrUpdate.jsp">增加员工</a>
    </s:form>
  </body>
</html>

