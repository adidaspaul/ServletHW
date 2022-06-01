     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Find Dev</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/devsHeader.jsp" />
    </header>

    <form action="/findDeveloperById">
        <label for="devId">Developer ID</label>
        <input class="input" type="number" name="devId" required /><br>
        <input class="sub" type="submit" value="Submit" />
    </form>


    <table>
        <tr>
            <th>Developer ID</th>
            <th>Developer Name</th>
            <th>Developer Sex</th>
            <th>Developer Salary</th>
        </tr>
        <tr>
            <td><c:out value="${devs.id}"/></td>
            <td><c:out value="${devs.name}"/></td>
            <td><c:out value="${devs.sex}"/></td>
            <td><c:out value="${devs.salary}"/></td>
        </tr>
    </table>

<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>