<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="Style/CSS/style.css">
<link rel="stylesheet" href="Style/CSS/detail.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<header>
		<div class="container">
			<div class="container-header">
				<div class="navigator">
					<ul>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-user"></i> </span> <span class="text">Kênh
									người bán </span>
						</a></li>
						<li style="display:${check};"><a href="productlist"> <span
								class="icon"><i class="fa-solid fa-list"></i> </span> <span
								class="text">Product List </span>
						</a></li>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-cloud-arrow-down"></i> </span> <span class="text">Tải
									ứng dụng </span>
						</a></li>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-link"></i> </span> <span class="text">Kết
									nối </span>
						</a></li>
					</ul>
				</div>

				<div class="navigator">
					<ul>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-bell"></i> </span> <span class="text">Thông
									báo </span>

						</a></li>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-circle-question"></i> </span> <span class="text">Hỗ
									trợ </span>
						</a></li>
						<li><a href=""> <span class="icon"><i
									class="fa-solid fa-globe"></i> </span> <span class="text">Ngôn
									ngữ </span>
						</a></li>
						<li><a href="dangky"> <span class="icon"><i
									class="fa-solid fa-address-card"></i> </span> <span class="text">Đăng
									ký </span>
						</a></li>
						<c:if test="${user == null}">
							<li><a href="dangnhap"> <span class="icon"><i
										class="fa-solid fa-right-to-bracket"></i></span> <span class="text">Đăng
										nhập </span>
							</a></li>
						</c:if>
						<c:if test="${user != null}">
							<li><a href="logout"> <span class="icon"><i
										class="fa-solid fa-right-to-bracket"></i></span> <span class="text">Xin
										chào ${user.username}<br> Ấn vào để đăng xuất
								</span>
							</a></li>
						</c:if>
					</ul>
				</div>
			</div>

			<div class="container-body">
				<a href="home"><img src="Style/img/shoppe header.PNG" alt=""></a>

				<form action="searchbar" method="post">
					<div class="search-box">
						<input class="search-txt" type="text" name="productname"
							placeholder="Type to search">
						<button type="submit" class="search-btn">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>

				<a href="shoppingcart"> <img
					src="Style/img/shooper header-cart.PNG" alt="">
				</a>
			</div>
		</div>
	</header>

	<main>
		<div class="danh-muc">
			<div class="section_container">
				<c:forEach items="${productL}" var="items">
					<div class="card">
						<div class="imgBX">
							<a href="detail?id=${items.id}"> <img
								src="uploadsimgs/${items.img}" alt="">
								<h2>${items.name}</h2>
							</a>
						</div>
						<div class="giam_gia">
							<p>${items.giamgia}%</p>
							<p>GIẢM</p>
						</div>
						<div class="content">
							<div class="name">
								<h3>Giá : ${items.price}</h3>
							</div>
							<div class="price">
								<h3>Ship: ${items.ship}</h3>
							</div>
							<div class='a'>
								<a href="addtoshoppingcart?id=${items.id}">add to cart</a> <a
									href="#"> buy now</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</main>
</body>
</html>