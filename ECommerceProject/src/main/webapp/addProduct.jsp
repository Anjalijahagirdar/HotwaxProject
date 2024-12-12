<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="addProduct" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br><br>
        <label for="price">Price:</label>
        <input type="number" name="price" step="0.01" required><br><br>
        <label for="description">Description:</label>
        <textarea name="description" required></textarea><br><br>
        <button type="submit">Add Product</button>
    </form>
</body>
</html>
