package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ServletReqListener implements ServletRequestListener
{
	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println(">> Servlet-Req-Listener init\n" +
				"    url: " + req.getRequestURI());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		
	}
}
