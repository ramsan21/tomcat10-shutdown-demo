<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        .info {
            margin-top: 20px;
            padding: 10px;
            background-color: #e9f7fe;
            border-left: 4px solid #0099ff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Tomcat 10 Demo</h1>

        <p>This is a simple JSP page running on Tomcat 10 with Jakarta EE.</p>

        <div class="info">
            <p><strong>Server Time:</strong> <%= new java.util.Date() %></p>
            <p><strong>Session ID:</strong> <%= session.getId() %></p>
        </div>

        <h2>Sample Form</h2>
        <form action="<c:url value='/submit'/>" method="post">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name">
            </div>
            <div style="margin-top: 10px;">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email">
            </div>
            <div style="margin-top: 15px;">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
</body>
</html>