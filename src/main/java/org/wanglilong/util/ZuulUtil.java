package org.wanglilong.util;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.util.HTTPRequestUtils;

public class ZuulUtil {

	public static String getQueryParam(String key){
		RequestContext ctx = RequestContext.getCurrentContext();
		HTTPRequestUtils.getInstance().getQueryParams();
		if (ctx.getRequestQueryParams() == null)
		{
			return null;
		}
		List<String> routeHost = ctx.getRequestQueryParams().get(key);
		if (routeHost!=null && routeHost.size()==1){
			return routeHost.get(0);
		}
		return null;
	}
	
	public static String getCookieValue(String name){
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies == null){
			return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (name.equalsIgnoreCase(cookie.getName())){
				return cookie.getValue();
			}
		}
		return null;
	}
}
