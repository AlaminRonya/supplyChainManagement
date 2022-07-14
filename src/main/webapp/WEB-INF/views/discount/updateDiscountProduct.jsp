<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/14/2022
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Discount Product</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="container-fluid">
        <div class="container" style="margin-top: 30px">
            <h1>Product Discount</h1>
            <h5>ID: ${discountDto.id}</h5>
            <h4>Name: <span>${discountDto.name}</span></h4>
            <h2>Description: <span>${discountDto.description}</span></h2>
            <h2>Discount Percentage: <span>${discountDto.discountPercent}%</span></h2>
            <h2>Active: <span>${discountDto.active}</span></h2>
            <p>Create Date: <span>${discountDto.createdAt}</span></p>
            <p>Modified Date: ${discountDto.modifiedAt}</p>
            <p>Deleted Date: ${discountDto.deletedAt}</p>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <%--@elvariable id="updateDiscountDto" type="com.example.supplychainmanagement.dto.UpdateDiscountDto"--%>
                <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/update/${discountDto.id}" method="post" modelAttribute="updateDiscountDto" >

                    <div class="form-group">
                        <label for="discountPercent">Discount Percentage</label>
                        <form:input type="number" step="0.01" min="0" max="100" cssClass="form-control" id="discountPercent" placeholder="Discount discountPercent" path="discountPercent"/>
                        <form:errors path="discountPercent" cssClass="text-danger"/>
                    </div>

                    <button type="submit" class="btn btn-primary">Create</button>
                </form:form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
