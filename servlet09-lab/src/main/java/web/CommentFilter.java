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

public class CommentFilter implements Filter{
	
	private FilterConfig config;
	
	/**
	 * ��������֮�󣬻�������������ʵ������
	 * ע:
	 * 		ֻ�ᴴ��һ��ʵ����
	 */
	public CommentFilter(){
		System.out.println("commentFilter's "
				+ "constructor");
	}
	
	/**
	 * ������ɾ��������ʵ��֮ǰ������ø�ʵ����
	 * destroy������
	 * ע��
	 * 		destroy����ֻ��ִ��һ�Ρ�
	 */
	public void destroy() {
		System.out.println(
				"CommentFilter's destroy");
	}
	
	/**
	 * �������յ�����֮�󣬻���ù�����ʵ����
	 * doFilter��������������
	 * �����Ὣrequest����response����
	 * FilterChain(��������)��Ϊ�������ݽ�����
	 * ע��
	 * 	  FilterChain��һ��doFilter���������
	 * �����˸÷���������������������(�����ú���
	 * �Ĺ���������servlet)�������ж����󣬷���
	 * ��������
	 */
	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1, 
			FilterChain arg2)
			throws IOException, ServletException {
		System.out.println(
				"CommentFilter's doFilter begin");
		
		/*
		 * ��Ϊsun��˾�Ĺ�����ƣ������Ҫ��ǿ��
		 * ת��(���Ǿ������õ����ӽӿ��еķ���)��
		 * ServletRequest�ӿ���HttpServletRequest
		 * �ĸ��ӿڡ�
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
		
		//��ȡ��ʼ������
		String illegal = 
			config.getInitParameter("illegal");
		
		if(content.indexOf(illegal) != -1){
			response.getWriter()
			.println("���۰�����Υ����");
		}else{
			//���������á�
			arg2.doFilter(arg0, arg1);
		}
		
		System.out.println(
				"CommentFilter's doFilter end");
		
		
		
	}
	

	/**
	 * ʵ����֮���������������ù�����ʵ����
	 * init�����������ὫFilterConfig����
	 * �������ö������ڶ�ȡ��ʼ��������
	 * ע��
	 * 		init����ֻ��ִ��һ�Ρ�
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(
				"CommentFilter's init");
		//���������ݹ�����FilterConfig���󱣴�����
		config = arg0;
	}
	

}
