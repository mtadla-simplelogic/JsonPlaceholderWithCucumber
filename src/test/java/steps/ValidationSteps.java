package steps;

import base.StepBase;
import base.TestContext;
import io.cucumber.java.en.Then;

public class ValidationSteps extends StepBase {

    public ValidationSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int code) {
        context.response.then().statusCode(code);
    }
}
