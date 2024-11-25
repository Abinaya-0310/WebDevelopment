<?php
$menuXML = simplexml_load_file('menu.xml') or die("Error: Cannot load menu.xml");
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
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
            color:black;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .menu-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .menu-item:last-child {
            border-bottom: none;
        }

        .menu-item h3 {
            margin: 0;
            color: #333;
        }

        .menu-item p {
            margin: 5px 0;
            color: #666;
        }

        input[type="number"], input[type="checkbox"] {
            width: 50px;
            padding: 5px;
            font-size: 14px;
            margin-right: 10px;
        }

        button {
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 15px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
            align-items:center;
        }

        button:hover {
            background-color: #45a049;
        }

        .error-message {
            text-align: center;
            color: red;
            font-weight: bold;
            margin: 10px 0;
        }
    </style>


</head>
<body>
    <h1>Restaurant Menu</h1>
    <?php if (isset($_GET['error'])): ?>
        <p style="color: red;"><?php echo htmlspecialchars($_GET['error']); ?></p>
    <?php endif; ?>

    <form method="post" action="order1.php">
        <?php foreach ($menuXML->item as $item): ?>
            <div>
                <label>
                    <input type="checkbox" name="selected_items[]" value="<?php echo $item->name; ?>"> 
                    <strong><?php echo $item->name; ?> - ₹<?php echo $item->price; ?></strong>
                </label>
                <p><?php echo $item->description; ?></p>
                <label>
                    Quantity: 
                    <input type="number" name="quantity[<?php echo $item->name; ?>]" min="0" value="0">
                </label>
            </div>
            <hr>
        <?php endforeach; ?>
        <button type="submit">Place Order</button>
    </form>
</body>
</html>
