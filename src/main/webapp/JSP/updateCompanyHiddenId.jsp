     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Update Company</title>
            <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

            <header>
                <c:import url="${path}headers&footer/companiesHeader.jsp" />
            </header>

     <form action="/updateCompany" method="get">
             <input class="input" type="hidden" name="id" value="<%=request.getParameter("id") %>" required/></br>
             <label for="name">Company Name</label>
             <input class="input" type="text" name="name" required/><br>
             <label for="city">City of the Company</label>
             <input class="input" type="text" name="city" required/></br>
             <input class="sub" type="submit" value="Submit" />
         </form>
     <c:import url="${path}headers&footer/bodyFooter.jsp" />
   </body>
 </html>