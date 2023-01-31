package steps;

import base.StepBase;
import base.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class UsersSteps extends StepBase {

    public UsersSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I have users endpoint")
    public void i_have_users_endpoint() {
        context.request = given().baseUri(baseUrl+users);
    }
    @When("I get all users")
    public void i_get_all_users() {
       context.response = context.request.get();
    }

    @When("I get user with id {int}")
    public void i_get_user_with_id(int id) {
        context.request.pathParam("userId", id);

        context.response = context.request.get("{userId}");
    }
    @Then("User name is {string}")
    public void user_name_is(String name) {
        Assertions.assertThat(context.response.jsonPath().get("name").toString()).isEqualTo(name);
    }

    @When("I create new {string} user")
    public void i_create_new_user(String name) throws IOException {
        context.request.body(Files.readAllBytes(Paths.get("src/test/java/data/" + name + ".json")))
                .contentType(ContentType.JSON);

        context.response = context.request.post();
    }

    @Then("Body matches create user schema")
    public void body_matches_create_user_schema() {
        context.response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/schemas/userSchema.json")));
    }
}
