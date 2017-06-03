package org.endless.user.dao.interfac;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.endless.user.domain.Subscriber;
import org.endless.user.domain.SubscriberExample;

public interface SubscriberDao {
	long countByExample(SubscriberExample example);

	int insert(Subscriber record);

	int insertSelective(Subscriber record);

	List<Subscriber> selectByExample(SubscriberExample example);

	Subscriber selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

	int updateByExample(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

	int updateByPrimaryKeySelective(Subscriber record);

	int updateByPrimaryKey(Subscriber record);

	/**
	 * @param identity
	 *            手机号邮箱或登录名
	 * @return
	 */
	Subscriber selectByidentity(String identity);

	/**
	 * 批量插入,测试使用
	 * 
	 * @param record
	 * @return
	 */
	@Deprecated
	int insertBatch(List record);
}