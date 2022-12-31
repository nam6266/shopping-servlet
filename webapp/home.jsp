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
						<li style="display:${check1};"><a href="userproductlist"> <span
								class="icon"><i class="fa-solid fa-list"></i> </span> <span
								class="text"> User Product List </span>
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
		<div class="intro">
			<div class="intro-img">
				<div class="intro-1">
					<img src="Style/img/main-intro1.PNG" alt="">
				</div>
				<div class="intro-2">
					<img src="Style/img/main-intro2.PNG" alt=""> <img
						src="Style/img/main-intro2.PNG" alt="">
				</div>
			</div>
			<div class="intro-item">
				<div class="intro-list">
					<img src="Style/img/itro-img.PNG" alt=""> <span>
						<p>Khung Giờ Săn Sale</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img2.PNG" alt=""> <span>
						<p>Gì cũng rẻ - mua là freeship</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img3.PNG" alt=""> <span>
						<p>Miễn phí vận chuyển</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/itro-img4.PNG" alt=""> <span>
						<p>Bắt trend - giá sốc</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img5.PNG" alt=""> <span>
						<p>Hoàn xu 6%</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img6.PNG" alt=""> <span>
						<p>Hàng hiệu giá tốt</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img7.PNG" alt=""> <span>
						<p>Hàng quốc tế</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img8.PNG" alt=""> <span>
						<p>Nạp thẻ, Hóa đơn & phim</p>
					</span>
				</div>
				<div class="intro-list">
					<img src="Style/img/intro-img9.PNG" alt=""> <span>
						<p>Chọn 6 số trúng 1 triệu</p>
					</span>
				</div>
			</div>
		</div>

		<div class="news">
			<img src="Style/img/news.PNG" alt="">
		</div>

		<div class="danh-muc">
			<div class="titlle">
				<H1>Gợi ý hôm nay</H1>

				<div class="paging">
					<c:forEach begin="1" end="${endp}" var="index">
						<a class="${active == index?"
							active":" "}" href="home?paging=${index}">${index}</a>
					</c:forEach>
				</div>

			</div>

			<div class="section_container">
				<c:forEach items="${paging}" var="items">
					<div class="card">
						<div class="imgBX">
							<a href="detail?id=${items.id}"> <img
								src="img/${items.img}" alt="">
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
									href="Sendemail"> buy now</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="category">
			<div class="titlle">
				<a href="#"><h1>Danh mục</h1></a>
			</div>
			<div class="category-list">
				<c:forEach items="${cateL}" var="items">

					<div class="category-product">
						<a href="category?id=${items.cateID}"> <img
							src="uploadsimgs/${items.cateimg}" alt="" width="300"
							height="300">
							<div class="category-product-detail">
								<div class="price">
									<h1>${items.cateName}</h1>
								</div>
								<div class="quantity"">
									<h5>${items.soluong}</h5>
								</div>
							</div>
						</a>
					</div>

				</c:forEach>
			</div>


		</div>

		<div class="quangcao-img">
			<div>
				<img src="Style/img/quangcao-img.PNG" alt="">
			</div>
		</div>

		<div class="shoppe-mall">
			<div class="shoppe-mall-header">
				<div id="shoppe-mall-header-intro">
					<p>SHOPPE MALL</p>
					<img src="Style/img/shopemall-header.PNG" alt="">
				</div>
				<div>
					<p>
						Xem Tất Cả <i class="fa-solid fa-circle-chevron-right"></i>
					</p>
				</div>
			</div>

			<div class="shoppemall-body">
				<div>
					<img src="Style/img/shopemall-body.PNG" alt="">
				</div>
				<div class="shoppemall-list">
					<div class="shoppemall-list-1">
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
					</div>

					<div class="shoppemall-list-1">
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
						<div class="shoppemall-item">
							<img src="Style/img/shoppemall-lst.PNG" alt="">
							<p>Mua 1 được 10+</p>
						</div>
					</div>

				</div>
			</div>
		</div>

	</main>
</body>
</html>