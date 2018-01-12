package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class TestController extends RestTest {
/*
    protected void createSession() {
        Response tokenResponse = given().log().all().filter(sessionFilter).
                get("/token").
                then().log().all().
                extract().response();
        sessionFilter.getSessionId();
    }*/

}
