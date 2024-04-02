package com.soshs.ump.grh;

import com.soshs.ump.grh.resources.PersonResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CorsFilter.class);
        // Add your JAX-RS resource classes here
        resources.add(PersonResource.class);
        return resources;
    }
}
