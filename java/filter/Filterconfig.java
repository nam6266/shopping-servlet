package filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet Filter implementation class Filterconfig
 */
@WebFilter("/*")
public class Filterconfig extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1l;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public Filterconfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResq = (HttpServletResponse) response;

		HttpSession session = httpReq.getSession();
		User sessionVal = (User) session.getAttribute("user");
		String path = httpReq.getServletPath();

		boolean isStaticResource = httpReq.getRequestURI()
				.startsWith("/shop/Style/");
		boolean isStaticResource2 = httpReq.getRequestURI()
				.startsWith("/shop/uploadsimgs/");

		if ((Objects.isNull(sessionVal)) && !Objects.equals(path, "/home")
				&& !Objects.equals(path, "/dangnhap")
				&& !Objects.equals(path, "/dangky") && !isStaticResource
				&& !isStaticResource2) {

			httpResq.sendRedirect("dangnhap");
		} else {
			chain.doFilter(request, response);
		}
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
