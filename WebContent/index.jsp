<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <!-- JS Imports Start -->
      <script type="text/javascript"
         src="resources/jslib/jquery-1.11.3.min.js"></script>
      <script type="text/javascript" src="resources/jslib/angular.js"></script>
      <script type="text/javascript" src="resources/jslib/angular.min.js"></script>
      <script type="text/javascript" src="resources/jslib/angular-resource.js"></script>
      <script type="text/javascript"
         src="resources/jslib/angular-resource.min.js"></script>
      <script type="text/javascript"
         src="resources/bootstrap/js/bootstrap.min.js"></script>
      <!-- JS Imports End
         <!-- Style sheet imports start-->
      <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
      <link rel="icon" type="image/png" href="images/logo.png">
      <!-- Style sheet imports end -->
      <title>Search Coder</title>
   </head>
   <body>
      <div class="container">
      <h1>Welcome To JDA Full Stack Developer</h1>
      <p>Using this Application you can access APIs
      </p>
      <blockquote>
         <ul>
            <li><a style="cursor: pointer;" hrf="#"
               onclick="window.open('http://localhost:8080/searchCoder/jda/coder/list?pageNumber=1&pageSize=10')">
               		http://localhost:8080/searchCoder/jda/coder/list?pageNumber=1&pageSize=10
               </a>
            </li>
            <li><a style="cursor: pointer;" hrf="#"
               onclick="window.open('http://localhost:8080/searchCoder/jda/coder/search?name=title&value=574A - Bear and Elections&pageNumber=1&pageSize=10')">
               http://localhost:8080/searchCoder/jda/coder/search?name=title&value=574A - Bear and Elections&pageNumber=1&pageSize=10</a>
            </li>
            <li><a style="cursor: pointer;" hrf="#"
               onclick="window.open('http://localhost:8080/searchCoder/jda/coder/submissions')">
               http://localhost:8080/searchCoder/jda/coder/submissions</a>
            </li>
         </ul>
      </blockquote>
   </body>
</html>

