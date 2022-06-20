package steps;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import common.CommonUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import java.io.IOException;
import java.util.Locale;

public class ElectricityTestSteps extends CommonUtility {
    Response response;
    String mpn ,endPoint;
    DocumentContext documentContext = JsonPath.parse(getTemplate("CreateElectricityMeter.json"));

    public ElectricityTestSteps() throws IOException, ParseException {
    }

    @Given("I have a Meter Point Number")
    public void getMPN()
    {
        FakeValuesService fakeValuesService  = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        mpn = fakeValuesService.regexify("[a-z1-9]{13}");
    }

    @When("I call the Electricity meter creation service")
    public void callElectricityMeterRegistrationService() throws IOException {
       documentContext.set("mpxn" , mpn);
       endPoint = getProperty("electricityRegister");
       RequestSpecification request = RestAssured.given();
        response = request
                .contentType("application/json")
                .header("X-Css-identity",getProperty("identity"))
                .header("x-css-env",getProperty("environment"))
                .header("x-css-verify-key",getProperty("verifyKey"))
                .header("x-css-inbound-key",getProperty("inboundKey"))
                .log()
                .all()
                .body(documentContext.jsonString())
                .post(endPoint);
    }

    @Then("New Meter is created")
    public void validateElectricMeterRegistration() {
        Assert.assertEquals(202,response.getStatusCode());
    }
}
