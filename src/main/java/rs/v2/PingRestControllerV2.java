package rs.v2;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@ApplicationScoped
public class PingRestControllerV2 implements PingRestApiV2 {

    @Override
    public Response ping(Long error) {
        if (error == null) {
            return Response.ok().build();
        }
        throw new RuntimeException("Custom error V2");
    }

    @ServerExceptionMapper
    public Response exception(Exception ex) {
        Log.info("Error V2");
        return Response.serverError().entity("ServerExceptionMapperV2: " + ex.getMessage()).build();
    }
}
