     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Developers Page</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/devsHeader.jsp" />
    </header>

    < <form action="/addDeveloper" method="post">
        <label for="developerName">Developer Name</label>
        <input class="input" type="text" name="devName" id="devName" /><br>
        <label for="devSex">Developer Sex</label>
        <input type="radio" name="devsSex" value="male"/>
        <label class="rad" for="devsSex">Male</label>
        <input  type="radio" name="devsSex" value="female"/>
        <label class="rad" for="female">Female</label></br>
        <label for="devSalary">Developer Salary</label>
        <input class="input" type="number" name="devSalary" id="developerSalary" /><br>
        <input class="sub" type="submit" value="Submit" />
    </form> >


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