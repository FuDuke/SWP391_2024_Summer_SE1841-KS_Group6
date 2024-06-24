<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ADD HOTEL</title>
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

                // Automatically calculate holiday price when daily price is entered
                document.getElementById('daily_price').addEventListener('input', function () {
                    const dailyPrice = parseFloat(this.value);
                    if (!isNaN(dailyPrice) && dailyPrice > 100) {
                        document.getElementById('holiday_price').value = (dailyPrice * 0.3).toFixed(2);
                    } else {
                        document.getElementById('holiday_price').value = '';
                    }
                });
            });

            function validateForm() {
                // Service Category ID validation
                const serviceCategory = document.getElementById('service_category_id').value;
                if (serviceCategory !== '1') {
                    alert("Please select a valid service category (Hotel).");
                    return false;
                }

                // Description validation
                const description = document.forms["hotelForm"]["description"].value;
                if (description.split(' ').length < 10) {
                    alert("Description must be greater than 10 words.");
                    return false;
                }

                // Daily Price validation
                const dailyPrice = document.forms["hotelForm"]["daily_price"].value;
                if (isNaN(dailyPrice) || dailyPrice <= 100) {
                    alert("Daily Price must be a number greater than 100.");
                    return false;
                }

                // Number of Rooms validation
                const numberRoom = document.forms["hotelForm"]["number_room"].value;
                if (isNaN(numberRoom) || numberRoom < 20 || numberRoom > 50) {
                    alert("Number of Rooms must be a number between 20 and 50.");
                    return false;
                }

                // Number of People validation
                const numberPeople = document.forms["hotelForm"]["number_people"].value;
                if (numberPeople !== '2' && numberPeople !== '3') {
                    alert("Number of People must be 2 or 3.");
                    return false;
                }

                // Phone validation
                const phone = document.forms["hotelForm"]["phone"].value;
                const phonePattern = /^(\d{4})-?(\d{3})-?(\d{3})$/;
                if (!phonePattern.test(phone)) {
                    alert("Phone must be a valid phone number with 10 or 11 digits and formatted with dashes.");
                    return false;
                }

                return true;
            }

            function formatPhoneNumber(event) {
                let input = event.target.value.replace(/\D/g, '');
                if (input.length > 4) {
                    input = input.replace(/(\d{4})(\d+)/, '$1-$2');
                }
                if (input.length > 8) {
                    input = input.replace(/(\d{4})-(\d{3})(\d+)/, '$1-$2-$3');
                }
                event.target.value = input;
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
                                <li><a href="/admin/admin.jsp">ADMIN</a></li>
                                <li class="current"><a href="Travel Agent.jsp">Travel Agent</a></li>
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
            <h1>Hotel new for Travel Agent</h1>
            <div class="content">
                <form name="hotelForm" action="Update_One_Hotel" method="post" onsubmit="return validateForm()">
                    <table>
                        <tr>
                            <td>Hotel Name:</td>
                            <td><input type="text" value="${update.hotel_name}" name="hotel_name" required></td>
                        </tr>
                        <tr>
                            <td>Service Category ID:</td>
                            <td>
                                <select name="service_category_id"  id="service_category_id" required>
                                    <option value="1">Hotel</option>
                                </select>
                            </td
                        </tr>
                        <tr>
                            <td>Daily Price:</td>
                            <td><input type="text" value="${update.daily_price}" name="daily_price" id="daily_price" required></td>
                        </tr>
                        <tr>
                            <td>Holiday Price:</td>
                            <td><input type="text" value="${update.holiday_price}" name="holiday_price" id="holiday_price" readonly></td>
                        </tr>
                        <tr>
                            <td>Number of Rooms:</td>
                            <td><input type="text" value="${update.number_room}" name="number_room" required></td>
                        </tr>
                        <tr>
                            <td>Number of People:</td>
                            <td>
                                <select name="number_people" value="${update.number_people}" id="number_people" required>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="description" value="${update.description}" rows="5" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Phone:</td>
                            <td><input type="text" value="${update.phone}" name="phone" id="phone" oninput="formatPhoneNumber(event)" required></td>
                        </tr>
                        <tr>
                            <td>Image:</td>
                            <td><input type="file" name="image" id="image" required></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="buttons"><input type="submit" value="Update"></td>
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
