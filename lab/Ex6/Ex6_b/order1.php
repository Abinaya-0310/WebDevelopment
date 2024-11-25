<?php
session_start();

$selectedItems = $_POST['selected_items'] ?? [];
$quantities = $_POST['quantity'] ?? [];

$menuXML = simplexml_load_file('menu.xml') or die("Error: Cannot load menu.xml");

$total = 0;
$orderDetails = [];
foreach ($menuXML->item as $item) {
    $name = (string) $item->name;
    $price = (float) $item->price; // Ensure proper type casting to float

    if (in_array($name, $selectedItems) && isset($quantities[$name]) && $quantities[$name] > 0) {
        $quantity = (int) $quantities[$name];
        $subtotal = $quantity * $price; // Calculate subtotal
        $total += $subtotal; // Add to total
        $orderDetails[] = "$name x $quantity = ₹$subtotal";
    }
}

if (empty($orderDetails)) {
    header("Location: menu1.php?error=No items selected or quantity not specified.");
    exit;
}
$_SESSION['order_details'] = $orderDetails;
$_SESSION['total'] = $total;
header("Location: confirmation.php");
exit;
?>
