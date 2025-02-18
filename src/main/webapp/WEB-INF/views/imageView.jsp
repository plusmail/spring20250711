
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>이미지 정보 보기</title>
</head>
<body>
<h1>이미지 목록</h1>
<c:choose>
    <c:when test="${not empty dto.imageData}">
        <img src="data:${dto.imageType};base64,${dto.imageDataBase64}" alt="${dto.imageName}" width="200"/>
        <p>이미지 이름 : ${dto.imageName}</p>
<%--        <p>직원 ID : ${dto.employeeId}</p>--%>
    </c:when>
    <c:otherwise>
        <p>이미지가 없습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
