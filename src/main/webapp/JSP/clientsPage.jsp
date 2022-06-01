<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html lang="en">

        <head>
        <title>Clients Page</title>
        <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

                    <header>
                            <c:import url="${path}headers&footer/clientsHeader.jsp" />
                    </header>
 <div id="wrapper">
    <table class="skills-table">
      <thead>
        <tr>
            <th>Client ID</th>
            <th>Client Name</th>
            <th>Client Country</th>
            <th>Client Category</th>
            <th colspan="2">Actions</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.country}</td>
            <td>${l.category}</td>
            <td><a href="updateClientHiddenId?id=${l.id}">Edit</a></td>
            <td><a class="remove" href="removeClient?id=${l.id}">Delete</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
   </div>



        <c:import url="${path}headers&footer/bodyFooter.jsp" />
        </body>

        </html>