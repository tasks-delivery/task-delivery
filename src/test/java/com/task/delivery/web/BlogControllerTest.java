package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class BlogControllerTest extends RestTest{

    @Test(description = "should be return blog page from endpoint '/blog'")
    public void getBlogPage(){
        Response response = given(spec).get("/blog");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }


}