package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Penproduct;
import entity.Product;
import service.Homeservice;

/**
 * Servlet implementation class Pendingproductcontroller
 */
@WebServlet("/pendingproduct")
public class Pendingproductcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pendingproductcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Homeservice hs = new Homeservice();
		List<Penproduct> penproduct = hs.findAllPendingProduct();
		
		String mess = "";
		request.setAttribute("products", penproduct);
		request.setAttribute("mes1", mess);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("userproductlist.jsp");
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
