package ru.esstu.ws.resource;

import ru.esstu.db.model.Region;
import ru.esstu.db.service.i.RegionService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by RRM on 16.05.17.
 */
@Path("/region")
@Produces(MediaType.APPLICATION_XML)
public class RegionResource {

    @EJB
    RegionService service;

    @GET
    @Path("/getall")
    public List<Region> getRegions() {
        return service.getAll();
    }
}
