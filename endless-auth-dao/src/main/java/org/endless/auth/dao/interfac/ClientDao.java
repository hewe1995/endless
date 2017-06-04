package org.endless.auth.dao.interfac;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.endless.auth.domain.Client;
import org.endless.auth.domain.ClientExample;

public interface ClientDao {
	long countByExample(ClientExample example);

	int deleteByExample(ClientExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Client record);

	int insertSelective(Client record);

	List<Client> selectByExample(ClientExample example);

	Client selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Client record, @Param("example") ClientExample example);

	int updateByExample(@Param("record") Client record, @Param("example") ClientExample example);

	int updateByPrimaryKeySelective(Client record);

	int updateByPrimaryKey(Client record);

	/**
	 * 通过clientid查找
	 * 
	 * @param clientId
	 * @return
	 */
	Client selectByClientId(String clientId);
}