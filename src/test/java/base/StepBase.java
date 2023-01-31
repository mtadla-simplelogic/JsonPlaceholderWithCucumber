package base;

public class StepBase {
    public String baseUrl = "https://jsonplaceholder.typicode.com";
    public String posts = "/posts";
    public String users = "/users";
    public TestContext context;

    public StepBase(TestContext testContext) {
        this.context = testContext;
    }
}
