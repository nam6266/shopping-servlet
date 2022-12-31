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

import entity.Item;
import entity.User;
import service.Cartservice;

/**
 * Servlet implementation class Shoppingcartcontroller
 */
@WebServlet("/shoppingcart")
public class Shoppingcartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shoppingcartcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Cartservice cs = new Cartservice();
		List<Item> itemList = cs.loaditemformcart(user.getUserid());
		
		double sum = 0.0;
		double sumdiscount = 0.0;
		for(Item s:itemList)
		{
			sumdiscount += (s.getPricediscount());
			sum += (s.getPrice());
			
		}
		

		request.setAttribute("itemList", itemList);
		request.setAttribute("sum", sum);
		request.setAttribute("sumdiscount", sumdiscount);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("shoppingcart.jsp");
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
