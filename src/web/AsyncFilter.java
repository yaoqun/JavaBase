package web;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
		filterName="AsyncFilter", value="/async",
		dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.ASYNC },
		asyncSupported = true
)
public class AsyncFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException
	{
		System.out.println("Filter-async start");
		chain.doFilter(req, rsp);
		System.out.println("Filter-async end");
	}
}
