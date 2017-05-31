package org.endless.util.service;

/**
 * 用户身份标识的类型,是手机,邮箱还是loginname
 * 
 * @author harvey 2017年2月28日<br>
 *         version:
 */
public enum IdentityType {
	lognname("登录名"), phone("手机号"), email("邮箱");
	private final String name;

	private IdentityType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
