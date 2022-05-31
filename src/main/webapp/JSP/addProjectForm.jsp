     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Projects Page</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/projectsHeader.jsp" />
    </header>

     <form action="/addProject" method="post">
        <label for="projectName">Project Name</label>
        <input class="input" type="text" name="projectName" required /><br>
        <label for="projectDate">Project Start Date</label>
        <input class="input" type="date" name="projectDate" required /><br>
        <label for="projectWorth">Project Worth</label>
        <input class="input" type="number" name="projectCost"  required/></br>
        <input class="sub" type="submit" value="Submit" />
    </form>


<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>