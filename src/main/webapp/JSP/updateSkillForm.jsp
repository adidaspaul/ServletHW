     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Update Skill</title>
            <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

            <header>
                <c:import url="${path}headers&footer/skillsHeader.jsp" />
            </header>

     <form action="/updateSkill" method="get">
             <label for="id">Skill Id</label>
             <input class="input" type="number" name="id" required/></br>
             <label for="syntaxName">Syntax Name</label>
             <input class="input" type="text" name="syntaxName" required/><br>
             <label for="skillRank">Skill Rank</label>
             <input class="input" type="text" name="skillRank" required/></br>
             <input class="sub" type="submit" value="Submit" />
         </form>
     <c:import url="${path}headers&footer/bodyFooter.jsp" />
   </body>
 </html>