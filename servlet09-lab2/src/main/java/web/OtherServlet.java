package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,
					IOException {
		ServletContext sctx = 
				getServletContext();
		String username = 
				(String)sctx.getAttribute(
						"username");
		response.setContentType(
				"text/html;charset=utf-8");
		response.getWriter().println(username);
		
		HttpSession session = 
				request.getSession();
		String city =
				(String)session.getAttribute(
						"city");
		response.getWriter().println(city);
		
		//读取全局的初始化参数
		String company = 
				sctx.getInitParameter("company");
		response.getWriter().println(company);
		
		
	}
	

}
