package org.endless.util.dao;

import java.util.UUID;

public class DaoUtils {
	public static String uuid() {
		return UUID.randomUUID().toString();
	}
}
