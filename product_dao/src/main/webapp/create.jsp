<%--
  Created by IntelliJ IDEA.
  User: DUNGHUYEN
  Date: 2/5/2023
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Create Product</h1>
<form action="products?action=create" method="post">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td><label for="price">Price:</label></td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity:</label></td>
            <td><input type="text" name="quantity" id="quantity"></td>
        </tr>
        <tr>
            <td><label>Category:</label></td>
            <td>
                     <select name="category">
                     <c:forEach var="c" items="${listCategory}">
                         <option value="${c.id}">${c.name}</option>
                     </c:forEach>
                     </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
                <a href="/products" style="text-decoration: none">
                    <button type="button">Back to home</button>
                </a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
