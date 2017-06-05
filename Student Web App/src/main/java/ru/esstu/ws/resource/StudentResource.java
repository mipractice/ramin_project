package ru.esstu.ws.resource;

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
@Path("/student")
@Produces(MediaType.APPLICATION_XML)
public class StudentResource {

    @EJB
    StudentService service;

    @PUT
    @Path("/create")
    public Student create(
            @QueryParam("firstname") String firstname,
            @QueryParam("surname") String surname,
            @QueryParam("gender") String gender,
//            @QueryParam("birthday") String birthday,
            @QueryParam("address") String address,
            @QueryParam("phone") String phone,
            @QueryParam("city") int city) {

        Student student = new Student();
        student.setFirstname(firstname);
        student.setSurname(surname);
        student.setGender(gender);
//        student.setBirthday(new Date());
        student.setAddress(address);
        student.setPhone(phone);
//        student.setCity(new City(city));

        return (Student) service.add(student);
    }

    @GET
    @Path("/getall")
    public List<Student> getAllStudent() {
        return service.getAll();
    }

    @GET
    @Path("/get/{id}")
    public Response getStudent(@PathParam("id") int id) {
        Student student = (Student) service.getId(id);
        if (student == null) {
            throw new NotFoundException();
        }
        return Response.ok(student).build();
    }

    @GET
    @Path("/delete/{id}")
    public void deleteStudent(@PathParam("id") int id) {
        service.delete(id);
    }

}
