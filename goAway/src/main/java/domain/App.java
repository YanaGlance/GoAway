package domain;

import dao.*;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

public class App {
	
	public static final String CONNECTION_STRING="jdbc:hsqldb:hsql://localhost/workdb";
	
	public static void main(String[] args) {
    
    }
}
