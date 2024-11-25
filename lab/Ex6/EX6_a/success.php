<?php
session_start();
if (!isset($_SESSION['user_id'])) {
    header("Location: login.html?error=unauthorized");
    exit;
}
$message = isset($_GET['message']) ? $_GET['message'] : "Operation successful!";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Success</title>
</head>
<body>
    <h1><?php echo htmlspecialchars($message); ?></h1>
    <p>Thank you for your order. You can now <a href="menu.php">go back to the menu</a> to place another order.</p>
</body>
</html>
