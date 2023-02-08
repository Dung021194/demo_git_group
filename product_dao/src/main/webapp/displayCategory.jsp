
<%--
  Created by IntelliJ IDEA.
  User: DUNGHUYEN
  Date: 2/5/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category list</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>

        <c:forEach var="c" items="${categoryList}">
    <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td><a href="/products?action=deleteCategory&id=${c.id}">
            <button>Delete</button>
        </a></td>
    </tr>
        </c:forEach>
    <tr>
        <td colspan="3">
        <a href="/products" style="text-decoration: none">
            <button type="button">Back to home</button>
        </a>
        </td>
    </tr>
</table>

</body>
</html>
