package com.signant.step_definitions;

import com.signant.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIUpdatePersonalInfoStepDef {

    String token;
    Response response;

    @Given("the user is authenticated in the system")
    public void the_user_is_authenticated_in_the_system() {
       token = "MTAwNjY0OTY3NDcwNjU5MzcxNzI0ODkzNDE4NjkyNDMzOTM3OTQ1";
    }

    @When("the user sends correct request to update the personal information")
    public void the_user_sends_correct_request_to_update_the_personal_information() {

        String url = ConfigurationReader.get("baseuri") + "/api/user/{username}";

        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("username", "Phill99");
        infoMap.put("firstname", "Phillip");
        infoMap.put("lastname", "Davis");
        infoMap.put("phone", "362211221");
        infoMap.put("password", "Phillip123");

        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("username", "Phill")
                .and().body(infoMap)
                .when().put(url);

    }

    @Then("the status code will be {int}")
    public void the_status_code_will_be(int expectedStatusCode) {
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),expectedStatusCode);
    }

}
