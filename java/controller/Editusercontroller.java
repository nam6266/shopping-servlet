package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.Editservice;

/**
 * Servlet implementation class Editusercontroller
 */
@WebServlet("/edituser")
@MultipartConfig
public class Editusercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editusercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String giamgia = request.getParameter("giamgia");
		String manufacturer = request.getParameter("manufacturer");
		String solded = request.getParameter("solded");
		String category = request.getParameter("category");
		String shipping = request.getParameter("shipping");
		Part part = request.getPart("img");
		String realPart = request.getServletContext()
				.getRealPath("/uploadsimgs");
		String filename = Path.of(part.getSubmittedFileName()).getFileName()
				.toString();
		Editservice es = new Editservice();

		es.editpen(id, giamgia, category, name, filename, price, manufacturer,
				shipping, solded);

		if (!Files.exists(Path.of(realPart))) {
			Files.createDirectory(Path.of(realPart));
		}
		part.write(realPart + "/" + filename);

		response.sendRedirect("userproductlist");
	}

}
