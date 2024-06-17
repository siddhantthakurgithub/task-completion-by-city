package com.taskCompletion.StepDefinitions;

import com.taskCompletion.Pages.FanCode.Todos_API;
import com.taskCompletion.Pages.FanCode.Users_API;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;


public class TaskCompletionStepDef_API {

    Todos_API getAllTodosAPI = new Todos_API();
    Users_API getAllUserDetailsAPI = new Users_API();


    @Given("User has the todo tasks")
    public void getTodoTasks() {
        getAllTodosAPI.getTodosAPI();
        getAllTodosAPI.validateIfAllUsersHaveTodo();
    }

    @And("User belongs to the city FanCode")
    public void storeUserIdsOfSpecificCity() throws IOException {
        getAllUserDetailsAPI.getUserDetailsAPI();
        getAllUserDetailsAPI.storeIdsOfUsersStayingInACityWithinCoordinates(-40, 5, 5, 100);
    }

    @Then("User Completed task percentage should be greater than 50%")
    public void validateCompletedTaskPercent() {
        getAllTodosAPI.validateCompletedTaskPercentage();
    }
}
