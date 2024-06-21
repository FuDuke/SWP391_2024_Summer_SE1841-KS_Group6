<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>DETAIL AND EDIT</title>
        <meta charset="utf-8">
        <meta name="format-detection" content="telephone=no" />
        <link rel="icon" href="images/favicon.ico">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-migrate-1.2.1.js"></script>
        <script src="js/script.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/jquery.ui.totop.js"></script>
        <script src="js/jquery.equalheights.js"></script>
        <script src="js/jquery.mobilemenu.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script>
            $(document).ready(function () {
                $().UItoTop({easingType: 'easeOutQuart'});

                // Automatically calculate deposit when total price is entered
                document.getElementById('total_price').addEventListener('input', function () {
                    const totalPrice = parseFloat(this.value);
                    if (!isNaN(totalPrice)) {
                        document.getElementById('deposit').value = (totalPrice * 0.3).toFixed(2);
                    } else {
                        document.getElementById('deposit').value = '';
                    }
                });
            });

            function validateForm() {
                // Description validation
                const description = document.forms["tourForm"]["description"].value;
                if (description.length < 20) {
                    alert("Description must be at least 20 characters long.");
                    return false;
                }

                // Deposit validation
                const totalPrice = parseFloat(document.forms["tourForm"]["total_price"].value);
                const deposit = parseFloat(document.forms["tourForm"]["deposit"].value);
                if (deposit !== totalPrice * 0.3) {
                    alert("Deposit must be exactly 30% of the total price.");
                    return false;
                }

                // Date validation
                const startDate = new Date(document.forms["tourForm"]["start_date"].value);
                const endDate = new Date(document.forms["tourForm"]["end_date"].value);
                if (startDate >= endDate) {
                    alert("Start date must be earlier than end date.");
                    return false;
                }

                // Child validation
                const minChild = parseInt(document.forms["tourForm"]["min_child"].value);
                const maxChild = parseInt(document.forms["tourForm"]["max_child"].value);
                if (minChild < 1 || minChild > 5 || maxChild < 1 || maxChild > 5) {
                    alert("Min and Max child values must be between 1 and 5.");
                    return false;
                }

                // Adult validation
                const minAdult = parseInt(document.forms["tourForm"]["min_adult"].value);
                const maxAdult = parseInt(document.forms["tourForm"]["max_adult"].value);
                if (minAdult < 18 || minAdult > 60 || maxAdult < 18 || maxAdult > 60) {
                    alert("Min and Max adult values must be between 18 and 60.");
                    return false;
                }

                // Negative number validation
                const numberFields = ["deposit", "total_price", "number_day"];
                for (let field of numberFields) {
                    const value = parseFloat(document.forms["tourForm"][field].value);
                    if (value < 0) {
                        alert("Numbers cannot be negative.");
                        return false;
                    }
                }

                return true;
            }

            function validateNumberInput(event) {
                const input = event.target;
                input.value = input.value.replace(/[^0-9]/g, '');
            }
        </script>
        <!--[if lt IE 8]>
        <div style=' clear: both; text-align:center; position: relative;'>
                <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
                        <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
                </a>
        </div>
        <![endif]-->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <link rel="stylesheet" media="screen" href="css/ie.css">
        <![endif]-->

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 80%;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .header {
                background-color: #2c3e50;
                padding: 10px;
                color: #fff;
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-radius: 8px 8px 0 0;
            }
            .header h1 {
                margin: 0;
                font-size: 24px;
            }
            .header button {
                background-color: #3498db;
                border: none;
                padding: 10px 20px;
                color: #fff;
                border-radius: 4px;
                cursor: pointer;
            }
            .content {
                padding: 20px;
            }
            form {
                width: 100%;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            td {
                padding: 10px;
                vertical-align: top;
            }
            input[type="text"], input[type="date"], textarea, select {
                width: 100%;
                padding: 10px;
                margin-top: 5px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }
            textarea {
                resize: vertical;
                height: 100px;
            }
            input[type="submit"] {
                background-color: #3498db;
                border: none;
                color: #fff;
                padding: 15px 20px;
                font-size: 18px;
                cursor: pointer;
                border-radius: 4px;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #2980b9;
            }
            .buttons {
                text-align: right;
            }
        </style>

    </head>
    <body>
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="grid_12">
                    <div class="menu_block">
                        <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                            <ul class="sf-menu">
                                <li><a href="index.jsp">ABOUT</a></li>
                                <li><a href="index-1.jsp">HOT TOURS</a></li>
                                <li><a href="index-2.jsp">SPECIAL OFFERS</a></li>
                                <li><a href="index-3.jsp">BLOG</a></li>
                                <li><a href="index-4.jsp">CONTACTS</a></li>
                                <li class="current"><a href="/admin/admin.jsp">ADMIN</a></li>
                                <li><a href="Travel Agent.jsp">Travel Agent</a></li>
                            </ul>
                        </nav>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="grid_12">
                    <h1>
                        <a href="index.jsp">
                            <img src="images/logo.png" alt="Your Happy Family">
                        </a>
                    </h1>
                </div>
            </div>
        </header>
        <!--==============================Content=================================-->
        <div class="container">
            <div class="header">
                <h1>Tour Details and Edit</h1>
            </div>
            <div class="content">
                <form name="tourForm" action="Add_One_Tour" method="get" onsubmit="return validateForm()">
                    <table>
                        <tr>
                            <td>Tour Name:</td>
                            <td><input type="text" name="tour_name" required></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="description" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Total Price:</td>
                            <td><input type="text" id="total_price" oninput="validateNumberInput(event)" name="total_price" required></td>
                        </tr>
                        <tr>
                            <td>Deposit:</td>
                            <td><input type="text" id="deposit" oninput="validateNumberInput(event)" name="deposit" required></td>
                        </tr>
                        <tr>
                            <td>Start Date:</td>
                            <td><input type="date" name="start_date" required></td>
                        </tr>
                        <tr>
                            <td>End Date:</td>
                            <td><input type="date" name="end_date" required></td>
                        </tr>
                        <tr>
                            <td>Min Child:</td>
                            <td><input type="text" oninput="validateNumberInput(event)" name="min_child" required></td>
                        </tr>
                        <tr>
                            <td>Max Child:</td>
                            <td><input type="text" oninput="validateNumberInput(event)" name="max_child" required></td>
                        </tr>
                        <tr>
                            <td>Min Adult:</td>
                            <td><input type="text" oninput="validateNumberInput(event)" name="min_adult" required></td>
                        </tr>
                        <tr>
                            <td>Max Adult:</td>
                            <td><input type="text" oninput="validateNumberInput(event)" name="max_adult" required></td>
                        </tr>

                        <tr>
                            <td>Number of Days:</td>
                            <td><input type="text" oninput="validateNumberInput(event)" name="number_day" required></td>
                        </tr>
                        <tr>
                            <td>Tour Category:</td>
                            <td>
                                <select name="tour_category_id" required>
                                    <option value="1">Asia</option>
                                    <option value="2">Europe</option>
                                    <option value="3">Africa</option>
                                    <option value="4">North America</option>
                                    <option value="5">South America</option>
                                    <option value="6">Oceania</option>
                                    <option value="7">Antarctica</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Image:</td>
                            <td><input type="file" name="image" required></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="buttons"><input type="submit" value="Add Tour"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <!--==============================footer=================================-->
        <footer>
            <div class="container_12">
                <div class="grid_12">
                    <div class="socials">
                        <a href="#" class="fa fa-facebook"></a>
                        <a href="#" class="fa fa-twitter"></a>
                        <a href="#" class="fa fa-google-plus"></a>
                    </div>
                    <div class="copy">
                        Your Trip (c) 2014 | <a href="#">Privacy Policy</a> | Website Template Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
