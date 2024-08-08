package nosi.webapps.test_app.restapi;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import nosi.webapps.test_app.restapi.services.ApiTestResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApiConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ApiTestResource.class);
        return classes;
    }
}
