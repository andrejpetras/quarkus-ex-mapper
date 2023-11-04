package rs.v1;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@ApplicationScoped
public class PingRestControllerV1 implements PingRestApiV1 {

    @Override
    public Response ping(Long error) {
        if (error == null) {
            return Response.ok().build();
        }
        throw new RuntimeException("Custom error V1");
    }

    @ServerExceptionMapper
    public Response exception(Exception ex) {
        Log.info("Error V1");
        return Response.serverError().entity("ServerExceptionMapperV1: " + ex.getMessage()).build();
    }
}
