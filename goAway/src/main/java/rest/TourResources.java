package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.model.Tour;

@Path("tours")
@Stateless
public class TourResources {
	
	@PersistenceContext
	EntityManager entityManager;
	
	   @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response Add(Tour tour) {
	        entityManager.persist(tour);
	        return Response.ok(tour.getId()).build();
	    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Tour> teams = new ArrayList<>();
        for (Tour t : entityManager
                .createNamedQuery("tour.all", Tour.class)
                .getResultList())
            teams.add(t);
        return Response.ok(new GenericEntity<List<Tour>>(teams) {
        }).build();
}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Tour result = entityManager.createNamedQuery("tour.id", Tour.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
}
