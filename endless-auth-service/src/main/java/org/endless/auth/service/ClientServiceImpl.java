package org.endless.auth.service;

import org.endless.auth.dao.interfac.ClientDao;
import org.endless.auth.domain.Client;
import org.endless.auth.service.interfac.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;

	@Transactional
	@Override
	public void createClient(Client client) {
		getClientDao().insert(client);
	}

	@Transactional
	@Override
	public Client findByClientId(String clientId) {
		Client result = getClientDao().selectByClientId(clientId);
		return result;
	}

	@Transactional
	@Override
	public Client findByPrimaryKey(Long id) {
		Client result = getClientDao().selectByPrimaryKey(id);
		return result;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	@Autowired
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}
