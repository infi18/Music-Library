/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author siddhi
 */
abstract class AbstractService<S> {

    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    protected Class<S> entityClass;

    public AbstractService(Class entityClass) {

        this.entityClass = entityClass;
    }

    //CRUD Services 
    public void create(S entity) {
        em.persist(entity);
    }

    public void update(S entity) {
        em.merge(entity);
    }

    public void delete(S entity) {
        em.remove(em.merge(entity));
    }

    public S find(long id) {

        return em.find(entityClass, id);
    }

    public abstract List<S> findAll();

}
