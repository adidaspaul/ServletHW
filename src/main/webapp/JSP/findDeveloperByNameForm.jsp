     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Developers Page</title>
    <c:import url="${path}header.jsp" />
</head>

<body>

    <header>
        <div class="container">
            <img src="${path}/img/logo.png" alt="logo" class="logo">
            <nav class="devstabs">
                <ul>
                    <li><a href="/homePage.html">Home</a></li>
                    <li><a href="/findDeveloperByIdForm">Find Developer by Id</a></li>
                    <li><a href="/findDeveloperByNameForm.html">Find Developer by Name</a></li>
                    <li><a href="/addDeveloperForm">Add Developer to DB</a></li>
                    <li><a href="/updateDeveloperForm">Update Developer Info</a></li>
                    <li><a href="/removeDeveloperForm">Remove Developer from DB</a></li>
                    <li><a href="/showAllDeveloperInfo">Show All Developers Info</a></li>
                </ul>
        </div>
    </header>

    <form action="/findDeveloperByName">
        <label for="devsName">Developer Name</label>
        <input type="text" name="devsName" id="developerName" placeholder="Enter Dev's Name" /><br>
        <input type="submit" value="Submit" />
    </form>


    <table>
        <tr>
            <th>Developer ID</th>
            <th>Developer Name</th>
            <th>Developer Sex</th>
            <th>Developer Salary</th>
        </tr>
        <tr>
            <td><c:out value="${devs.id}"/></td>
            <td><c:out value="${devs.name}"/></td>
            <td><c:out value="${devs.sex}"/></td>
            <td><c:out value="${devs.salary}"/></td>
        </tr>
    </table>
    <%-- <form action="/findDeveloperById">
        <label for="developerId">Developer ID</label>
        <input type="text" name="developerId" id="developerId" /><br>
        <input type="submit" value="Submit" />
    </form> --%>

    <%-- <form action="/addDeveloper">
        <label for="developerName">Developer Name</label>
        <input type="text" name="developerName" id="developerName" /><br>
        <label for="developerAge">Age</label>
        <input type="number" name="developerAge" id="developerAge" /><br>
        <label for="developerSex">Sex</label>
        <input type="radio" name="developerSex" id="developerSex" /><br>
        <input type="submit" value="Submit" />
    </form> --%>


<c:import url="${path}bodyFooter.jsp" />
</body>

</html>