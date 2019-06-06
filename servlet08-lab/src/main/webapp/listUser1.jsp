<%@ page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8"%>
<%@ page import="dao.*,java.util.*,entity.*" %>
<html>
	<head>
		<style type="text/css">
			.row1{
				background-color:#fff8dc;
			}
			.row2{
				background-color:#f0f0f0;
			}
		</style>
	</head>
	<body style="font-size:30px;">
		<table width="60%" border="1" 
		cellpadding="0" cellspacing="0">
			<tr>
				<td>ID</td><td>用户名</td>
				<td>密码</td><td>邮箱</td>
			</tr>
			<%
				UserDAO dao = new UserDAO();
				List<User> users = 
						dao.findAll();
				for(int i = 0; 
						i < users.size(); i++){
					User u = users.get(i);
					%>
					<tr class="row<%=i % 2 + 1%>">
						<td><%=u.getId()%></td>
						<td><%=u.getUname()%></td>
						<td><%=u.getPwd()%></td>
						<td><%=u.getEmail()%></td>
					</tr>
					<%
				}
			%>
		</table>
	</body>
</html>
