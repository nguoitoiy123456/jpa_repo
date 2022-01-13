<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP + MySQL
				Example - Customer Management</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Customer</div>
				</div>
				<div class="panel-body">
					<form:form action="saveCustomer" cssClass="form-horizontal"
						method="post" modelAttribute="customer">

						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />
						<div class="form-group">
							<label for="firstName" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">		
								<form:input path="firstName" cssClass="form-control" required="required" />
								 <form:errors path="firstName" cssClass="form-control" />
							</div>
							
						</div>
					
						 
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control"  required="required"/>
									<form:errors path="lastName" /> 
							</div>
						
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control"  required="required"/>
							<form:errors path="email" />
							</div>
							
						</div>
						<div class="form-group">
							<label for="province" class="col-md-3 control-label">Province</label>
							<div class="col-md-9">
								<form:select path = "province" required="required">
				                     <form:option value = "" label = "Select"/>
				                     <c:forEach var="provin" items="${provinces}">
      									<form:option value="${provin.id }" label="${provin.name}" 
      									selected="${provin.id==customer.province.id?'selected':''}"
      									/>
   									 </c:forEach>
   			
				                  </form:select> 
				            	 <%--    <form:errors path="province" /> --%>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-md-3 control-label">Hobbies</label>
							<div class="col-md-9">
								
								<form:select path = "hobbies" multiple="true" required="required" 
									itemValue="id"  itemLabel="name" items="${hobbies}">
								</form:select> 
								<%--   <form:errors path="hobbies" /> --%>
							</div>
							 
						</div>
  
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>