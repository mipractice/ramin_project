package ru.esstu.ws.resource;


import ru.esstu.db.model.Country;
import ru.esstu.db.service.i.CountryService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("country")
public class CountryResource {

    @EJB
    CountryService service;

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryInJSON() {

        Country country = new Country();
        country.setId(1);
        country.setName("Russian");

        return country;

    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        return service.getAll();
    }

}
