     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Find Client</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/clientsHeader.jsp" />
    </header>

    <form action="/findClientByName">
        <label for="name">Client Name</label>
        <input class="input" type="text" name="name" required placeholder="Enter Client's name" /><br>
        <input class="sub" type="submit" value="Submit" />
    </form>


    <table>
        <tr>
            <th>Client ID</th>
            <th>Client Name</th>
            <th>Client Country</th>
            <th>Client Category</th>
        </tr>
        <tr>
            <td><c:out value="${c.id}"/></td>
            <td><c:out value="${c.name}"/></td>
            <td><c:out value="${c.country}"/></td>
            <td><c:out value="${c.category}"/></td>
        </tr>
    </table>


<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>