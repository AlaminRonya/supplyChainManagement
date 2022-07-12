<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/12/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category show</title>
</head>
<body>
    <p>Id: ${responseCategoryDto.id}</p><br/>
    <p>Name: ${responseCategoryDto.name}</p><br/>
    <p>Description: ${responseCategoryDto.description}</p><br/>
    <p>CreatedAt: ${responseCategoryDto.createdAt}</p><br/>
    <p>ModifiedAt: ${responseCategoryDto.modifiedAt}</p><br/>
    <p>DeletedAt: ${responseCategoryDto.deletedAt}</p><br/>
</body>
</html>
