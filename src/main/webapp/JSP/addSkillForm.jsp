     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Skills Page</title>
    <c:import url="${path}headers&footer/header.jsp" />
</head>

<body>

    <header>
        <c:import url="${path}headers&footer/skillsHeader.jsp" />
    </header>

     <form action="/addSkill" method="post">
        <label for="skillSyntax">Skill Syntax</label>
        <input class="input" type="text" name="skillSyntax" required/><br>
        <label for="skillRank">Skill Rank</label>
        <input type="text" name="skillRank" required/></br>
        <input class="sub" type="submit" value="Submit" />
    </form>


<c:import url="${path}headers&footer/bodyFooter.jsp" />
</body>

</html>