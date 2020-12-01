package com.stackroute.keepnote.netflixzuulapigatewayserver;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/*
 * Implement zuul logging filter by extending zuul filter
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException { 
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		logger.info("==========Inside Zuul Logging filter================");
		
		final String authHeader = req.getHeader("authorization");
		if(null != authHeader) {
			ctx.addZuulRequestHeader("authorization", authHeader);
		}
		
		logger.info("Under Log Filter: Request Method - " + req.getMethod() + "Request URL - " + req.getRequestURL().toString() );
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
}
