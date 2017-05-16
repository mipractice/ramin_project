package ru.esstu.ws.resource;

import ru.esstu.db.model.City;
import ru.esstu.db.service.i.CityService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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


}
