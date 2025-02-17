
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일업로드</title>
</head>
<body>
<h1>파일 업로드</h1>
<form action="/image/upload" method="post" enctype="multipart/form-data">
    <label>직원 아이디 :</label>
    <input type="text" name="employeeId"><br>
    <label>파일 선택</label>
    <input type="file" name="file" required><br>
    <button type="submit">업로드</button>

</form>
</body>
</html>
