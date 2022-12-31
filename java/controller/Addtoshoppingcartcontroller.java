package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.Cartservice;

/**
 * Servlet implementation class Addtoshoppingcartcontroller
 */
@WebServlet("/addtoshoppingcart")
public class Addtoshoppingcartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtoshoppingcartcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Cartservice cs = new Cartservice();

		User user = (User) session.getAttribute("user");

		String productid = request.getParameter("id");
		System.out.println(productid);

		int Intid = Integer.parseInt(productid);

		int a = cs.getsoluongfromcart(user.getUserid(), Intid);

		if (a == 0) {

			cs.inputcart(user.getUserid(), Intid, 1);

		} else {
			

			cs.updatecart(a + 1, user.getUserid(),Intid);

		}
		response.sendRedirect("shoppingcart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
