package spring;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MyResource implements ApplicationContextAware {
	
	private ApplicationContext mContext;
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		mContext = context;
	}
	
	public void getResource() {
		Resource r = mContext.getResource("classpath:res.txt");
		System.out.println("文件名: " + r.getFilename());
		try {
			System.out.println("文件大小: " + r.contentLength());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
