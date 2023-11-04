package rs.common;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class GlobalRestController implements GlobalRestApi {

    @Override
    public Response ping(Long error) {
        if (error == null) {
            return Response.ok().build();
        }
        throw new RuntimeException("Custom error Global");
    }
}
