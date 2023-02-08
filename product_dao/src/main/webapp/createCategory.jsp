<%--
  Created by IntelliJ IDEA.
  User: DUNGHUYEN
  Date: 2/5/2023
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Create Category</h1>
<form action="products?action=createCategory" method="post">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><input type="text" name="name" id="name"></td>
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
