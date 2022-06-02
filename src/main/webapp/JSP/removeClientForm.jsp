<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
                <!DOCTYPE html>
                <html lang="en">

                        <head>
                        <title>Delete Client</title>
                        <c:import url="${path}headers&footer/header.jsp" />
                        </head>

                                <body>

                                            <header>
                                                    <c:import url="${path}headers&footer/clientsHeader.jsp" />
                                            </header>

                 <form action="/removeClient" method="get">
                 <label for="id">Client ID</label>
                  <input class="input" type="number" name="id" placeholder="Enter CLient's ID" required /><br>
                  <input class="sub" type="submit" value="Submit" />
                  </form>



                                  <c:import url="${path}headers&footer/bodyFooter.jsp" />
                                </body>

                </html>