package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Category;
import entity.Product;
import entity.User;
import service.Categoryservice;
import service.Homeservice;





/**
 * Servlet implementation class Homecontroler
 */
@WebServlet("/home")
@MultipartConfig
public class Homecontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		String index = request.getParameter("paging");
		
		Categoryservice category = new Categoryservice();
		
		Homeservice hs = new Homeservice();

		if (index == null) {
			index = "1";
		}
		int paging = Integer.parseInt(index);

		int count = hs.countproduct();

		int endpage = count / 6;

		if (count % 6 != 0) {
			endpage++;
		}
		String check;
		String check1;
		if (user == null || user.getRole() == 2) {
			check = "none";
			check1 = "";

		} else {
			check = "";
			check1 = "none";
		}

		List<Product> pagingproduct = hs.pagingproduct(paging);
		List<Category> cateL = category.findAllCategory();

		request.setAttribute("user", user);
		request.setAttribute("endp", endpage);
		request.setAttribute("paging", pagingproduct);
		request.setAttribute("active", index);
		request.setAttribute("check", check);
		request.setAttribute("check1", check1);
		request.setAttribute("cateL", cateL);

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
