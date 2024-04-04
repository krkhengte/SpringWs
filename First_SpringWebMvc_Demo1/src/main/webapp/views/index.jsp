<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
  <div class="form-container">
            <h1>LOGIN</h1>
            <form action="LoginForm" method="post">
               <label for="username">Username</label>
               <input type="text" id="username" name="username" placeholder="Enter your username" required>
               <label for="password">Password</label>
               <input type="password" id="password" name="password" placeholder="Enter your password" required>

               <button type="submit" onclick="validate()">Login </button><br>
               <a href="ForgotPass.html" style="color: blue;">Forgot Password</a>
               <a href="ForgotUser.html" style="color: blue;">Forgot Username</a>
               <a href="Registration.html" style="color: blue;">Register Here</a>
              <!--  <a href="home.html">Home</a> -->
               
            </form>
         </div>   
</body>
</html>