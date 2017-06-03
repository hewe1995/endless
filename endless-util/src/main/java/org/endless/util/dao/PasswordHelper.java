package org.endless.util.dao;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.endless.util.common.StringTools;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
public abstract class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";
	private static int hashIterations = 2;

	/**
	 * 根据条件拼接盐
	 * 
	 * @param condition
	 * @return
	 */
	public static String encryptSalt(String condition) {
		if (condition == null || "".equals(condition.trim()))
			return randomNumberGenerator.nextBytes().toHex();
		return randomNumberGenerator.nextBytes().toHex() + condition;
	}

	/**
	 * 根据盐和明文密码加密成md5 密码
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encryptPassword(String password, String salt) {
		if (StringTools.isEmpty(password) || StringTools.isEmpty(salt))
			return null;
		String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(salt), hashIterations)
				.toHex();
		
		return newPassword;
	}
}
