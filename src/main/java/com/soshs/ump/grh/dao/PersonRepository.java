/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soshs.ump.grh.dao;

import com.soshs.ump.grh.jpa.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author mabs
 */
@Stateless
public class PersonRepository {

    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext
    private EntityManager em;

    public Person create(Person person) {
        logger.info("Creating person " + person.getCin());
        em.persist(person);

        return person;
    }

    public List<Person> findAll() {
        logger.info("Getting all person");
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Optional<Person> findById(Integer id) {
        logger.info("Getting person by id " + id);
        return Optional.ofNullable(em.find(Person.class, id));
    }

    public void delete(Integer id) {
        logger.info("Deleting person by id " + id);
        var person = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        em.remove(person);
    }

    public Person update(Person person) {
        logger.info("Updating person " + person.getCin());
        return em.merge(person);
    }
}