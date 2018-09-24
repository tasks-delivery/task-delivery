package com.task.delivery.web;

import com.task.delivery.RestTest;
import com.task.delivery.model.User;
import com.task.delivery.service.user.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;

public class DashboardControllerTest extends RestTest{

    UserService userService;

    @BeforeClass
    public void setUp(){
        given(spec)
                .param("username", "testdashboard")
                .param("password", "password")
                .param("passwordConfirm", "password").
                when().
                post("/registration").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

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
                auth().basic("testdashboard","password").
                when().
                get("/dashboard").
                then().
                statusCode(200).
                extract().response().print();
    }

}