package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements 
	HttpSessionListener{

	/**
	 * session���󴴽�֮������������
	 * ���ô˷�����
	 * 	arg0:�¼����󣬿���ͨ���ö��������
	 * session����
	 */
	public void sessionCreated(
			HttpSessionEvent arg0) {
		System.out.println("CountListener's "
				+ "sessionCreated");
		//�Ȼ��session����
		HttpSession session = arg0.getSession();
		//Ȼ��ͨ��session������Servlet������
		ServletContext sctx = 
				session.getServletContext();
		//ͨ��Servlet�����Ļ����������
		Integer count = 
				(Integer)sctx.getAttribute(
						"count");
		if(count == null){
			//���ǵ�һ���û���������������Ϊ1
			count = 1;
		}else{
			//���ǵ�һ���û�������������1
			count ++;
		}
		//�����������󶩵�Servlet������
		sctx.setAttribute("count", count);
		
	}

	/**
	 * session��������֮�����������
	 * �˷�����
	 */
	public void sessionDestroyed(
			HttpSessionEvent arg0) {
		System.out.println("CountListener's "
				+ "sessionDestroyed");
		ServletContext sctx = 
				arg0.getSession()
				.getServletContext();
		Integer count = 
				(Integer)sctx.getAttribute(
						"count");
		count --;
		sctx.setAttribute("count", count);
		
	}
	

}


