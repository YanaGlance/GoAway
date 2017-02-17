package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.EnumDictionary;

public class EnumDictionaryMapper implements IMapResultSetIntoEntity{

	public EnumDictionary map(ResultSet rs) throws SQLException {
		EnumDictionary enumDictionary = new EnumDictionary();
		enumDictionary.setId(rs.getInt("id"));
		enumDictionary.setStringKey(rs.getString("StringKey"));
		enumDictionary.setValue(rs.getString("Value"));
		enumDictionary.setEnumerationName(rs.getString("EnumerationName"));
		return enumDictionary;
	}
}
