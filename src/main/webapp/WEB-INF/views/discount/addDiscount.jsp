<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/14/2022
  Time: 2:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Discount</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
    <div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <%--@elvariable id="discountDto" type="com.example.supplychainmanagement.dto.request.DiscountDto"--%>
            <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/addDiscount" method="post" modelAttribute="discountDto" >
                <div class="form-group">
                    <label for="name">Discount name</label>
                    <form:input type="text" cssClass="form-control" id="name" placeholder="Discount name" path="name"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="description">Discount description</label>
                    <form:input type="text" cssClass="form-control" id="description" placeholder="Discount description" path="description"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>

<%--                <div class="form-group">--%>
<%--                    <label for="description">Discount discountPercent</label>--%>
<%--                    <form:input type="number" step="0.01" min="0" max="100" cssClass="form-control" id="discountPercent" placeholder="Discount discountPercent" path="discountPercent"/>--%>
<%--                    <form:errors path="discountPercent" cssClass="text-danger"/>--%>
<%--                </div>--%>

                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>
