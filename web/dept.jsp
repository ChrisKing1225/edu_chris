<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Page</title>
<style type="text/css">
table, th, td
{
    border: 1px solid black;
}
</style>
</head>
<body>

<h1>Welcome to Department Page</h1>

<table class="border:1px">
	<thead>
		<tr>
			<td>#</td>
			<td>部门名称</td>
			<td>地点</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dept">
			<tr>
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>
				<td>${dept.loc}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>