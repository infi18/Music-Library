/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.service.SongsService;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author siddhi
 */
@FacesConverter(value = "songsConverter", managed = true)
public class SongsConverter  implements Converter<Songs>{
    
    @EJB SongsService songsServ;

    @Override
    public Songs getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value == null || value.isEmpty()) {
            return null;
        }

        return songsServ.find(Long.valueOf(value));
    
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Songs value) {

            if (value == null) {
            return "";
        }
        return String.valueOf(value.getId());
    }

    
}
