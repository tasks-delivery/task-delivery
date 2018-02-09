package com.task.delivery.web;

import com.task.delivery.RestTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DashboardControllerTest extends RestTest{

    @Test( description = "should be return error 401 from endpoint '/dashboard'")
    public void getDashboardPageWithInvalidToken(){
        given(spec).
                when().
                get("/dashboard").
                then().
                statusCode(401).
                extract().response().print();
    }

    @Test(description = "should be return status code 200 from endpoint '/dashboard'")
    public void getDashboardPageWithValidToken(){
        given(spec).
                auth().basic("testuser","password").
                when().
                get("/dashboard").
                then().
                statusCode(200).
                extract().response().print();
    }

}