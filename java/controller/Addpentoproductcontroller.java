package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.Homeservice;
import service.Productlistservice;

/**
 * Servlet implementation class Addpentoproductcontroller
 */
@WebServlet("/addpentoproduct")
public class Addpentoproductcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addpentoproductcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Homeservice hs = new Homeservice();
		Productlistservice pls = new Productlistservice();
		
		String addid = request.getParameter("addid");
		Product penproduct = hs.getIDPen(addid);
		String giamgia = String.valueOf(penproduct.getGiamgia());
		String category1 = String.valueOf(penproduct.getCateid());
		String price = String.valueOf(penproduct.getPrice());
		System.out.println(addid);
		pls.input(giamgia, category1, penproduct.getName(), penproduct.getImg(), price );
		pls.deltedpen(addid);
		
		response.sendRedirect("productlist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
