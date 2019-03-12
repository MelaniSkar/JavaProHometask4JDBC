<%--
  Created by IntelliJ IDEA.
  User: olesiakostieieva
  Date: 2019-03-10
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
  <br>
    <title>Questionary</title>
  <h1>Enter user data</h1>
  <form action="/" method="POST">
    <br>
      First name: <input type="text" name="firstname"> <br>
      Last name: <input type="text" name="lastname"> <br>
      Age: <input type="number" name="age"> <br>
      Phone number <input type="text" name="phone"> <br>
      <input type="submit">
    <% if((boolean)request.getAttribute("datasent")) {%>
      <h2>User data saved</h2>
    <%}%>
  </form>

  </head>
  </body>
</html>
