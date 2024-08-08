package nosi.webapps.test_app.restapi.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import nosi.core.webapp.Core;

public class ApiTestResource {
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</body></h1></html>";
    }

    @Path("test")
    @GET
    @Produces("text/html")
    public String getText() {
        var app = Core.findUserById(1).getUser_name();

        return "ok /test "+ app;
    }
}
