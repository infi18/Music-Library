/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.config;

import edu.iit.sat.itmd4515.snaik10.domain.Genre;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author siddhi
 */
@Named
@ApplicationScoped
public class ApplicationConfiguration {

    /**
     *
     */
    public ApplicationConfiguration() {
    }
    
    /**
     *
     * @return
     */
    public Genre[] getGenres(){
        return Genre.values();
    }
    
}
