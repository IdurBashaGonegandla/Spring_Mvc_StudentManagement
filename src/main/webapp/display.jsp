<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c"%>
    <%@ page import="com.palle.model.Student" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <style>
       <%@ include file ="css/style.css" %>
  </style>
<title> Display Page</title>
</head>
<body >
<div align="center" class="container" >
<h1 style="color:green" >Student List</h1>

<table border="1">
 <thead>
   <tr>
     <th>Sno</th> 
     <th>Sname</th> 
     <th>Email</th> 
     <th>Password</th> 
     <th>Mobile</th> 
     <th>Actions</th> 
   </tr>
  </thead>
  <tbody>
  <% ArrayList<Student> s = (ArrayList<Student>) request.getAttribute("student"); %>
    <%
      for(Student item :s)
      {
    %>
   
        <tr>
           <td> <c:out value="<%= item.getSno() %>"></c:out></td>
           <td> <c:out value="<%= item.getSname() %>"></c:out></td> 
           <td> <c:out value="<%= item.getEmail() %>"></c:out></td> 
           <td> <c:out value="<%= item.getPassword() %>"></c:out></td> 
           <td> <c:out value="<%= item.getMobile() %>"></c:out></td>  
           <td>
             <a href="editForm?sno=<c:out value="<%= item.getSno() %>"></c:out>">Edit</a>
             &nbsp; &nbsp;
             <a href="delete?sno=<c:out value="<%= item.getSno() %>"></c:out>" >Delete</a>
           
           </td>
        </tr>
   <%
      }
   %>     
  
      
  
  </tbody>

</table>
</br>
</br>
      
    <div >
         
         <form action="back" method="post">

            
            <button  name="btn" style="color: red">Back</button>
  
         </form>
     
    
    </div>  
       
</div>


</body>
</html>