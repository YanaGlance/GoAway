package dao.repositories;

import java.util.List;

import domain.model.*;

public interface IClientRepository extends IRepository<Client>{

	public List<Tour> byClient(Client client);
}
