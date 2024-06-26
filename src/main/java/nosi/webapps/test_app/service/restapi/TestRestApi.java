package nosi.webapps.test_app.service.restapi;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class TestRestApi {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ListProducts() {

        System.out.println("---------------- END mail");
        return Response.status(Response.Status.OK).entity("Email sended with success").build();
        //return "Email sended with success";
    }
}