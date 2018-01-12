package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
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

    @Test(description = "Should be add new account to system from endpoint")
    public void createNewUser() {
        given(spec)
                .param("username", "testusercore")
                .param("password", "testpassword")
                .param("passwordConfirm", "testpassword").
                when().
                post("/registration").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /*
    TODO: BUG (need to add validation of back-end side)
     */
    @Test(enabled = false, description = "Should be add new account to system from endpoint")
    public void createNewUserWithInvalidData() {
        given(spec)
                .param("username", "test!")
                .param("password", "admin@")
                .param("passwordConfirm", "admin").
                when().
                post("/registration").
                then().
                statusCode(403).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test( description = "Should be login to system")
    public void loginToSystem(){
        given(spec)
                .param("username", "testusercore")
                .param("password", "testpassword").
                when().
                post("/login").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test( description = "should be perform  to logout from the system")
    public void logoutFromSystem(){
        given(spec).
                when().
                post("/logout").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /*
    TODO: BUG (need to add validation back-end side)
     */
    @Test(enabled = false, description = "should be login to system from endpoint '/login'")
    public void loginToSystemWithNonExistingUser(){
        given(spec)
                .param("username", "testusesdfrcore")
                .param("password", "testpasdfssword").
                when().
                post("/login").
                then().
                statusCode(403).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

}