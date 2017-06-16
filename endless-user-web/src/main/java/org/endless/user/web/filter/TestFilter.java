package org.endless.user.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.endless.util.common.StringTools;

public class TestFilter extends AuthenticatingFilter {

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		return null;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (StringTools.isEmpty(id))
			return false;
		// 电影是不是免费的
		// ...
		// 是免费的
		boolean isFree = false;
		if (isFree)
			return true;
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			// 用户登录了
			// service找到用户,判断是不是会员
			subject.checkPermission("");
			// 有的话放行
			// return true;
			// 没有,跳到别的页面
			// WebUtils.issueRedirect(request, response, "luj");
			return true;
		}else{
			redirectToLogin(request, response);
		}

		return false;
	}

}
