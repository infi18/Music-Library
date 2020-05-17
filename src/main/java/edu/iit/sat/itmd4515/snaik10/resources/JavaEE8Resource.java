package edu.iit.sat.itmd4515.snaik10.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    
    /**
     *
     * @return
     */
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
}
