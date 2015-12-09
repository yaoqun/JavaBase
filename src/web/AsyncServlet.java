package web;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsyncServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
	{
		System.out.println("AsyncServlet start");
		
		AsyncContext asyncCtx = req.startAsync();
		new Thread(new Task(asyncCtx)).start();
		
		System.out.println("AsyncServlet end");
	}
	
	class Task implements Runnable
	{
		private AsyncContext m_ctx;
		public Task(AsyncContext ctx) {
			m_ctx = ctx;
		}
		
		@Override
		public void run() {
			try { Thread.sleep(3000); }
			catch (Exception e) { }
						
			HttpServletRequest req = (HttpServletRequest) m_ctx.getRequest();
			System.out.println("async-task end, url: " + req.getRequestURI());
		}
	}
}
