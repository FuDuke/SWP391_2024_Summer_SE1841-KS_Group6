<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                // Calculate holiday price when daily price is entered
                $('#daily_price').on('input', function () {
                    calculateHolidayPrice();
                });

                function calculateHolidayPrice() {
                    var dailyPrice = parseFloat($('#daily_price').val());
                    if (!isNaN(dailyPrice) && dailyPrice > 100) {
                        $('#holiday_price').val((dailyPrice * 0.3).toFixed(2));
                    } else {
                        $('#holiday_price').val('');
                    }
                }

                // Validate form on submit
                $('form[name="hotelForm"]').submit(function () {
                    return validateForm();
                });

                function validateForm() {
                    // Service Category ID validation
                    var serviceCategoryId = document.forms["hotelForm"]["service_category_id"].value;
                    if (serviceCategoryId !== "1") {
                        alert("Service Category ID must be '1 - is Hotel'");
                        return false;
                    }

                    // Daily Price and Holiday Price validation
                    var dailyPrice = parseFloat(document.forms["hotelForm"]["daily_price"].value);
                    var holidayPrice = parseFloat(document.forms["hotelForm"]["holiday_price"].value);
                    if (isNaN(dailyPrice) || dailyPrice <= 100 || dailyPrice < 0) {
                        alert("Daily Price must be a number greater than 100 and not negative.");
                        return false;
                    }
                    if (isNaN(holidayPrice) || holidayPrice !== dailyPrice * 0.3) {
                        alert("Holiday Price must be 30% of Daily Price.");
                        return false;
                    }

                    // Number of Rooms validation
                    var numRooms = parseInt(document.forms["hotelForm"]["number_room"].value);
                    if (isNaN(numRooms) || numRooms <= 0) {
                        alert("Number of Rooms must be a number greater than 0.");
                        return false;
                    }

                    // Number of People validation
                    var numPeople = parseInt(document.forms["hotelForm"]["number_people"].value);
                    if (isNaN(numPeople) || (numPeople !== 2 && numPeople !== 3)) {
                        alert("Number of People must be either 2 or 3.");
                        return false;
                    }

                    // Phone validation
                    var phone = document.forms["hotelForm"]["phone"].value;
                    var phonePattern = /^\d{4}-\d{4}$/;
                    if (!phone.match(phonePattern) || phone.length > 10) {
                        alert("Phone number must be in the format XXXX-YYYY (e.g., 1234-5678) and cannot exceed 10 digits.");
                        return false;
                    }

                    return true;
                }



                // Auto-format phone number input
                $('#phone').on('input', function () {
                    var phoneNumber = $(this).val().replace(/\D/g, ''); // Remove non-numeric characters
                    if (phoneNumber.length >= 4) {
                        phoneNumber = phoneNumber.substring(0, 4) + '-' + phoneNumber.substring(4, 8);
                    }
                    if (phoneNumber.length > 9) {
                        phoneNumber = phoneNumber.substring(0, 9); // Limit to 9 characters (XXXX-YYYY)
                    }
                    $(this).val(phoneNumber);
                });
            });
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
                <form name="hotelForm" action="Add_One_Hotel" method="get" onsubmit="return validateForm()">
                    <table>
                        <tr>
                            <td>Hotel Name:</td>
                            <td><input type="text" name="hotel_name" required></td>
                        </tr>
                        <tr>
                            <td>Service Category ID:</td>
                            <td>
                                <select name="service_category_id" required>
                                    <option value="">Select</option>
                                    <option value="1">1 - is Hotel</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Daily Price:</td>
                            <td><input type="text" id="daily_price" name="daily_price" required></td>
                        </tr>
                        <tr>
                            <td>Holiday Price:</td>
                            <td><input type="text" id="holiday_price" name="holiday_price" readonly></td>
                        </tr>
                        <tr>
                            <td>Number of Rooms:</td>
                            <td><input type="number" name="number_room" min="1" required></td>
                        </tr>
                        <tr>
                            <td>Number of People:</td>
                            <td>
                                <select name="number_people" required>
                                    <option value="">Have to choice</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="description" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Phone:</td>
                            <td><input type="text" name="phone" pattern="\d{4}-\d{4}" required title="Phone number must be in the format XXXX-YYYY (e.g., 1234-5678)"></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="buttons"><input type="submit" value="Add Hotel"></td>
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
