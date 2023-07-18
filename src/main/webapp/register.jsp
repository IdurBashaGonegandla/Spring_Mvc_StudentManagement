<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
 <style>
       <%@ include file ="css/style.css" %>
  </style>
<body >
   <h1 style="color:green">Welcome to Registration</h1>
   
  <form action="insert" method="post" >
   <table>
   <tr>
   <td>Name </td>
   <td><input type="text" name="tbName" placeholder="Enter Your Name"  required></td>
   </tr>
   <tr>
   <td>Email</td>
   <td><input type="email" name="tbEmail" placeholder="Enter Your Email" required ></td>
   </tr>
   <tr>
   <td>Password</td>
   <td><input type="Password" name="tbPass" placeholder="Enter Your Password" required></td>
   </tr>
   <tr>
   <td>Mobile</td>
   <td> <input type="tel" name="tbMobile" placeholder="Enter Your MobileNo" required></td>
   </tr>
    
   <tr>
   <td></td>
   <td> <input type="submit" name="submitbtn" value ="Save" ></td>
   </tr>
   </table>
   </form>
  
   

</body>
</html>