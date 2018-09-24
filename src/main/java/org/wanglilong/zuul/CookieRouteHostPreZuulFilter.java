package org.wanglilong.zuul;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.wanglilong.util.ZuulUtil;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class CookieRouteHostPreZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return ZuulUtil.getCookieValue(FilterConsts.LONG_PROYX_ROUTE_HOST) != null;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		String routeHost = ZuulUtil.getCookieValue(FilterConsts.LONG_PROYX_ROUTE_HOST);
		try {
			ctx.setRouteHost(new URL(routeHost));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER+2;
	}

}
