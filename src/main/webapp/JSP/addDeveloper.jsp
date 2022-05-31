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

     <form action="/addDeveloper" method="post">
        <label for="developerName">Developer Name</label>
        <input class="input" type="text" name="devName" required /><br>
        <label for="devSex">Developer Sex</label>
        <input type="radio" name="devsSex" value="male" required/>
        <label class="rad" for="devsSex">Male</label>
        <input  type="radio" name="devsSex" value="female"/>
        <label class="rad" for="female">Female</label></br>
        <label for="devSalary">Developer Salary</label>
        <input class="input" type="number" name="devSalary" required /><br>
        <input class="sub" type="submit" value="Submit" />
    </form>
<c:if test="${not empty errorMessage}">
    <c:forEach items="${errorMessage.errors}" var="error">
    <p>${error.message}</p>
    </c:forEach>
</c:if>

<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>