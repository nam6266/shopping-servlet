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
import service.Editservice;
import service.Homeservice;

/**
 * Servlet implementation class Editpen
 */
@WebServlet("/editpen")
@MultipartConfig
public class Editpen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editpen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		Homeservice hs = new Homeservice();
		Product product = hs.getIDPen(id);

		Categoryservice category = new Categoryservice();
		List<Category> cate = category.findAllCategory();

		request.setAttribute("cate", cate);
		request.setAttribute("product", product);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editpen.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		System.out.println(id);
		System.out.println(comment);
		Editservice es = new Editservice();
		
		es.editpencomment(comment, id);
		response.sendRedirect("productlist");
	}
}


