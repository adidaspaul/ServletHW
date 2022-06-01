     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Find Company</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/companiesHeader.jsp" />
    </header>

    <form action="/findCompanyByName">
        <label for="name">Company Name</label>
        <input class="input" type="text" name="name" required placeholder="Enter Company's Name" /><br>
        <input class="sub" type="submit" value="Submit" />
    </form>


    <table>
        <tr>
            <th>Company ID</th>
            <th>Company Name</th>
            <th>Company City</th>
        </tr>
        <tr>
            <td><c:out value="${c.id}"/></td>
            <td><c:out value="${c.companyName}"/></td>
            <td><c:out value="${c.city}"/></td>
        </tr>
    </table>


<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>