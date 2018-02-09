package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class UserControllerTest  extends RestTest{

    @BeforeClass(description = "Should be add new account to system from endpoint")
    public void preconditions(){
        given(spec)
                .param("username", "testuser")
                .param("password", "password")
                .param("passwordConfirm", "password").
                when().
                post("/registration").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /*
    TODO: BUG (Add validation  on back-end side)
     */
    @Test(enabled = false)
    public void createUserWithaLotOfSymbols(){
        given(spec)
                .param("username", "te")
                .param("password", "password")
                .param("passwordConfirm", "password").
                when().
                post("/registration").
                then().
                header("Location", "http://localhost:8080/registration").
                statusCode(200).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /*
    TODO: BUG (Add validation  on back-end side)
     */
    @Test(enabled = false)
    public void createDuplicateUser(){
        given(spec)
                .param("username", "testuser")
                .param("password", "password")
                .param("passwordConfirm", "password").
                when().
                post("/registration").
                then().
              //  header("Location", "http://localhost:8080/registration").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "should be return registration page from endpoint '/registration'")
    public void getRegistrationPage(){
        Response response = given(spec).get("/registration");
        assertThat(response.statusCode()).isEqualTo(OK.value());
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
                header("Location", "http://localhost:8080/registration").
                statusCode(200).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "should be return login page from endpoint '/login'")
    public void getLoginPage(){
        Response response = given(spec).get("/login");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }

    @Test( description = "Should be login to system")
    public void loginToSystem(){
        given(spec)
                .param("username", "testuser")
                .param("password", "password").
                when().
                post("/login").
                then().
                statusCode(302).
                header("Location", "http://localhost:8080/dashboard").
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "should be login to system from endpoint '/login'")
    public void loginToSystemWithNonExistingUser(){
        given(spec)
                .param("username", "testusesdfrcore")
                .param("password", "testpasdfssword").
                when().
                post("/login").
                then().
                header("Location", "http://localhost:8080/login?error").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test( description = "should be perform to logout from the system")
    public void logoutFromSystem(){
        given(spec).
                auth().basic("testuser","password").
                when().
                post("/logout").
                then().
                statusCode(302).
                header("Location", "http://localhost:8080/login?logout").
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}