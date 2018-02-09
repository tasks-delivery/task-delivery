package com.task.delivery.web;

import com.task.delivery.RestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

public class DocsControllerTest extends RestTest {

    @Test(description = "should be return docs page from endpoint '/docs'")
    public void getDocsPage(){
        Response response = given(spec).get("/docs");
        assertThat(response.statusCode()).isEqualTo(OK.value());
    }

}