import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .body("some data")
                // Выполняемые действия
                .when()
                .post("/post")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"));
    }
}