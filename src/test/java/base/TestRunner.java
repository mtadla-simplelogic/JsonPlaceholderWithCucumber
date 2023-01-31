package base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        glue = {"steps", "base"},
        plugin = { "pretty", "html:target/html-reports.html"})
public class TestRunner {
}
