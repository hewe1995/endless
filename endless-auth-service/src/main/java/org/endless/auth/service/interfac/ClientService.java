package org.endless.auth.service.interfac;

import org.endless.auth.domain.Client;

public interface ClientService {
	void createClient(Client client);

	Client findByClientId(String clientId);

	Client findByPrimaryKey(Long id);
}
