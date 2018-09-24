package org.wanglilong.zuul;

import javax.servlet.http.Cookie;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.wanglilong.util.ZuulUtil;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class UrlRouteHostPostZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		 return ZuulUtil.getQueryParam(FilterConsts.ROUTE_HOST)!=null;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		String routeHost = ctx.getRouteHost().toString();
		Cookie proxyRouteHostCookie = new Cookie(FilterConsts.LONG_PROYX_ROUTE_HOST, routeHost);
		ctx.getResponse().addCookie(proxyRouteHostCookie);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
	}

}
