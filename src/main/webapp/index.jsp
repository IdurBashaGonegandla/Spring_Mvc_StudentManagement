<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

  <style>
       <%@ include file ="css/style.css" %>
  </style>

   <script type="text/javascript">
       <%@ include file ="javaScript/sample.js" %>
   </script>
   
<body align="center" width:100px >
  <h1 style="color:green">Welcome to Admin</h1>
 
 
     
     <form action="student">
     
          <button  name="reg" onclick="f3()" style="color: red">Register</button>
          
          <br>
          <br>
          <br>
  
          <button name="show" onclick="f1()" style="color: red"> Show All</button>
          
          <br>
          <br>
          <br>
          
          <button name="log" onclick="f2()" style="color: red"> LogOut</button>
 
      </form>

</body>
</html>
