package dao.repositories;

import java.util.List;

import domain.model.*;

public interface IReservationRepository extends IRepository<Client>{

	public List<Reservation> byReservation(Reservation reservation);
}
