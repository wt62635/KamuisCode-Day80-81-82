package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException,
					IOException {
		//通过继承自GenericServlet提供的方法
		//来获得Servlet上下文
		ServletContext sctx = 
				getServletContext();
		System.out.println("sctx:" + sctx);
		
		
		//将数据绑订到Servlet上下文
		sctx.setAttribute("username",
				"花千骨");
		
		
		HttpSession session  = 
				request.getSession();
		session.setAttribute("city", "金陵");
		
	}
	
	

}




