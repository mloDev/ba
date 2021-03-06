package de.mlo.ba;

import java.util.EnumSet;

import org.h2.tools.Server;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import de.mlo.ba.config.SecurityConfig;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

/**
 * Created by Manuel.
 */

@EnableAutoConfiguration
@ComponentScan
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Application extends SpringBootServletInitializer {
	
	@Value("${init.json}")
	private String init;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class, Initializer.class);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean rewriteFilter() {
        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
    
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
    	Resource sourceData;
    	Jackson2RepositoryPopulatorFactoryBean factory;
		try {
			sourceData = new PathResource(init);
			if(!sourceData.exists())
				sourceData = new ClassPathResource(init);
			factory = new Jackson2RepositoryPopulatorFactoryBean();
			factory.setResources(new Resource[] { sourceData });
		} catch (Exception e) {
			return null;
		}

		return factory;
    }
    
    @Bean
    org.h2.tools.Server h2Server() {
        Server server = new Server();
        try {
            server.runTool("-tcp");
            server.runTool("-tcpAllowOthers");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server;

    }

}
