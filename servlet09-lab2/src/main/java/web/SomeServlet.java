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
		//ͨ���̳���GenericServlet�ṩ�ķ���
		//�����Servlet������
		ServletContext sctx = 
				getServletContext();
		System.out.println("sctx:" + sctx);
		
		
		//�����ݰ󶩵�Servlet������
		sctx.setAttribute("username",
				"��ǧ��");
		
		
		HttpSession session  = 
				request.getSession();
		session.setAttribute("city", "����");
		
	}
	
	

}




