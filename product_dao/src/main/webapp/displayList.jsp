<%--
  Created by IntelliJ IDEA.
  User: DUNGHUYEN
  Date: 2/4/2023
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Product</h1>
<a href="/products?action=create">Create new product</a> <br>
<a href="createCategory.jsp">Create new product Category</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="p" items="${products}">
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.quantity}</td>
        <td>${p.category.name}</td>
        <td><a href="/products?action=update&id=${p.id}">
            <button>Update</button>
        </a></td>
        <td><a href="/products?action=delete&id=${p.id}">
            <button>Delete</button>
        </a></td>
    </tr>
    </c:forEach>


</body>
</html>
