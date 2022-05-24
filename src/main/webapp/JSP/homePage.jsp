<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html lang="en">

        <head>
        <title>Management System</title>
        <c:import url="${path}headers&footer/header.jsp" />
        </head>

        <body>

        <c:import url="${path}headers&footer/bodyHeader.jsp" />



        <c:import url="${path}headers&footer/bodyFooter.jsp" />
        </body>

        </html>