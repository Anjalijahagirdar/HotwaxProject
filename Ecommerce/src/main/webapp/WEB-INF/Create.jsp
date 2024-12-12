<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
<form action="orders" method="post">
    Order Date: <input type="date" name="orderDate" required><br>
    Customer ID: <input type="number" name="customerId" required><br>
    Shipping Contact ID: <input type="number" name="shippingContactMechId" required><br>
    Billing Contact ID: <input type="number" name="billingContactMechId" required><br>
    <input type="submit" value="Create Order">
</form>
</body>
</html>