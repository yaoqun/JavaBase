package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Error404Filter implements Filter
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String uri = httpReq.getRequestURI();
		System.out.println(">> Filter-error-404 url: " + uri);
		chain.doFilter(req, rsp);
	}
}
