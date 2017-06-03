package org.endless.user.service;

import org.endless.user.dao.interfac.ProfileDao;
import org.endless.user.dao.interfac.SubscriberDao;
import org.endless.user.domain.Profile;
import org.endless.user.domain.Subscriber;
import org.endless.user.service.interfac.UserService;
import org.endless.util.common.StringTools;
import org.endless.util.dao.DaoUtils;
import org.endless.util.dao.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private SubscriberDao subDao;
	private ProfileDao profileDao;

	/**
	 * 创建用户
	 * 
	 * @param subscriber
	 * @return
	 */
	@Transactional
	@Override
	public int createUser(Subscriber subscriber) {
		if (StringTools.isEmpty(subscriber.getEmail())) {
			subscriber.setEmail("");
		}
		if (StringTools.isEmpty(subscriber.getLogin())) {
			subscriber.setLogin("");
		}
		if (StringTools.isEmpty(subscriber.getPhone())) {
			subscriber.setPhone("");
		}

		if (StringTools.hasContent(subscriber.getEmail()) || StringTools.hasContent(subscriber.getPhone())
				|| StringTools.hasContent(subscriber.getLogin())) {
			if (StringTools.hasContent(subscriber.getPasswd())) {
				subscriber.setId(DaoUtils.uuid());
				subscriber.setSalt(PasswordHelper.encryptSalt(null));
				subscriber.setPasswd(PasswordHelper.encryptPassword(subscriber.getPasswd(), subscriber.getSalt()));

				// 保存属性信息
				if (subscriber.getProfile() == null) {
					subscriber.setProfile(new Profile());
					byte sex = 1;
					subscriber.getProfile().setSex(sex);
				}

				subscriber.getProfile().setId(subscriber.getId());
				profileDao.insert(subscriber.getProfile());

				return subDao.insert(subscriber);
			}
		}
		return 0;
	}

	@Transactional(readOnly = true)
	@Override
	public Subscriber getUserInfo(String id) {
		if (StringTools.hasContent(id)) {
			Subscriber sub = subDao.selectByPrimaryKey(id);
			if (sub != null) {
				Profile profile = profileDao.selectByPrimaryKey(id);
				sub.setProfile(profile);
			}
			return sub;
		}
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Subscriber getUserByIdentity(String identity) {
		Subscriber sub = null;
		if (StringTools.hasContent(identity)) {
			sub = subDao.selectByidentity(identity);
		}

		return sub;
	}

	public SubscriberDao getSubDao() {
		return subDao;
	}

	@Autowired
	public void setSubDao(SubscriberDao subDao) {
		this.subDao = subDao;
	}

	public ProfileDao getProfileDao() {
		return profileDao;
	}

	@Autowired
	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

}
