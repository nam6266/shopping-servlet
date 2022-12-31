<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="Style/CSS/productlist.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="container">
		<div class="login-content">
		
		<section class="products-list">
				
					<section class="product-container">

						<img src="uploadsimgs/${product.img}" alt="Product Image" >
					<footer class="product-footer">
						<div class="title-container">
							<h2 class="product-title">ID: ${product.id}</h2>
							<p class="product-desc">${product.name}</p>
						</div>
						<h3 class="product-price">${product.price}</h3>
						<h3 class="product-price">${product.giamgia}</h3>
					</footer>

				</section>

			</section>
			
			<form action="editpen" method="post">
				<h2 class="title">comment</h2>
				
				<input type="hidden" value="${product.id}"  type="text" name="id" class="input">

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<input  type="text" name="comment" class="input">
					</div>
				</div>

				<input type="submit" class="btn" value="Submit edit">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="Style/CSS/main.js"></script>
</body>
</html>