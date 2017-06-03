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

	@Override
	public String toString() {
		return "Profile [id=" + id + ", sex=" + sex + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}