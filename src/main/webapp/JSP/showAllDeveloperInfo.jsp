     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Show All Devs</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
            <c:import url="${path}headers&footer/devsHeader.jsp" />
    </header>
    <table class="alldevs">
      <thead>
        <tr>
            <th>Developer ID</th>
            <th>Developer Name</th>
            <th>Developer Sex</th>
            <th>Developer Salary</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.sex}</td>
            <td>${l.salary}</td>
            <td><button>Edit</button></td>
            <td><button>Delete</button></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>


<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>