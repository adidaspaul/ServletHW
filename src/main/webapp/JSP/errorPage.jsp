<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" language="java" isErrorPage="true" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <!DOCTYPE html>
        <html lang="en">
                <head>
                    <title>Error</title>
                    <c:import url="${path}headers&footer/header.jsp" />
                </head>
                <body>
                        <c:import url="${path}headers&footer/bodyHeader.jsp" />
	                <center>
		                <h1>Error</h1>
		                <h2><%=exception.getMessage() %><br/> </h2>
	                </center>

	                <c:import url="${path}headers&footer/bodyFooter.jsp" />
                </body>
        </html>