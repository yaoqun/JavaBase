package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter2 implements Filter
{
	@Override
	public void init(FilterConfig conf) throws ServletException
	{
		System.out.println(">> MyFilter-2 init");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException
	{
		System.out.println(">> MyFilter-2 doFilter start");
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String uri = httpReq.getRequestURI();
		
		if (uri.equals("/filter_forward.jsp"))
		{
			System.out.println(">> MyFilter-2 forward");
			req.getRequestDispatcher("filter_doforward.jsp").forward(req, rsp);
		}
		
		chain.doFilter(req, rsp);
		
		System.out.println(">> MyFilter-2 doFilter end");
	}
	
	@Override
	public void destroy()
	{
		System.out.println(">> MyFilter-2 destory");
	}
}
