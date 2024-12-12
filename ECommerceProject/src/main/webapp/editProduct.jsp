
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <h2>Edit Product</h2>
    <form action="updateProduct" method="POST">
        <input type="hidden" name="id" value="${product.id}">
        <label>Name: </label><input type="text" name="name" value="${product.name}" required><br>
        <label>Price: </label><input type="number" name="price" value="${product.price}" required><br>
        <label>Description: </label><input type="text" name="description" value="${product.description}" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
