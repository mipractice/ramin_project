package ru.esstu.ws.resource;

import ru.esstu.db.model.City;
import ru.esstu.db.model.Country;
import ru.esstu.db.service.i.CityService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by RRM on 16.05.17.
 */

@Path("/city")
@Produces(MediaType.APPLICATION_XML)
public class CityResource {

    @EJB
    CityService service;

    @GET
    @Path("/getall")
    public List<City> getCities() {
        return service.getAll();
    }

    @GET
    @Path("/get/{id}")
    public Response getCity(@PathParam("id") int id) {

        City city = (City) service.getId(id);
        if (city == null)
            throw new NotFoundException();

        return Response.ok(city).build();
    }
}
