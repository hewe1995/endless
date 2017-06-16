package org.endless.user.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.endless.user.domain.Subscriber;
import org.endless.user.service.interfac.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcountController {
	private static final Logger log = LoggerFactory.getLogger(AcountController.class);
	@Autowired
	private UserService userService;

	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	@RequestMapping("/info")
	public String userInfo(Model model) {
		Subject subject = SecurityUtils.getSubject();

		if (subject != null && subject.isAuthenticated()) {
			// 登录了
			if (subject.getPrincipal().getClass().isAssignableFrom(Subscriber.class)) {
				// 可以转换成用户
				Subscriber sub = (Subscriber) subject.getPrincipal();
				if (sub != null) {
					// 用户登录不为空
					Subscriber result = userService.getUserInfo(sub.getId());
					model.addAttribute("subscriber", result);
					return "info_page";
				}
			} else {
				// 不能转换类型
				if (log.isErrorEnabled()) {
					log.error("当前登录的subject获取的principal不能转为subscriber");
				}
				return "redirect:/error_page";
			}

		}
		// 没有登录
		return "redirect:/login";
	}
}
