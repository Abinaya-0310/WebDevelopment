<?php
session_start();

if (!isset($_SESSION['user_id'])) {
    header("Location: login.html?error=unauthorized");
    exit;
}

require 'db.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <style>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to bottom right, #b87333, #4e2a47);

            color: white;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
        .container {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 15px;
            width: 80%;
            max-width: 1200px;
        }
        h1, h2 {
            color: #f4f4f4;
            font-size: 2.5em;
            margin-bottom: 15px;
        }

        h3 {
            font-size: 1.8em;
            margin: 10px 0;
        }

        /* Alert Messages */
        .alert {
            padding: 15px;
            margin: 20px 0;
            border-radius: 5px;
        }

        .alert.success {
            background-color: #4caf50;
        }

        .alert.error {
            background-color: #f44336;
        }
        .menu-item {
            background-color: rgba(0, 0, 0, 0.7);
            margin: 20px 0;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
        }

        .menu-item h3 {
            color: #f4f4f4;
            margin-bottom: 10px;
        }

        .menu-item p {
            color: #d3d3d3;
            font-size: 1.2em;
            margin-bottom: 15px;
        }
        button {
            padding: 10px 20px;
            background-color: #f4a300;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #e68900;
        }
        @media (max-width: 768px) {
            .container {
                width: 90%;
            }

            h1, h2 {
                font-size: 2em;
            }

            h3 {
                font-size: 1.5em;
            }

            .menu-item {
                margin: 10px 0;
                padding: 15px;
            }

            button {
                font-size: 1em;
                padding: 8px 16px;
            }
        }
    </style>

</head>
<body>
<?php if (isset($_GET['message'])): ?>
        <div class="alert success">
            <?php echo htmlspecialchars($_GET['message']); ?>
        </div>
    <?php elseif (isset($_GET['error'])): ?>
        <div class="alert error">
            <?php echo htmlspecialchars($_GET['error']); ?>
        </div>
    <?php endif; ?>
    <h1>Welcome, <?php echo htmlspecialchars($_SESSION['name']); ?>!</h1>
    <h2>Restaurant Menu</h2>

    <div class="menu-item">
        <h3>Margherita Pizza - ₹1200</h3>
        <p>Delicious pizza with tomato, cheese, and basil.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1"> <!-- This should be dynamically set after login -->
            <input type="hidden" name="order_details" value="1x Margherita Pizza">
            <input type="hidden" name="total_price" value="1200">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Chicken Biryani -->
    <div class="menu-item">
        <h3>Chicken Biryani - ₹800</h3>
        <p>Spicy and flavorful biryani with chicken pieces.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Chicken Biryani">
            <input type="hidden" name="total_price" value="800">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Caesar Salad -->
    <div class="menu-item">
        <h3>Caesar Salad - ₹350</h3>
        <p>Fresh salad with crisp lettuce, creamy dressing, and croutons.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Caesar Salad">
            <input type="hidden" name="total_price" value="350">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Chocolate Lava Cake -->
    <div class="menu-item">
        <h3>Chocolate Lava Cake - ₹450</h3>
        <p>Warm chocolate cake with a gooey molten center.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Chocolate Lava Cake">
            <input type="hidden" name="total_price" value="450">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Cold Coffee -->
    <div class="menu-item">
        <h3>Cold Coffee - ₹150</h3>
        <p>Chilled coffee with ice cream and a refreshing taste.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Cold Coffee">
            <input type="hidden" name="total_price" value="150">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Vegetable Burger -->
    <div class="menu-item">
        <h3>Vegetable Burger - ₹200</h3>
        <p>Delicious burger with a vegetable patty and fresh veggies.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Vegetable Burger">
            <input type="hidden" name="total_price" value="200">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- French Fries -->
    <div class="menu-item">
        <h3>French Fries - ₹180</h3>
        <p>Crispy and golden fries, perfect for a snack.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x French Fries">
            <input type="hidden" name="total_price" value="180">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Paneer Tikka -->
    <div class="menu-item">
        <h3>Paneer Tikka - ₹350</h3>
        <p>Grilled cottage cheese marinated in spices and served with chutney.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Paneer Tikka">
            <input type="hidden" name="total_price" value="350">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Spaghetti Carbonara -->
    <div class="menu-item">
        <h3>Spaghetti Carbonara - ₹650</h3>
        <p>Classic Italian pasta with creamy sauce and crispy bacon.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Spaghetti Carbonara">
            <input type="hidden" name="total_price" value="650">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Veggie Pizza -->
    <div class="menu-item">
        <h3>Veggie Pizza - ₹1100</h3>
        <p>Pizza topped with a variety of fresh vegetables.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Veggie Pizza">
            <input type="hidden" name="total_price" value="1100">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Garlic Bread -->
    <div class="menu-item">
        <h3>Garlic Bread - ₹180</h3>
        <p>Toasted bread with garlic butter and herbs.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Garlic Bread">
            <input type="hidden" name="total_price" value="180">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Butter Chicken -->
    <div class="menu-item">
        <h3>Butter Chicken - ₹900</h3>
        <p>Rich and creamy chicken curry served with naan.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Butter Chicken">
            <input type="hidden" name="total_price" value="900">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Veg Pulao -->
    <div class="menu-item">
        <h3>Veg Pulao - ₹550</h3>
        <p>Aromatic rice with mixed vegetables and mild spices.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Veg Pulao">
            <input type="hidden" name="total_price" value="550">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Fish Curry -->
    <div class="menu-item">
        <h3>Fish Curry - ₹700</h3>
        <p>Spicy fish curry made with fresh catch and aromatic spices.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Fish Curry">
            <input type="hidden" name="total_price" value="700">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Mango Lassi -->
    <div class="menu-item">
        <h3>Mango Lassi - ₹120</h3>
        <p>Refreshing yogurt-based drink with mango flavor.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Mango Lassi">
            <input type="hidden" name="total_price" value="120">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Prawn Masala -->
    <div class="menu-item">
        <h3>Prawn Masala - ₹950</h3>
        <p>Spicy prawn curry cooked with fresh spices and herbs.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Prawn Masala">
            <input type="hidden" name="total_price" value="950">
            <button type="submit">Order Now</button>
        </form>
    </div>

    <!-- Veg Hakka Noodles -->
    <div class="menu-item">
        <h3>Veg Hakka Noodles - ₹400</h3>
        <p>Stir-fried noodles with vegetables and Chinese spices.</p>
        <form action="order.php" method="POST">
            <input type="hidden" name="user_id" value="1">
            <input type="hidden" name="order_details" value="1x Veg Hakka Noodles">
            <input type="hidden" name="total_price" value="400">
            <button type="submit">Order Now</button>
        </form>
    </div>

</body>
</html>
