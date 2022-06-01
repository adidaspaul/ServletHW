<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html lang="en">

        <head>
        <title>Companies Page</title>
        <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

                    <header>
                            <c:import url="${path}headers&footer/companiesHeader.jsp" />
                    </header>
 <div id="wrapper">
    <table class="skills-table">
      <thead>
        <tr>
            <th>Company ID</th>
            <th>Company Name</th>
            <th>Company City</th>
            <th colspan="2">Actions</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.companyName}</td>
            <td>${l.city}</td>
            <td><a href="updateCompanyHiddenId?id=${l.id}">Edit</a></td>
            <td><a class="remove" href="removeCompany?id=${l.id}">Delete</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
   </div>



        <c:import url="${path}headers&footer/bodyFooter.jsp" />
        </body>

        </html>