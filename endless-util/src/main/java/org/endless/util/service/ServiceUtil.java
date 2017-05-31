package org.endless.util.service;

/**
 * 提供逻辑层的通用方法
 * 
 * @author harvey 2017年2月28日<br>
 *         version:
 */
public class ServiceUtil {
	private ServiceUtil() {
	}

	/**
	 * 判断用户登录输入的是邮箱还是手机号
	 * 
	 * @param identity
	 * @return
	 */
	public static IdentityType getIdentityType(String identity) {
		if (identity == null || ("").equals(identity.trim())) {
			return null;
		}
		if (identity.matches("^1[3|4|5|8][0-9]\\d{8}$")) {
			return IdentityType.phone;
		}
		if (identity.matches("^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$")) {
			return IdentityType.email;
		}
		if (identity.matches("^[A-Za-z][A-Za-z1-9_-]+$")) {
			return IdentityType.lognname;
		}
		return null;
	}
}
