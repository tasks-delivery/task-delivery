package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class AboutControllerTest extends RestTest {

    @Test(description = "should be return support page from endpoint '/about'")
    public void getAboutPage(){
        Response response = given(spec).get("/about");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }

}