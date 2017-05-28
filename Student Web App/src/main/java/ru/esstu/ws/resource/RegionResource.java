package ru.esstu.ws.resource;

import ru.esstu.db.model.Region;
import ru.esstu.db.service.i.RegionService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("/get/{id}")
    public Response getRegion(@PathParam("id") int id) {
        Region region = (Region) service.getId(id);
        if (region == null) {
            throw new NotFoundException();
        }
        return Response.ok(region).build();
    }
}
