package rs.common;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class GlobalExceptionMapper {

//    @ServerExceptionMapper
    public Response exception(Exception ex) {
        Log.info("Error Global");
        return Response.serverError().entity("ServerExceptionMapper: " + ex.getMessage()).build();
    }
}
