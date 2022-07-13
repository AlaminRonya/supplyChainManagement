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

<jsp:include page="../include/navbar.jsp"/>
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
                    <h5 class="card-title">ID: ${responseCategoryDto.id}</h5>
                    <h4>Name: <span>${responseCategoryDto.name}</span></h4>
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
