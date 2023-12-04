package rs.v1;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.OK;

@QuarkusTest
@TestHTTPEndpoint(PingRestControllerV1.class)
class PingRestControllerV1Test extends AbstractTest {

    @Test
    void test1() {

        var body = given()
                .contentType(APPLICATION_JSON)
                .get()
                .then().statusCode(OK.getStatusCode())
                .extract().as(String.class);

        Assertions.assertEquals("100", body);
    }
}
