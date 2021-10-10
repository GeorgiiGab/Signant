package com.signant.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIUtilities {

    public static String getToken(String username, String password) {
        String url = ConfigurationReader.get("baseuri") + "/api/auth/token";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().preemptive().basic(username, password)
                .when().get(url);

        response.prettyPrint();

        JsonPath jsonData = response.jsonPath();

        String accessToken = jsonData.getString("token");

        return accessToken;


    }
}
