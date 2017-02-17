package dao;

import dao.mappers.EnumDictionaryMapper;
import dao.mappers.ClientMapper;
import dao.mappers.TourMapper;
import dao.repositories.*;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog {

    private IUnitOfWork uow;
    private Connection connection;

    private EnumDictionaryRepository enumRepo;
    private ClientRepository clientRepo;
    private TourRepository tourRepo;

    public RepositoryCatalog(String connectionString) throws SQLException, ClassNotFoundException {

		Class.forName("org.hsqldb.jdbcDriver");
        setConnection(getNewConnection(connectionString));
        setUow(getNewUow());

    }
    
    public IClientRepository Client() {
        if (clientRepo == null) {
            clientRepo = new ClientRepository(connection, new ClientMapper(), uow);
        }
        return clientRepo;
    }

    public IEnumDictionariesRepository Dictionaries() {
        if (enumRepo == null) {
            enumRepo = new EnumDictionaryRepository(connection,
                    new EnumDictionaryMapper(), uow);
        }
        return enumRepo;
    }

    public ITourRepository Tour() {
        if (tourRepo == null) {
            tourRepo = new TourRepository(connection, new TourMapper(), uow);
        }
        return tourRepo;
    }

    public void saveAndClose() {
        uow.saveChanges();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getNewConnection(String connectionString) throws SQLException {

        return DriverManager.getConnection(connectionString);
    }

    private IUnitOfWork getNewUow() {
        return new UnitOfWork(connection);
    }

    private void setUow(IUnitOfWork uow) {
        this.uow = uow;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

	public void save() {
        uow.saveChanges();
		
	}

	public domain.model.Client getTour() {
		// TODO Auto-generated method stub
		return null;
	}

	public IClientRepository Clients() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITourRepository Tours() {
		// TODO Auto-generated method stub
		return null;
	}

}