package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.*;

public class ReservationMapper implements IMapResultSetIntoEntity {
	
    public Reservation map(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getInt("id"));
        reservation.setName(rs.getString("name"));
        reservation.setSurname(rs.getString("surname"));
        reservation.setCountryFrom(rs.getString("country from"));
        reservation.setCountryTo(rs.getString("country to"));
        reservation.setAmountOfDays(rs.getString("amount of days"));

        return reservation;
    }
}