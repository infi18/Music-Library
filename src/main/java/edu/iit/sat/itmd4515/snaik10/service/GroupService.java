/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.security.Group;
import edu.iit.sat.itmd4515.snaik10.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author siddhi
 */
@Stateless
public class GroupService extends AbstractService<Group>{

    /**
     *Constructor
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     *Fetches all the groups
     * @return
     */
    @Override
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", entityClass).getResultList();

    }
}
