package com.linux.infiniscroll;

import javax.servlet.Filter;

import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    
    @Bean
    public Filter getWicketFilter() {
        WicketApplication webApplication = new WicketApplication();
        webApplication.setConfigurationType(RuntimeConfigurationType.DEVELOPMENT);
        WicketFilter filter = new WicketFilter(webApplication);
        filter.setFilterPath("/");
        return filter;
    }

}