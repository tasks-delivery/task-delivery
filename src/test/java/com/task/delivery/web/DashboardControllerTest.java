package com.task.delivery.web;

import com.task.delivery.RestTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DashboardControllerTest extends RestTest{

    /*
    TODO: BUG (Actual result: return 200 error)
     */
    @Test(enabled = false, description = "should be return error 403 from endpoint '/dashboard'")
    public void getDashboardPageWithInvalidToken(){
        given(spec).
                when().
                get("/dashboard").
                then().
                statusCode(403).
                extract().response().print();
    }

    /*
    TODO: Add method for parse token
     */
    @Test(enabled = false, description = "should be return status code 303 from endpoint '/dashboard'")
    public void getDashboardPageWithValidToken(){
        given(spec).
                when().
                get("/dashboard").
                then().
                statusCode(303).
                extract().response().print();
    }

}