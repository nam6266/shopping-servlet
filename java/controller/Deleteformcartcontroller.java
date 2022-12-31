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
 * Servlet implementation class Deleteformcartcontroller
 */
@WebServlet("/deletefromcart")
public class Deleteformcartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteformcartcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int Intid = Integer.parseInt(id);
		
		HttpSession session = request.getSession();
		
		Cartservice cs = new Cartservice();

		User user = (User) session.getAttribute("user");
		
		int soluong = cs.getsoluongfromcart(user.getUserid(), Intid);

		if (soluong > 1) 
		{

			cs.updatecart(soluong - 1,user.getUserid(),Intid);
		} else {
			cs.deletecart(Intid, user.getUserid());

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
