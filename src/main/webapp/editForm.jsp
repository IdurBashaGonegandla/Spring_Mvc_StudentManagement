<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.palle.model.Student" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
 <style>
       <%@ include file ="css/style.css" %>
  </style>
<body >
   <% Student s=(Student)request.getAttribute("student"); %>
 <form action ="edit" method="post">
    <h1 style="color:green" >Edit Page</h1>
    <table >
    
    <tr>
   <td> </td>
   <td><input type="text" value="<%=s.getSno() %>" name="tbSno" placeholder="Enter Your Name" hidden="hidden" requied></td>
   </tr>
    
   <tr>
   <td>Name </td>
   <td><input type="text" value="<%=s.getSname() %>" name="tbName" placeholder="Enter Your Name"  requied></td>
   </tr>
   <tr>
   <td>Email</td>
   <td><input type="email" value="<%=s.getEmail() %>" name="tbEmail" placeholder="Enter Your Email" requied ></td>
   </tr>
   <tr>
   <td>Password</td>
   <td><input type="Password"  value="<%=s.getPassword() %>" name="tbPass" placeholder="Enter Your Password" requied></td>
   </tr>
   <tr>
   <td>Mobile</td>
   <td> <input type="tel" value="<%=s.getMobile() %>" name="tbMobile" placeholder="Enter Your MobileNo" requied></td>
   </tr>
    
   <tr>
   <td></td>
   <td> <input type="submit" name="submitbtn" value ="Save" ></td>
   </tr>
   </table>
 
 
 
 </form>

</body>
</html>