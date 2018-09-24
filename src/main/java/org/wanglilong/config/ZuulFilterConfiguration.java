package org.wanglilong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.filters.ZuulServletFilter;

@Configuration
public class ZuulFilterConfiguration {

	@Bean
	public ZuulServletFilter zuulServletFilter(){
		return new ZuulServletFilter();
	}
}
