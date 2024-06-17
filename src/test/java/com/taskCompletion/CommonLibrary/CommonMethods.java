package com.taskCompletion.CommonLibrary;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class CommonMethods {

    public static String callGetApiAndStoreResponse(String apiPath){

        RestAssured.baseURI = PropertyHandler.readProperty("fanCodeTestData","Resource-Base-URI");
        RequestSpecification request = given().log().all();
        request.header("User-Agent", "PostmanRuntime/7.29.0");
        Response resp = request.get(apiPath);
        int statusCode = resp.getStatusCode();
        Assert.assertEquals("Status code validation Failed for: "+apiPath+" API", 200, statusCode);

        return resp.getBody().asString();
    }
    public static float convertStringToFloat(String str) {

        try {
            assert str != null;

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Invalid String");
        }
        return Float.parseFloat(str);

    }
    public static int convertStringToInt(String str) {

        try {
            assert str != null;

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Invalid String");
        }
        return Integer.parseInt(str);

    }
}
