package com.signant.step_definitions;

import com.signant.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class APIRegisterStepDef {

    Response response;

    @When("the user registers using API")
    public void the_user_registers_using_API() {

        String url = ConfigurationReader.get("baseuri") + "/api/users";

         response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"John\",\n" +
                        "    \"lastname\" : \"Dorian\",\n" +
                        "    \"phone\" : \"47390003\",\n" +
                        "    \"password\" : \"qwe123\",\n" +
                        "    \"username\" : \"John\"\n" +
                        "\n" +
                        "}")
                .when().post(url);
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),expectedStatusCode);
    }

    @When("the user tries to register with username that has already been used")
    public void the_user_tries_to_register_with_username_that_has_already_been_used() {
        String url = ConfigurationReader.get("baseuri") + "/api/users";

        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"John\",\n" +
                        "    \"lastname\" : \"Dorian\",\n" +
                        "    \"phone\" : \"47390003\",\n" +
                        "    \"password\" : \"qwe123\",\n" +
                        "    \"username\" : \"John\"\n" +
                        "\n" +
                        "}")
                .when().post(url);
    }

    @When("the user doesn't fill any of the required fields during registration")
    public void the_user_doesn_t_fill_any_of_the_required_fields_during_registration() {
        String url = ConfigurationReader.get("baseuri") + "/api/users";

        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"lastname\" : \"Dorian\",\n" +
                        "    \"phone\" : \"47390003\",\n" +
                        "    \"password\" : \"qwe123\",\n" +
                        "    \"username\" : \"John\"\n" +
                        "\n" +
                        "}")
                .when().post(url);
    }
}
