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

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<main>

		<header class="home-page-header">
			<a href="home"><h1 class="dev-logo">Home</h1></a>
			<img class="HAM" src="http://i.imgur.com/pHMXixM.png"
				alt="Hamburger Menu">
			<a href="productlist"><h1 class="dev-logo">Product List</h1></a> <img class="HAM"
				src="http://i.imgur.com/pHMXixM.png" alt="Hamburger Menu">
			<a href="adminpendingproductlist">Pending Product</a> <img class="HAM"
				src="http://i.imgur.com/pHMXixM.png" alt="Hamburger Menu">
		</header>

		<!-- This is the side menu that is hidden on mobile -->

		<section class="home-page-mid">

			<aside class="side-nav">
				<nav class="side-nav-links">
					<form action="productlist" method="post"
						enctype="multipart/form-data">
						<h2 class="title">Nhập sản phẩm</h2>

						<h3 class="title_alert" style="color: red;">${mess}</h3>

						<div class="input-div one">
							<div class="i">
								<i class="fas fa-user"></i>
							</div>
							<div class="div">
								<h5>discount</h5>
								<input type="text" name="productdiscount" class="input">
							</div>
						</div>

						<div class="input-div pass">
							<div class="i">
								<i class="fa-solid fa-envelope"></i>
							</div>
							<div class="div">
								<h5>Giá sản phẩm</h5>
								<input type="text" name="productprice" class="input">
							</div>
						</div>

						<div class="input-div pass">
							<div class="i">
								<i class="fas fa-lock"></i>
							</div>
							<div class="div">
								<h5>Tên sản phẩm</h5>
								<input type="text" name="productname" class="input">
							</div>
						</div>

						<div class="input-div one">
							<div class="i">
								<i class="fas fa-user"></i>
							</div>
							<div class="div">
								<h5>image</h5>
								<input type="file" name="productimg" class="input">
							</div>
						</div>

						<div class="input-div pass">
							<div class="i">
								<i class="fas fa-lock"></i>
							</div>
							<div class="div">
								<h5>Chọn category của sản phẩm</h5>
								<select class="input" name="productcate">
									<c:forEach items="${cate}" var="cates">
										<option value="${cates.cateID}">${cates.cateName}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<input type="submit" class="btn" value="Nhập vào sản phẩm">
					</form>

				</nav>
			</aside>
			<section class="products-list">
				<c:forEach items="${products}" var="items">
					<section class="product-container">

						<img src="uploadsimgs/${items.img}" alt="Product Image" >
						<footer class="product-footer">
							<div class="title-container">
								<h2 class="product-title">ID: ${items.id}</h2>
								<p class="product-desc">${items.name}</p>
							</div>
							<h3 class="product-price">${items.price}</h3>
						</footer>
						<div class="button-config">
							<a style="margin-right:10px; display:${mes}" href="edit?id=${items.id}"><p>Edit</p></a>
							<a style="margin-right:10px; display:${mes1}" href="admineditpen?id=${items.id}"><p>Edit pen</p></a>
							<a href="productlist?del=${items.id}" style="margin-right:10px; display:${mes}"><p>Delete</p></a>
							<a href="productlistpen?del=${items.id}" style="margin-right:10px; display:${mes1}"><p>Delete pen</p></a>
							<a href="addpentoproduct?addid=${items.id}" style="display:${mes1}"><p>Chấp thuận</p></a>
						</div>
					</section>
				</c:forEach>
			</section>

		</section>

		<script type="text/javascript" src="Style/CSS/main.js"></script>
	</main>


</body>
</html>