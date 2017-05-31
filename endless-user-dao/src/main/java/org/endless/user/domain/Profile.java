package org.endless.user.domain;

import java.io.Serializable;

/**
 * @author
 */
public class Profile implements Serializable {
	/**
	 * 和subscriber 的id一一对应
	 */
	private String id;

	private Byte sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}
}