package ru.esstu.ws;

import ru.esstu.db.model.Country;
import ru.esstu.db.service.impl.CountryImplService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;


@Path("country")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CountryResource {

//    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
//    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    CountryImplService service = new CountryImplService();

    @GET
    @Path("getall")
    public List<Country> getAll() {
        return service.getAll();
    }

//    @GET
//    @Path("get/{id}")
//    public Response getItem(@PathParam("id") int id) {
//        Country country = em.find(Country.class, id);
//
//        if (country == null) {
//            throw new NotFoundException();
//        }
//
//        return Response.ok(country).build();
//    }


}
