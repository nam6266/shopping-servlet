<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="Style/CSS/shoppingcart.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
        integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<main class="page">
		<section class="shopping-cart dark">
			<div class="container">
				<div class="block-heading">
					<h2>Shopping Cart</h2>
				</div>
				<div >
					<a href="home">Về lại trang chủ</a>
				</div>
				<div class="content">
					<div class="row">
						<div class="col-md-12 col-lg-8">
							<div class="items">

								<c:forEach items="${itemList}" var="s">
									<div class="product">
										<div class="row">
											<div class="col-md-3">
												<img class="img-fluid mx-auto d-block image"
													src="uploadsimgs/${s.product.img}"> 
											</div>
											<div class="col-md-8">
												<div class="info">
													<div class="row">
														<div class="col-md-5 product-name">
															<div class="product-name">
																<a href="detail?id=${s.product.id }">${s.product.name}</a>
																<div class="product-info">
																	<div>
																		Giảm giá: <span class="value">${s.product.giamgia}%</span>
																	</div>
																	<div>
																		Số lượng: <span class="value">${s.soluong}</span>
																	</div>
																	<div>
																		Đã bán: <span class="value">${s.product.solded}</span>
																	</div>
																	<div> 
																		<a href="addtoshoppingcart?id=${s.product.id}"><i class="fa-regular fa-square-plus"></i></a>
																		<a href="deletefromcart?id=${s.product.id }"><i class="fa-regular fa-square-minus"></i></a>
																	</div>
																</div>
															</div>
														</div>

														<div class="col-sm-7 price">
															 Giá ban đầu:<span>  $${s.price}</span>
															 Giá đã giảm:<span>  $${s.pricediscount}</span>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="col-md-12 col-lg-10">
									<div class="summary">
										<h3>Summary</h3>
										<div class="summary-item">
											<span class="text">Tổng giá tiền</span><span class="price">$ ${sum}</span>
										</div>
										<div class="summary-item">
											<span class="text">Tổng giá tiền sau khi được giảm giá</span><span class="price">$ ${sumdiscount}</span>
										</div>
								
										<button type="button" class="btn btn-primary btn-lg btn-block">Checkout</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>