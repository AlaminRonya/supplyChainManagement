<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/12/2022
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Category</title>
    <jsp:include page="../include/css.jsp"/>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
<%--      <img th:src="@{/images/logo.png}"  src="../static/images/logo.png" width="auto" height="40" class="d-inline-block align-top" alt=""/>--%>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto"></ul>
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link"  href="#">admin-home</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link"  href="#">logout</a>
        </li>

      </ul>

    </div>
  </div>
</nav>
<div class="container">

  <a style="margin: 20px 0" href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/addCategory" class="btn btn-primary">Add Category</a>


  <div class="container-fluid">
    <div class="container" style="margin-top: 30px">
      <div class="row">
        <div class="col">
          <c:forEach var="responseCategoryDto" items="${responseCategoriesDto}">
            <div class="card" style="margin-top: 20px">
              <div class="row no-gutters">
                <div class="col-sm-7 d-flex justify-content-center">
                  <div class="card-body">
                    <h5 class="card-title">${responseCategoryDto.name}</h5>
                    <h4>ID: <span>${responseCategoryDto.id}</span></h4>
                    <h4>Description: <span>${responseCategoryDto.description}</span></h4>
                    <h4>Create Date: <span>${responseCategoryDto.createdAt}</span></h4>
                    <p>Modified Date: ${responseCategoryDto.modifiedAt}</p>
                    <p>Deleted Date: ${responseCategoryDto.deletedAt}</p>
                    <p>Active: ${responseCategoryDto.active}</p>
                    <a href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/delete/${responseCategoryDto.id}" class="btn btn-danger">Delete</a>
                    <a href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/update/${responseCategoryDto.id}" class="btn btn-warning">Update</a>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>

        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
