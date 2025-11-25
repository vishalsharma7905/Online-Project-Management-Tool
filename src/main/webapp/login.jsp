<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
  <h2>Login</h2>
  <form method="post" action="${pageContext.request.contextPath}/login">
    <input name="email" placeholder="Email" /><br/>
    <input name="password" type="password" placeholder="Password" /><br/>
    <button type="submit">Sign In</button>
  </form>
  <div style="color:red">${requestScope.error}</div>
</body>
</html>
