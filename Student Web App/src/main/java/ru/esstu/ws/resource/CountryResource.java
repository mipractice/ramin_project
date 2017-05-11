package ru.esstu.ws.resource;


import ru.esstu.db.model.Country;
import ru.esstu.db.service.i.CountryService;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("country")
public class CountryResource {

    @Inject
    CountryService service;

    @GET
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
