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

    @Test(description = "should be return login page from endpoint '/login'")
    public void getLoginPage(){
        Response response = given(spec).get("/login");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }
    /*
           TODO: make parse CSRF token for testing
     */
    @Test(enabled = false, description = "should be login to system from endpoint '/login'")
    public void loginToSystem(){
        given(spec).
                body("{\"username=testuser&password=testpassword\"}").
                when().
                post("/login").
                then().
                statusCode(302).
                extract().response().print();
    }
    /*
       TODO: make parse CSRF token for testing
        */
    @Test(enabled = false, description = "should be logout from system from endpoint '/login'")
    public void logoutFromSystem(){
        given(spec).
                when().
                post("/logout").
                then().
                statusCode(302).
                extract().response().print();
    }

    /*
    TODO:   make parse CSRF token for testing
     */
    @Test(description = "should be login to system from endpoint '/login'")
    public void logisnToSystemWithNonExistingUser(){
        given(spec).
                body("{\"username=usernonexist&password=passnonexist\"}").
                when().
                post("/logout").
                then().
                statusCode(403).
                extract().response().print();
    }

}