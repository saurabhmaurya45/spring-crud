<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tagss -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<!-- custom css -->
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/styles/style.css'>
<title>CrudDemo | Index</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center m-3 p-3 bg-primary">Product List</h1>
		<button class="btn btn-primary float-right mb-2" data-toggle="modal"
			data-target="#addProdcut">Add Product</button>
		<table class="table mt-3 border table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Sr.No</th>
					<th>Product Name</th>
					<th>Product Image</th>
					<th>Description</th>
					<th>Stock</th>
					<th>Rate</th>
					<th>Edit | Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				int index = 1;
				%>
				<c:forEach items="${listProducts}" var="product">
					<tr>
						<td><%=index++%></td>
						<td>${product.product_name }</td>
						<td><img alt=""
							src='${pageContext.request.contextPath}/resources/images/iphone-14-pro-png.jpg'
							class="img-responsive product-image" /></td>
						<td>${product.description }</td>
						<td>${product.stock }</td>
						<td>Rs. ${product.rate }</td>
						<td><a href="${pageContext.request.contextPath}/edit/${product.id}" class="btn btn-primary">
								<i class="fa-regular fa-pen-to-square"></i>
						</a> <a href="${pageContext.request.contextPath}/remove/${product.id}" class="btn btn-danger"> <i
								class="fa-solid fa-trash"></i>
						</a></td>
					</tr>


				</c:forEach>

			</tbody>

		</table>


		<!-- Modal -->
		<div class="modal fade" id="addProdcut" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">
							${not empty product.product_name?"Edit ":"Add" } Product
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="${pageContext.request.contextPath}/product/add" method="post">
						<div class="modal-body">
							<div class="form-group">
								<label for="product_name">Product Name</label> <input
									type="text" class="form-control" id="product_name"
									aria-describedby="product_name"
									placeholder="Enter product name" name="product_name" 
									value="${not empty product.product_name?product.product_name:'' }" />
								<small id="product_name" class="form-text text-muted"></small>
							</div>
							<div class="form-group">
								<label for="stock">Stock</label> <input type=number
									class="form-control" id="stock" aria-describedby="stock"
									placeholder="Enter stock available" name="stock" 
									value="${not empty product.stock?product.stock:'' }" /> <small
									id="stock" class="form-text text-muted"></small>
							</div>
							<div class="form-group">
								<label for="rate">Rate</label> <input type="number"
									class="form-control" id="rate" aria-describedby="rate"
									placeholder="Enter price for single product" name="rate"
									value="${not empty product.rate?product.rate:'' }" /> <small id="rate" class="form-text text-muted"></small>
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<textarea class="form-control" id="description"
									name="description" rows="3">${not empty product.description?product.description:'' }</textarea>
							</div>
							<div class="form-group">
								<label for="upload_image">Upload Image</label> <input
									type="file" class="form-control-file" id="upload_image">
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Save
								changes</button>
						</div>
						<input type="hidden"
									class="form-control" id="editId" aria-describedby="id"
									 name="id"
									value="${not empty product.id?product.id:'' }" />
					</form>
				</div>
			</div>
		</div>

	</div>
	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		${not empty product.product_name?"$('#addProdcut').modal('show')":"" }
	</script>
</body>
</html>