<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
       <%@  include file ="css/style.css"%>
  </style>



<title >Admin Page</title>
</head>
<body align="center" >
   
 <form action="list" method="post">
   
 <div class ="container" >
    <h2 style="color:green" >Admin Login</h2>

      <div class="mb-3" width:100px>
       <label for="exampleFormControlInput1" class="form-label" >UserName</label>
       <input type="text" class="form-control" id="exampleFormControlInput1" name="tbUser" placeholder="Enter UserName" required>
      </div>
  <br/>
  <br/>
     <div class="mb-3">
       <label for="exampleFormControlInput1" class="form-label" >Password</label>
       <input type="password" class="form-control" id="exampleFormControlInput1" name="tbPass" placeholder="Enter Password" required>
     </div>
  
   <br/>
     <div>
      <button class="btn btn-success"> Login </button>
     </div>
</div>
</form>

</body>
</html>