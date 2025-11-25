<%@ page import="com.projectmanagement.dao.ProjectDAO,com.projectmanagement.model.Project,java.util.List" %>
<%
  Object user = session.getAttribute("user");
  if (user == null) { response.sendRedirect(request.getContextPath()+"/login.jsp"); return; }
  ProjectDAO dao = new ProjectDAO();
  List<Project> projects = dao.findAll();
%>
<html><body>
  <h2>Team Member Dashboard</h2>
  <a href="<%=request.getContextPath()%>/login.jsp">Logout</a>
  <h3>Projects / Tasks</h3>
  <% for(Project p: projects){ %>
    <div style="border:1px solid #ccc;margin:8px;padding:8px">
      <h4><%=p.getTitle()%></h4>
      <p><%=p.getDescription()%></p>
    </div>
  <% } %>
</body></html>
