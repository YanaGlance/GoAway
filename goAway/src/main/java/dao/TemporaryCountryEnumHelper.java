package dao;

import domain.App;
import domain.model.Country;
import domain.model.EnumDictionary;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TemporaryCountryEnumHelper {

	public void insertCountryEnums() {
		RepositoryCatalog repo = null;
        try {
            repo = new RepositoryCatalog(App.CONNECTION_STRING);
            EnumDictionaryRepository enumRepo = (EnumDictionaryRepository) repo.Dictionaries();

            for (int i=0 ;i<Country.values().length;i++){
                
                EnumDictionary enumDict=new EnumDictionary();
                
                enumDict.setEnumerationName("Country");
                enumDict.setValue(Country.values()[i].getLongName());
                enumDict.setIntKey(Country.values()[i].getIntKey());
                enumDict.setStringKey(Country.values()[i].toString());
                enumRepo.add(enumDict);
            }
            
            repo.saveAndClose();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}
}