package org.endless.util.common;

/**
 * 字符串验证帮助类
 * 
 * @author hewe
 *
 */
public abstract class StringTools {
	/**
	 * 不为空,有内容
	 * 
	 * @param str
	 * @return
	 */
	public static boolean hasContent(String str) {
		if (str == null)
			return false;
		if (str.trim().equals(""))
			return false;
		return true;
	}

	/**
	 * 为空,没内容
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null)
			return true;
		if (str.trim().equals(""))
			return true;
		return false;
	}
}
