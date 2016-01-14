package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource("classpath:spring-importresource.xml")
public class MyImportResource {
	
	@Value("${url}")
	private String url;
	
	@Value("${username}")
	private String username1;
	
	@Value("${jdbc.username}")
	private String username2;
	
	@Value("${password}")
	private String password;
	
	@Bean(name="myImportRes")
	@Scope("singleton")
	public MyImportRes myImportRes() {
		return new MyImportRes(url, username1, username2, password);
	}

}
