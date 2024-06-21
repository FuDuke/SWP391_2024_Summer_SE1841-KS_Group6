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
            function doDelete(tour_name) {
                var c = confirm("Are you sure?");
                if (c) {
                    window.location.href = "Delete_One_Tour?dname=" + encodeURIComponent(tour_name);
                }
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
            }
            .containerr {
                width: 80%;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .headerr {
                background-color: #2c3e50;
                padding: 10px;
                color: #fff;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .headerr h1 {
                margin: 0;
                font-size: 24px;
            }
            .headerr button {
                background-color: #3498db;
                border: none;
                padding: 10px 20px;
                color: #fff;
                border-radius: 4px;
                cursor: pointer;
            }
            .contentt {
                display: flex;
                margin-top: 20px;
            }
            .contentt img {
                width: 300px;
                height: 200px;
                border-radius: 8px;
            }
            .detailss {
                margin-left: 20px;
                flex-grow: 1;
            }
            .detailss h2 {
                margin: 0;
                font-size: 24px;
            }
            .detailss ul {
                list-style: none;
                padding: 0;
            }
            .detailss ul li {
                display: flex;
                align-items: center;
                margin-top: 10px;
            }
            .detailss ul li i {
                font-size: 18px;
                margin-right: 10px;
                color: #3498db;
            }
            .pricee {
                font-size: 24px;
                margin-top: 10px;
                color: #e67e22;
            }
            .pricee del {
                color: #aaa;
                margin-left: 10px;
                font-size: 18px;
            }
            .descriptionn {
                margin-top: 20px;
            }
            .view-details {
                background-color: #3498db;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-top: 20px;
            }
            .buttons {
                margin-top: 20px;
            }
            .buttons button {
                background-color: #3498db;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-right: 10px;
            }
            .buttons .delete {
                background-color: #e74c3c;
            }
            .customer-info {
                margin-top: 20px;
                padding: 10px;
                background-color: #ecf0f1;
                border-radius: 8px;
            }
            h2 {
                font-size: 24px;
                color: #333;
                margin-bottom: 10px;
            }

            ul {
                list-style: none;
                padding: 0;
                margin: 0 0 20px 0;
            }

            ul li {
                display: flex;
                align-items: center;
                font-size: 16px;
                color: #555;
            }

            ul li i {
                font-size: 18px;
                margin-right: 8px;
                color: #3498db;
            }

            .pricee {
                font-size: 24px;
                color: #e67e22;
                margin-bottom: 20px;
            }

            .pricee .discount {
                font-size: 16px;
                color: #e67e22;
                margin-left: 10px;
            }

            .dates {
                font-size: 16px;
                color: #666;
                line-height: 1.5;
                margin-bottom: 20px;
            }

            .descriptionn {
                font-size: 16px;
                color: #666;
                line-height: 1.6;
                margin-bottom: 20px;
            }

            .location {
                font-size: 16px;
                color: #666;
                margin-bottom: 20px;
            }

            .customer-info {
                padding: 10px;
                background-color: #ecf0f1;
                border-radius: 8px;
                font-size: 16px;
                color: #333;
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
                                <li class="current"><a href="List_Tour_Admin">ADMIN</a></li>
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
            <div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
            <div class="container_12">
                <div class="banners">
                    <div class="containerr">
                        <div class="contentt">
                            <img src="images/${in.image}" alt="Trishuli River Rafting">
                            <div class="detailss">
                                <h2>${in.tour_name}</h2>
                                <ul>
                                    <li><i class="fa fa-clock-o"></i>${in.number_day} days</li>
                                </ul>
                                <div class="pricee">
                                    Price: ${in.total_price}
                                    <span class="discount">24% Off</span>
                                </div>
                                <div class="dates">
                                    Start date: ${in.start_date} <br>
                                    End date: ${in.end_date} <br>
                                    Min child: ${in.min_child} <br>
                                    Max child: ${in.max_child}<br>
                                    Min adult: ${in.min_adult}<br>
                                    Max adult: ${in.max_adult}<br>
                                </div>
                                <div class="descriptionn">
                                    Description: ${in.description}
                                </div>
                                <div class="location">
                                    Location: ${roleMap[in.tour_catetgory_id]}
                                </div>
                                <div class="customer-info">
                                    <p>Tên khách hàng: <c:out value="${customer.name}"/></p>
                                    <p id="depositInfo"></p>
                                </div>

                                <div class="buttons">
                                    <button class="update">
                                        <a href="Update_One_Tour?tname=${in.tour_name}">Update</a>
                                    </button>
                                    <button class="delete">
                                        <a href="#" onclick="doDelete('${in.tour_name}')">DELETE</a>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
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
            });
        </script>
    </body>
</html>
