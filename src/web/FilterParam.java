package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterParam implements Filter
{
	FilterConfig m_conf;
	
	@Override
	public void init(FilterConfig conf) throws ServletException
	{
		m_conf = conf;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException
	{
		req.setAttribute("filter-param", m_conf.getInitParameter("admin"));
		chain.doFilter(req, rsp);
	}
}
