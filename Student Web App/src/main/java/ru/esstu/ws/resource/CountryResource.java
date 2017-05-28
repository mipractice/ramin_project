package ru.esstu.ws.resource;


import ru.esstu.db.model.Country;
import ru.esstu.db.service.i.CountryService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/country")
@Produces(MediaType.APPLICATION_XML)
public class CountryResource {

    @EJB
    CountryService service;

    @GET
    @Path("/getall")
    public List<Country> getAllCountry() {
        return service.getAll();
    }

    @GET
    @Path("/get/{id}")
    public Response getCountry(@PathParam("id") int id) {

        Country country = (Country) service.getId(id);
        if (country == null)
            throw new NotFoundException();

        return Response.ok(country).build();
    }
}
