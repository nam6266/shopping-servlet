//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//import entity.User;
//import service.Sendemailservice;
//
//
///**
// * Servlet implementation class Sendemail
// */
//@WebServlet("/Sendemail")
//public class Sendemail extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private String host;
//	private String port;
//	private String user;
//	private String pass;
//
//	public void init() {
//		// reads SMTP server setting from web.xml file
//	
//		host = "smtp.gmail.com";
//		port = "587";
//		user = "quynhvanamforever@gmail.com";
//		pass = "uercnozjwtpmdsaa";
//	}
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public Sendemail() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//
//		User usersession = (User) session.getAttribute("user");
//		String recipient = usersession.getEmail();
//		System.out.println(recipient);
//        String subject = "thông báo mua hàng";
//        String content = "cảm ơn bạn đã mua hàng";
// 
//        String resultMessage = "";
// 
//        try {
//        	Sendemailservice.Sendemail1(host, port, user, pass, recipient, subject,
//                    content);
//            resultMessage = "The e-mail was sent successfully";
//            System.out.println(resultMessage);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            resultMessage = "There were an error: " + ex.getMessage();
//            System.out.println(resultMessage);
//        } finally {
//            request.setAttribute("Message", resultMessage);
//            RequestDispatcher dispatcher = request
//    				.getRequestDispatcher("Sendemail.jsp");
//    		dispatcher.forward(request, response);
//        }
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
