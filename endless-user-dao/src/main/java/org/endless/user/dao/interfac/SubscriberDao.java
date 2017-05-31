package org.endless.user.dao.interfac;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.endless.user.domain.Subscriber;
import org.endless.user.domain.SubscriberExample;

public interface SubscriberDao {
    long countByExample(SubscriberExample example);

    int deleteByExample(SubscriberExample example);

    int deleteByPrimaryKey(String id);

    int insert(Subscriber record);

    int insertSelective(Subscriber record);

    List<Subscriber> selectByExample(SubscriberExample example);

    Subscriber selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

    int updateByExample(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

    int updateByPrimaryKeySelective(Subscriber record);

    int updateByPrimaryKey(Subscriber record);
}