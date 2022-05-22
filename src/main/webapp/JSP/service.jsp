<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Service</title>

    <body>
        <table  style="position:fixed; left:300px; right:auto; top:0; width:60%; height:10%;border:4px solid black;">

            <thead>
                <tr>
                    <td style="border:7px solid black; border-radius:5px" ><h3>Service Name</h3></td>
                    <td style="border:7px solid black; border-radius:5px"><h3>Service Description</h3></td>
                    <td style="border:7px solid black; border-radius:5px"><h3>Service Price</h3></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${services}" var="service">
                    <tr>
                        <td style="border:3px solid orange;margin-right:5px;padding-right:5px;border-radius:25px;">
                            <c:out value="${service.name}" />
                        </td>
                        <td>
                            <c:out value="${service.description}" />
                        </td>
                        <td style="border:3px solid green;margin-right:5px;padding-right:5px;border-radius:25px;">
                            <c:out value="${service.price}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>

    </html>