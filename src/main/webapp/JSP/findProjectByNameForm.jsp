     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Find Project</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/projectsHeader.jsp" />
    </header>

    <form action="/findProjectByName" method="get">
        <label for="name">Project Name</label>
        <input class="input" type="text" name="name" required /><br>
        <input class="sub" type="submit" value="Submit" />
    </form>


    <table>
        <tr>
            <th>Project ID</th>
            <th>Project Name</th>
            <th>Project Start Date</th>
            <th>Project Cost</th>
        </tr>
        <tr>
            <td><c:out value="${project.id}"/></td>
            <td><c:out value="${project.projectName}"/></td>
            <td><c:out value="${project.startDate}"/></td>
            <td><c:out value="${project.cost}"/></td>
        </tr>
    </table>

<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>