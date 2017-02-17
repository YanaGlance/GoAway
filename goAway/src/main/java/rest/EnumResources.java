package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.Response;

import domain.model.EnumDictionary;

@Path("/enumDictionary")
@Stateless
public class EnumResources {


    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnumDictionary> getAll(){
        return em.createNamedQuery("enumDictionary.all",EnumDictionary.class).getResultList();
    }
    
    @GET
    @Path("/{enumerationName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("enumerationName") String enumerationName){
        EnumDictionary result = em.createNamedQuery("enumDictionary.enumerationName",EnumDictionary.class)
        		.setParameter("enumerationName", enumerationName).getSingleResult();
        if(result == null)
        {
         return Response.status(404).build();
        }
        else
        {
         return Response.ok(result).build();
        }    		
    }
}
