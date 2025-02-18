<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>이미지 정보 보기</title>
</head>
<body>
<h1>이미지 목록</h1>
<c:choose>
    <c:when test="${not empty dto}">
        <c:forEach var="image" items="${dto}">
            <img src="data:${image.imageType};base64,${image.imageDataBase64}" alt="${image.imageName}" width="200"/>
            <p>이미지 이름 : ${image.imageName}</p>
            <p>직원 ID : ${image.employeeId}</p>
        </c:forEach>

    </c:when>
    <c:otherwise>
        <p>이미지가 없습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
