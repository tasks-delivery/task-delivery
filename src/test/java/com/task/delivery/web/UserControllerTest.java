package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class UserControllerTest  extends RestTest{

    @Test(description = "should be return registration page from endpoint '/registration'")
    public void getRegistrationPage(){
        Response response = given(spec).get("/registration");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }

}