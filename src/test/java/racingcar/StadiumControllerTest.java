package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.core.Is.is;

@DisplayName("Http Method")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StadiumControllerTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("자동차 경기 시작 및 결과 받아오기")
    @Test
    void postCar() {
        HashMap<String, Object> requestParam = new HashMap<>();

        requestParam.put("names", "lucas,cyan");
        requestParam.put("count", 50);

        RestAssured.given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(requestParam)
                .when().post("/racing")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
//                .body("size()", is(2));

    }



}
