package com.task.delivery.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;

public class testApp {

    @Test
    public void apptest(){
            RestAssured.defaultParser = Parser.JSON;
            given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + "3mb5uv6nmjl3l80ebsat").
                    body("{\n" +
                            "            \"accountName\": \"ordeh\",\n" +
                            "                \"projectSlug\": \"https://ci.appveyor.com/project/ordeh/task-delivery\",\n" +
                            "                \"branch\": \"windows-test\",\n" +
                            "        }").
                    when().
                    post("https://ci.appveyor.com/api/builds").



                    then().
                  //  statusCode(201).
                    extract().response().print();
            enableLoggingOfRequestAndResponseIfValidationFails();

        /*
        given()
                .contentType("application/json")
                .header("Authorization:","Bearer:3mb5uv6nmjl3l80ebsat").
                when().
                get("https://ci.appveyor.com/api/roles").
                then().
                //   statusCode(200).
                        extract().response().print();
        enableLoggingOfRequestAndResponseIfValidationFails();
        */
    }
}
