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
			<form action="edituser" method="post" enctype="multipart/form-data">
				<h2 class="title">Chỉnh sửa</h2>
				<h3 class="title_alert">${mess}</h3>

				<input style="display: none;" value="${product.id}" type="text"
					name="id" class="input">

				<div class="input-div one">
					<div class="i">
					
					</div>
					<div class="div">
						<h5>Tên sản phẩm</h5>
						<input value="${product.name}" type="text" name="name" class="input">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Giá sản phẩm</h5>
						<input  value="${product.price}" type="text" name="price" class="input">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Giảm giá</h5>
						<input value="${product.giamgia}" type="text" name="giamgia" class="input">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Hãng sản xuất</h5>
						<input value="${product.manufacturer}" type="text" name="manufacturer" class="input">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Đã bán</h5>
						<input value="${product.solded}" type="text" name="solded" class="input">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Chọn category của sản phẩm</h5>
						<select class="input" name="category">
							<c:forEach items="${cate}" var="cates">
								<option value="${cates.cateID}">${cates.cateName}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						
					</div>
					<div class="div">
						<h5>Chọn quá trình vận chuyển của sản phẩm</h5>
						<select class="input" name="shipping">
							<option value="Miễn phí ship">Miễn phí ship</option>
							<option value="Có phí ship">Có phí ship</option>
						</select>
					</div>
				</div>

				<div class="input-div one">
					<div class="i">
					
					</div>
					<div class="div">
						<h5>Cập nhập lại hình ảnh</h5>
						<img src="uploadsimgs/${product.img}" alt="Product Image" width="150"
							height="150">
						<input type="file" name="img" class="input">
					</div>
				</div>

				<input type="submit" class="btn" value="Submit edit">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="Style/CSS/main.js"></script>
</body>
</html>