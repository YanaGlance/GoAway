package dao.repositories;

import java.sql.SQLException;

import domain.model.Client;

public interface IRepositoryCatalog {

	public IClientRepository Clients();
	public IEnumDictionariesRepository Dictionaries();
	public ITourRepository Tours();
	void saveAndClose();
	void save();
}
