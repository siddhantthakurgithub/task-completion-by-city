package com.taskCompletion.CommonLibrary;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(HealthCheck.class);
    private RequestSpecification requestSpecification = null;
    private Response response = null;

    public void HealthCheck() {

        String response_body = null;

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(PropertyHandler.readProperty("fanCodeTestData","Resource-Base-URI"));

        try {
            response = requestSpecification.get("/todos");
            response_body = response.getBody().asString();
            if (response.getStatusCode() != 200) {
                LOG.error("The API is Down");
                LOG.error("The response is :: " + response_body);
                LOG.error("The Status Code is :: " + response.getStatusCode());
                Assert.fail();
            }

        } catch (Exception e) {
            String Response = response_body != null ? response_body : "No Response Logged";
            String Status_code = response_body != null ? String.valueOf(response.getStatusCode()) : "No Status Code obtained";

            LOG.error("The API is Down ");
            LOG.error("The response is :: " + Response);
            LOG.error("The Status Code is :: " + Status_code);
            LOG.error("The Error message is :: " + e.getMessage());
            Assert.fail();
        }

    }

}

