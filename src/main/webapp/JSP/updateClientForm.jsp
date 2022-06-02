     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Update Client</title>
            <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

            <header>
                <c:import url="${path}headers&footer/clientsHeader.jsp" />
            </header>

     <form action="/updateClient" method="get">
             <label for="id">Client Id</label>
             <input class="input" type="number" name="id" required/></br>
             <label for="name">Client Name</label>
             <input class="input" type="text" name="name" required/><br>
             <label for="country">Client Country</label>
             <input class="input" type="text" name="country" required/></br>
             <label for="category">Client Category</label>
             <input class="input" type="text" name="category" required/></br>
             <input class="sub" type="submit" value="Submit" />
         </form>
     <c:import url="${path}headers&footer/bodyFooter.jsp" />
   </body>
 </html>