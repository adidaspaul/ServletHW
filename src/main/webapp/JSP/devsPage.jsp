<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html lang="en">

        <head>
        <title>Developers Page</title>
        <c:import url="${path}header.jsp" />
        </head>

        <body>

                    <header>
                             <div class="container">
                                   <img src="${path}/img/logo.png" alt="logo" class="logo">
                                   <nav class="devstabs">
                                       <ul>
                                           <li><a href="/home">Home</a></li>
                                           <li><a href="/findDeveloperByIdForm">Find Developer by Id</a></li>
                                           <li><a href="/findDeveloperByNameForm">Find Developer by Name</a></li>
                                           <li><a href="/addDeveloperForm">Add Developer to DB</a></li>
                                           <li><a href="/updateDeveloperForm">Update Developer Info</a></li>
                                           <li><a href="/removeDeveloperForm">Remove Developer from DB</a></li>
                                           <li><a href="/showAllDeveloperInfo">Show All Developers Info</a></li>
                                       </ul>
                                   </nav>
                               </div>
                    </header>




        <c:import url="${path}bodyFooter.jsp" />
        </body>

        </html>