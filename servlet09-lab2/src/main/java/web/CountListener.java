package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements 
	HttpSessionListener{

	/**
	 * session对象创建之后，容器会立即
	 * 调用此方法。
	 * 	arg0:事件对象，可以通过该对象来获得
	 * session对象。
	 */
	public void sessionCreated(
			HttpSessionEvent arg0) {
		System.out.println("CountListener's "
				+ "sessionCreated");
		//先获得session对象
		HttpSession session = arg0.getSession();
		//然后通过session对象获得Servlet上下文
		ServletContext sctx = 
				session.getServletContext();
		//通过Servlet上下文获得在线人数
		Integer count = 
				(Integer)sctx.getAttribute(
						"count");
		if(count == null){
			//这是第一个用户，在线人数设置为1
			count = 1;
		}else{
			//不是第一个用户，在线人数加1
			count ++;
		}
		//将在线人数绑订到Servlet上下文
		sctx.setAttribute("count", count);
		
	}

	/**
	 * session对象销毁之后，容器会调用
	 * 此方法。
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


