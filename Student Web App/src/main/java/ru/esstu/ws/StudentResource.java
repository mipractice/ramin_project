package ru.esstu.ws;

import ru.esstu.db.model.Student;
import ru.esstu.db.service.i.StudentService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
@Path("student")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StudentResource {

    @EJB
    StudentService service;

    @GET
    @Path("getall")
    public List<Student> getAllStudent() {
        return service.getAll();
    }

    @GET
    @Path("get/{id}")
    public Response getStudent(@PathParam("id") int id) {
        Student student = (Student) service.getId(id);
        if (student == null) {
            throw new NotFoundException();
        }
        return Response.ok(student).build();
    }
}
