package rest;

import domain.model.Reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

@Path("reservations")
@Stateless
public class ReservationResources{
	
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Reservation> teams = new ArrayList<>();
        for (Reservation r : entityManager
                .createNamedQuery("reservation.all", Reservation.class)
                .getResultList())
            teams.add(r);
        return Response.ok(new GenericEntity<List<Reservation>>(teams) {
        }).build();
}
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Add(Reservation reservation) {
        entityManager.persist(reservation);
        return Response.ok(reservation.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Reservation result = entityManager.createNamedQuery("reservation.id", Reservation.class)
                .setParameter("reservationId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }
}