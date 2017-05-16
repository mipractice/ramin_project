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
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {

    @EJB
    CountryService service;

    @GET
    public Country getCountryInJSON() {

        Country country = new Country();
        country.setId(1);
        country.setName("Russian");

        return country;

    }

    @GET
    @Path("/getall")
    public List<Country> getAllCountry() {
        if (service == null)
            System.out.println("service == null");
        return service.getAll();
    }

}
