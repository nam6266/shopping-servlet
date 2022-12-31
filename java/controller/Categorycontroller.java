package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import entity.User;
import service.Homeservice;

/**
 * Servlet implementation class Categorycontroller
 */
@WebServlet("/category")
public class Categorycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categorycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		String id = request.getParameter("id");
		int intid = Integer.parseInt(id);
		
		String check;
		if (user == null || user.getRole() == 2) {
			check = "none";

		} else {
			check = "";
		}
		
		Homeservice hs = new Homeservice();
		
		List<Product> productL = hs.findAllProductbycateid(intid);
		
		request.setAttribute("productL", productL);
		request.setAttribute("check", check);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("category.jsp");
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
