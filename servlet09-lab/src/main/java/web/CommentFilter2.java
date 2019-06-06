package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter2 implements Filter{

	/**
	 * 容器启动之后，会立即将过滤器实例化。
	 * 注:
	 * 		只会创建一个实例。
	 */
	public CommentFilter2(){
		System.out.println("commentFilter2's "
				+ "constructor");
	}
	
	/**
	 * 容器在删除过滤器实例之前，会调用该实例的
	 * destroy方法。
	 * 注：
	 * 		destroy方法只会执行一次。
	 */
	public void destroy() {
		System.out.println(
				"CommentFilter2's destroy");
	}
	
	/**
	 * 容器在收到请求之后，会调用过滤器实例的
	 * doFilter方法来处理请求。
	 * 容器会将request对象、response对象及
	 * FilterChain(过滤器链)作为参数传递进来。
	 * 注：
	 * 	  FilterChain有一个doFilter方法，如果
	 * 调用了该方法，则容器继续向后调用(即调用后面
	 * 的过滤器或者servlet)，否则，中断请求，返回
	 * 处理结果。
	 */
	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1, 
			FilterChain arg2)
			throws IOException, ServletException {
		System.out.println(
				"CommentFilter2's doFilter begin");
		
		/*
		 * 因为sun公司的过度设计，这儿需要做强制
		 * 转换(我们经常调用的是子接口中的方法)。
		 * ServletRequest接口是HttpServletRequest
		 * 的父接口。
		 */
		HttpServletRequest request = 
				(HttpServletRequest)arg0;
		HttpServletResponse response = 
				(HttpServletResponse)arg1;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		String content = 
				request.getParameter("content");
		
		if(content.length() > 10){
			response.getWriter()
			.println("评论字数过多");
		}else{
			//继续向后调用。
			arg2.doFilter(arg0, arg1);
		}
		
		System.out.println(
				"CommentFilter2's doFilter end");
		
		
		
	}
	

	/**
	 * 实例化之后，容器会立即调用过滤器实例的
	 * init方法。容器会将FilterConfig对象传
	 * 进来，该对象用于读取初始化参数。
	 * 注：
	 * 		init方法只会执行一次。
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(
				"CommentFilter's init");
	}
	

}
