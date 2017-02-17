package rest;

import domain.model.Client;

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

@Path("clients")
@Stateless
public class ClientResources {

	//Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Client> teams = new ArrayList<>();
        for (Client c : entityManager
                .createNamedQuery("client.all", Client.class)
                .getResultList())
            teams.add(c);
        return Response.ok(new GenericEntity<List<Client>>(teams) {
        }).build();
}
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Add(Client client) {
        entityManager.persist(client);
        return Response.ok(client.getId()).build();
    }
    
    @Path("test")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@FormParam("name") String name){
    	return "Test" + name;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Client p) {
        Client result = entityManager.createNamedQuery("client.id", Client.class)
                .setParameter("clientId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        p.setName(p.getName());
        p.setSurname(p.getSurname());
        entityManager.persist(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Client result = entityManager.createNamedQuery("client.id", Client.class)
                .setParameter("clientId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Client result = entityManager.createNamedQuery("client.id", Client.class)
                .setParameter("clientId", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }
}
