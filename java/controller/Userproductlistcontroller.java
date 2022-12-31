package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.Category;
import entity.Product;
import service.Categoryservice;
import service.Homeservice;
import service.Productlistservice;

/**
 * Servlet implementation class Userproductlistcontroller
 */
@WebServlet("/userproductlist")
@MultipartConfig
public class Userproductlistcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userproductlistcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Categoryservice category = new Categoryservice();
		
		Homeservice hs = new Homeservice();
		List<Category> cate = category.findAllCategory();

		List<Product> products = hs.findAllProduct();
		
		String delID = request.getParameter("del");

		Productlistservice pls = new Productlistservice();

		pls.deltedpen(delID);
		
		String mess = "none";
		request.setAttribute("mes1", mess);
		request.setAttribute("products", products);
	
		
		request.setAttribute("cate", cate);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("userproductlist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("productname");

		String giamgia = request.getParameter("productdiscount");

		String category = request.getParameter("productcate");

		String price = request.getParameter("productprice");

		Part part = request.getPart("productimg");

		String realPart = request.getServletContext()
				.getRealPath("/uploadsimgs");
		System.out.println(realPart);

		String filename = Path.of(part.getSubmittedFileName()).getFileName()
				.toString();

//		String savepath = "D:\\code\\java\\demo\\src\\main\\webapp\\uploadsimgs";

		Productlistservice pls = new Productlistservice();

//
		pls.inputpen(giamgia, category, name, filename, price);

		if (!Files.exists(Path.of(realPart))) {
			Files.createDirectory(Path.of(realPart));
		}

		part.write(realPart + "/" + filename);

//		if (!Files.exists(Path.of(savepath))) {
//			Files.createDirectory(Path.of(savepath));
//		}
//		
//		part.write(savepath + "/" + filename);
//		

////
//		RequestDispatcher dispatcher = request.getRequestDispatcher("productlist");
//		dispatcher.forward(request, response);
		response.sendRedirect("userproductlist");
	}
	}

