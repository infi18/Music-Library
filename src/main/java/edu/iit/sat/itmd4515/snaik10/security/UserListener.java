/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.security;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author siddhi
 */
public class UserListener {
    
    @Inject
    private Pbkdf2PasswordHash passwordHash;
    
    @PrePersist
    @PreUpdate
    private void hashPassword(User us) {
        
        us.setPassword(passwordHash.generate(us.getPassword().toCharArray()));
        
    }
    
}
