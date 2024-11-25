<?php
session_start();
$orderDetails = $_SESSION['order_details'] ?? [];
$total = $_SESSION['total'] ?? 0;
session_unset();
session_destroy();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family:'Times New Roman', Times, serif;
            margin: 0;
            padding: 0;
            background-color: #d692e4;
            color: black;
        }

        h1 {
            text-align: center;
            margin: 20px 0;
            color: black;
        }

        .container {
            width: 25%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            align-items:center;
        }

        ul {
            padding-left: 20px;
        }

        ul li {
            margin-bottom: 5px;
            color: #555;
        }

        .total {
            font-size: 1.2em;
            color: #333;
            margin-top: 20px;
        }

        a {
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background-color: #4CAF50;
            padding: 10px 15px;
            border-radius: 5px;
            margin-top: 20px;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Order Confirmation</h1>
    <?php if (!empty($orderDetails)): ?>
    <div class="container">
        <h2>Your Order:</h2>
        <ul>
            <?php foreach ($orderDetails as $detail): ?>
                <li><?php echo $detail; ?></li>
            <?php endforeach; ?>
        </ul>
        <h3>Total: ₹<?php echo $total; ?></h3>
        <p>Thank you for your order!</p>
    <?php else: ?>
        <p>No order details found.</p>
    <?php endif; ?>
    <a href="menu1.php">Back to Menu</a>
    </div>
</body>
</html>
