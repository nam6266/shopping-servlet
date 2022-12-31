<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
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
						<li><a href="productlist"> <span class="icon"><i class="fa-solid fa-list"></i> </span> <span class="text">Product List </span>
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
							<li><a href="logout"> 
								<span class="icon"><i class="fa-solid fa-right-to-bracket"></i></span> 
								<span class="text">Xin chào ${user.username}<br> Ấn vào để đăng xuất</span>
							</a></li>
						</c:if>
					</ul>
				</div>	
			</div>

			<div class="container-body">
				<a href="home"><img src="Style/img/shoppe header.PNG" alt=""></a>
				<div class="search-box">
					<input class="search-txt" type="text" name=""
						placeholder="Type to search"> <a class="search-btn"
						href="#"> <i class="fas fa-search"></i>
					</a>
				</div>
				<a href="shoppingcart"> <img src="Style/img/shooper header-cart.PNG"
					alt="">
				</a>
			</div>

			<div class="container-footer">
				<a href="#">Dép</a> <a href="#">Áo phong</a> <a href="#">Balo</a> <a
					href="#">Dép nữ</a> <a href="#">Áo crocktop</a> <a href="#">Áo
					khoát</a> <a href="#">Túi xách nữ</a> <a href="#">Giầy</a>
			</div>
		</div>
	</header>

    <main>
        <div class="main-container">
            <div class="detai-img">
                <img src="uploadsimgs/${products.img}" alt="">
            </div>

            <div class="detail-infor">
                <div class="detail-infor-header">
                    <p id="thongtin"> ${products.name}</p>
                    <div class="moreinfor">
                        <p id="rating">4.7  <i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i
                                class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i
                                class="fa-solid fa-star"></i></p>
                        <p>454 Đánh Giá</p>
                        <p>${products.solded} Đã bán</p>
                    </div>
                </div>
                <div class="container-detail-price">
                    <p>${products.price }</p>
                    <p id="giamgia-detail">${products.giamgia}% giảm</p>
                </div>
                <div class="more-infor">
                    <div class="deal">
                        <p>Deal sốc</p>
                        <p id="deal-infor">Mua để nhận quà</p>
                    </div>
                    <div class="vanchuyen">
                        <p>Vận chuyển</p>
                        <p>${products.ship}</p>
                    </div>
                    <div class="mausac">
                        <p>Màu sắc</p>
                        <P id="mausac-infor"> xanh</P>
                    </div>
                    <div class="soluogn">
                        <p>Số lượng</p>
                        <p id="soluong-infor"> 4748 cái có sẵn</p>
                    </div>
                    <div class="mua">
                        <a href="addtoshoppingcart?id=${products.id}" class="themvao"> <h1 >thêm vào giỏ hàng</h1> </a>
                        <h1 class="buy">Mua Ngay</h1>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>