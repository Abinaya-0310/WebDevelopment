<?php
session_start();
if (!isset($_SESSION['user_id'])) {
    header("Location: login.html?error=unauthorized");
    exit;
}
require 'db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    try {
        $user_id = $_POST['user_id'];
        $order_details = $_POST['order_details'];
        $total_price = $_POST['total_price'];
        $stmt = $conn->prepare("INSERT INTO orders (user_id, order_details, total_price) VALUES (:user_id, :order_details, :total_price)");
        $stmt->bindParam(':user_id', $user_id, PDO::PARAM_INT);
        $stmt->bindParam(':order_details', $order_details, PDO::PARAM_STR);
        $stmt->bindParam(':total_price', $total_price, PDO::PARAM_INT);
        if ($stmt->execute()) {
            header("Location: success.php?message=" . urlencode("Order placed successfully!"));
            exit;
        } else {
            header("Location: menu.php?error=Failed to place the order.");
            exit;
        }
    } catch (PDOException $e) {
        header("Location: menu.php?error=" . urlencode("Database error: " . $e->getMessage()));
        exit;
    }
} else {
    header("Location: menu.php?error=Invalid request.");
    exit;
}
?>
