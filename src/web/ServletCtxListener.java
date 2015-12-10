package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletCtxListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		String s = sce.getServletContext().getInitParameter("servlet-ctx-param");
		System.out.println(">> Servlet-Ctx-Listener init\n" +
				"    初始化参数值: " + s);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		System.out.println(">> Servlet-Ctx-Listener destory");
	}
}
