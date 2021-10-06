package com.signant.step_definitions;

import com.signant.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class APIReviewPersonalInfo {

    String token;
    Response response;

    @Given("the user is properly authenticated")
    public void the_user_is_properly_authenticated() {
       token = "MTAwNjY0OTY3NDcwNjU5MzcxNzI0ODkzNDE4NjkyNDMzOTM3OTQ1";
    }

    @When("the user sends request correctly")
    public void the_user_sends_request_correctly() {

        String url = ConfigurationReader.get("baseuri") + "/api/users/{username}";

        response = given().accept(ContentType.JSON)
                .and().pathParam("username", "Phill")
                .and().header("token", token)
                .when().get(url);

    }

    @Then("the user should get the status code {int}")
    public void the_user_should_get_the_status_code(int expectedStatusCode) {

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),expectedStatusCode);
    }

    @Given("the user is not properly authenticated")
    public void the_user_is_not_properly_authenticated() {
        token = "asd";
    }

    @When("the user sends wrong request")
    public void the_user_sends_wrong_request() {
        String url = ConfigurationReader.get("baseuri") + "/api/user/{username}";

        response = given().accept(ContentType.JSON)
                .and().pathParam("username", "Phill")
                .and().header("token", token)
                .when().get(url);
    }
}
