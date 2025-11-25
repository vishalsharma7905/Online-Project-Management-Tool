<%@ page import="com.projectmanagement.dao.ProjectDAO,com.projectmanagement.model.Project,java.util.List" %>
<%
  Object user = session.getAttribute("user");
  if (user == null) { response.sendRedirect(request.getContextPath()+"/login.jsp"); return; }
  ProjectDAO dao = new ProjectDAO();
  List<Project> projects = dao.findAll();
%>
<html><body>
  <h2>Admin Dashboard</h2>
  <a href="<%=request.getContextPath()%>/login.jsp">Logout</a>
  <h3>Create Project</h3>
  <form method="post" action="<%=request.getContextPath()%>/project">
    <input type="hidden" name="action" value="create"/>
    <input name="title" placeholder="Title"/><br/>
    <input name="start_date" placeholder="YYYY-MM-DD"/><input name="end_date" placeholder="YYYY-MM-DD"/><br/>
    <textarea name="description" placeholder="Description"></textarea><br/>
    <button>Create</button>
  </form>

  <h3>Projects</h3>
  <% for(Project p: projects){ %>
    <div style="border:1px solid #ccc;margin:8px;padding:8px">
      <h4><%=p.getTitle()%> (ID: <%=p.getId()%>)</h4>
      <p><%=p.getDescription()%></p>
      <form method="post" action="<%=request.getContextPath()%>/project">
        <input type="hidden" name="action" value="rename"/>
        <input type="hidden" name="id" value="<%=p.getId()%>"/>
        <input name="title" value="<%=p.getTitle()%>"/>
        <button>Rename</button>
      </form>
    </div>
  <% } %>
</body></html>
