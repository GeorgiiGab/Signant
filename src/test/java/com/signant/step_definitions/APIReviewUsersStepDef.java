package com.signant.step_definitions;

import com.signant.utilities.APIUtilities;
import com.signant.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class APIReviewUsersStepDef {

    String token;
    Response response;

    @Given("the user is correctly authenticated with username {string} and password {string}")
    public void the_user_is_correctly_authenticated_with_username_and_password(String username, String password) {
        token = APIUtilities.getToken(username, password);
    }

    @When("the user sends correct request")
    public void the_user_sends_correct_request() {

        String url = ConfigurationReader.get("baseuri") + "/api/users";

         response = given().accept(ContentType.JSON)
                .and().header("token", token)
                .when().get(url);

    }

    @Then("status code must be {int}")
    public void status_code_must_be(int expectedStatusCode) {

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),expectedStatusCode);
    }

    @Given("the user is not authenticated")
    public void the_user_is_not_authenticated() {
       token = "abc";
    }

    @When("the user sends incorrect request")
    public void the_user_sends_incorrect_request() {

        String url = ConfigurationReader.get("baseuri") + "/api/user";

        response = given().accept(ContentType.JSON)
                .and().header("token", token)
                .when().get(url);
    }
}
