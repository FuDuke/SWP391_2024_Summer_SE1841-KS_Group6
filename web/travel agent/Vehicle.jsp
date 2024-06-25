<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Hotel for Travel Agent</title>
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
            .btn-add-tour {
                display: inline-block;
                padding: 10px 20px;
                margin: 20px 0;
                background-color: #ff6f61;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
                font-weight: bold;
                text-align: center;
            }

            .btn-add-tour:hover {
                background-color: #ff3d2e;
            }

            .container_12 .banners {
                padding-top: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th, td {
                padding: 10px;
                text-align: center; /* Center align text and icons */
                border-left: 1px solid black;
                vertical-align: middle; /* Center align vertically */
            }

            th {
                background-color: #f2f2f2;
                border-top: 1px solid black;
                border-bottom: 2px solid black;
            }

            td {
                border-bottom: 1px solid black;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #e0e0e0;
            }

            tbody tr td {
                border: 1px solid black;
            }

            table, th, td {
                border-right: 1px solid black;
                table {
                    width: 100%;
                    table-layout: fixed; /* B?ng có kích th??c c? ??nh */
                    border-collapse: collapse;
                }

                th, td {
                    padding: 10px;
                    text-align: center;
                    border: 1px solid black;
                }

                th {
                    background-color: #f2f2f2;
                }

                tr:nth-child(even) {
                    background-color: #f9f9f9;
                }

                tr:hover {
                    background-color: #e0e0e0;
                }
                /* Thi?t l?p chi?u r?ng cho t?ng c?t, có th? ?i?u ch?nh d?a vào n?i dung */
                th:nth-child(1), td:nth-child(1) {
                    width: 10%;
                }
                th:nth-child(2), td:nth-child(2) {
                    width: 10%;
                }
                th:nth-child(3), td:nth-child(3) {
                    width: 10%;
                }
                th:nth-child(4), td:nth-child(4) {
                    width: 10%;
                }
                th:nth-child(5), td:nth-child(5) {
                    width: 10%;
                }
                th:nth-child(6), td:nth-child(6) {
                    width: 10%;
                }
                th:nth-child(7), td:nth-child(7) {
                    width: 15%;
                }
                th:nth-child(8), td:nth-child(8) {
                    width: 10%;
                }
                th:nth-child(9), td:nth-child(9) {
                    width: 5%;
                }
                th:nth-child(10), td:nth-child(10) {
                    width: 5%;
                }
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
                                <li><a href="List_Tour_Admin">ADMIN</a></li>
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
        <div class="content">
            <div class="container_12">
                <div class="banners">
                    <a href="AddVehicle.jsp" class="btn-add-tour">Add Vehicle</a>
                    <table class="F">
                        <thead>
                            <tr>
                                <th>Service Category ID</th>
                                <th>Vehicle type</th>
                                <th>Vehicle name</th>
                                <th>Number of seat</th>
                                <th>Phone</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="l" items="${list_vehicle}">
                                <tr>
                                    <td>${l.service_category_id}</td>
                                    <td>${l.vehicle_type}</td>
                                    <td>${l.vehicle_name}</td>
                                    <td>${l.number_seat}</td>
                                    <td>${l.phone}</td>
                                    <td><a href="#"><i class="fa-solid fa-pen-to-square" style="color: chocolate"></i></a></td>
                                    <td><a href="#"><i class="fa-solid fa-trash" style="color: chocolate"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
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
        <script>
            $(function () {
                $('#bookingForm').bookingForm({
                    ownerEmail: '#'
                });
            })
        </script>
    </body>
</html>
