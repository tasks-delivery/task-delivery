package com.task.delivery;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class RestTest   {

    protected RequestSpecification spec;
    private
    int port = 8080;

    @BeforeClass
    public void initSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("http://task-delivery-test-api.herokuapp.com/")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    protected JsonNode getRootJsonNode(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, JsonNode.class);
    }
}
