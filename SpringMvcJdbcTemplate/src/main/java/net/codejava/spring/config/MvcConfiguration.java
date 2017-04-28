package net.codejava.spring.config;

import javax.sql.DataSource;

import net.codejava.spring.dao.AccountDAO;
import net.codejava.spring.dao.AccountDAOImpl;
import net.codejava.spring.dao.CostumerDAO;
import net.codejava.spring.dao.CostumerDAOImpl;
import net.codejava.spring.dao.EmployeeDAO;
import net.codejava.spring.dao.EmployeeDAOImpl;
import net.codejava.spring.dao.LoginDAO;
import net.codejava.spring.dao.LoginDAOImpl;
import net.codejava.spring.dao.ManagerDAO;
import net.codejava.spring.dao.ManagerDAOImpl;
import net.codejava.spring.dao.TransactionDAO;
import net.codejava.spring.dao.TransactionDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource ResourceMessage(){
		ReloadableResourceBundleMessageSource resolver = new ReloadableResourceBundleMessageSource();
	resolver.setBasename("/WEB-INF/conf/messages.properties");
	return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Bank");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	

	
	@Bean
	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl(getDataSource());
	}
	
	@Bean
	public CostumerDAO getCostumerDAO() {
		return new CostumerDAOImpl(getDataSource());
	}
	
	@Bean
	public AccountDAO getAccountDAO() {
		return new AccountDAOImpl(getDataSource());
	}
	
	@Bean
	public ManagerDAO getManagerDAO() {
		return new ManagerDAOImpl(getDataSource());
	}
	
	@Bean
	public TransactionDAO getTransactionDAO() {
		return new TransactionDAOImpl(getDataSource());
	}
	
	@Bean
	public LoginDAO getLoginDAO() {
		return new LoginDAOImpl(getDataSource());
	}
}
