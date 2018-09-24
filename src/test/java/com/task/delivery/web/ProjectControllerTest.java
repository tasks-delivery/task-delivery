package com.task.delivery.web;

import com.task.delivery.RestTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.springframework.http.HttpStatus.OK;

public class ProjectControllerTest extends RestTest {

    @BeforeClass(description = "Should be add new project to system from endpoint")
    public void preconditions() {
        given(spec)
                .param("username", "testuserproject")
                .param("password", "password")
                .param("passwordConfirm", "password").
                when().
                post("/registration").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();

        given(spec)
                .auth().basic("testuserproject","password")
                .param("name", "testproject").
                when().
                post("/project").
                then().
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test( description = "should be return error 401 from endpoint '/project'")
    public void getProjectPageWithInvalidToken(){
        given(spec).
                when().
                get("/project").
                then().
                statusCode(401).
                extract().response().print();
    }

    @Test( description = "should be return project page from endpoint '/project'")
    public void getProjectPageWithValidToken(){
        given(spec).
                auth().basic("testuserproject","password").
                when().
                get("/project").
                then().
                statusCode(200).
                extract().response().print();
    }

    @Test(description = "Should not be add new project with invalid auth token")
    public void createNewProjectWithInvalidToken() {
        given(spec)
                .param("name", "testproject").
                when().
                put("/project").
                then().
                statusCode(401).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "Should not be add new project which already exists")
    public void createExistingProject() {
        given(spec).
                auth().basic("testuserproject","password")
                .param("name", "testproject").
                when().
                post("/project").
                then().
                header("Location", address+"/dashboard?success=false").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "Should not be add new project with invalid name format")
    public void createProjectWithOneSymbol() {
        given(spec).
                auth().basic("testuserproject","password")
                .param("name", "t").
                when().
                post("/project").
                then().
                header("Location", address+"/dashboard?success=false").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "Should not be add new project with invalid name format")
    public void createProjectWithManySymbols() {
        given(spec).
                auth().basic("testuserproject","password")
                .param("name", "ttttttttttttttttttttt").
                when().
                post("/project").
                then().
                header("Location", address+"/dashboard?success=false").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(description = "Should not be add new project with invalid name format")
    public void createProjectWithoutValueInProjectName() {
        given(spec).
                auth().basic("testuserproject","password")
                .param("name", "").
                when().
                post("/project").
                then().
                header("Location", address+"/dashboard").
                statusCode(302).
                extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

}