/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soshs.ump.grh.resources;

import com.soshs.ump.grh.dao.PersonRepository;
import com.soshs.ump.grh.jpa.Person;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author mabs
 */
@Path("persons")
public class PersonResource {
    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private PersonRepository personRepository;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Person findPerson(@PathParam("id") Integer id) {
        logger.info("Getting Person by id " + id);
        return personRepository.findById(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    public List<Person> findAll() {
        logger.info("Getting all Person");
        return personRepository.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Person create(Person person) {
        logger.info("Creating Person " + person.getCin());
        try{
            return personRepository.create(person);
        }catch (PersistenceException ex){
            logger.info("Error creating Person " + person.getCin());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        logger.info("Deleting Person by id " + id);
        try{
            personRepository.delete(id);
        }catch (IllegalArgumentException e){
            logger.info("Error deleting Person by id " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }


    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Person update(Person person) {
        logger.info("Updating Person " + person.getCin());
        try{
            return personRepository.create(person);
        }catch (PersistenceException ex){
            logger.info("Error updating Person " + person.getCin());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}