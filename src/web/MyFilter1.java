package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter
{
	@Override
	public void init(FilterConfig conf) throws ServletException
	{
		System.out.println(">> MyFilter-1 init");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException
	{
		System.out.println(">> MyFilter-1 doFilter start");
		
		chain.doFilter(req, rsp);
		
		System.out.println(">> MyFilter-1 doFilter end");
	}
	
	@Override
	public void destroy()
	{
		System.out.println(">> MyFilter-1 destory");
	}
}
