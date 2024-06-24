<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h2 {
            font-size: 2em;
            margin-bottom: 20px;
            animation: fadeIn 2s ease-in-out;
        }
        a {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            animation: fadeIn 3s ease-in-out;
        }
        a:hover {
            background-color: #2980b9;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>${message}</h2>
        <a href="List_Restaurant_TravelAgent">Add Another Hotel</a>
    </div>
</body>
</html>
