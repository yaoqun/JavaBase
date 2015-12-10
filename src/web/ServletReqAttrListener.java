package web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ServletReqAttrListener implements ServletRequestAttributeListener
{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae)
	{
		ServletRequest req = srae.getServletRequest();
		System.out.println(">> Servlet-Req-Attr-Listener add\n" +
				"    attr-value: " + req.getAttribute("attr"));
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae)
	{
		ServletRequest req = srae.getServletRequest();
		System.out.println(">> Servlet-Req-Attr-Listener remove\n" +
				"    attr-value: " + req.getAttribute("attr"));
	}
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae)
	{
		ServletRequest req = srae.getServletRequest();
		System.out.println(">> Servlet-Req-Attr-Listener replace\n" +
				"    attr-value: " + req.getAttribute("attr"));
	}
}
