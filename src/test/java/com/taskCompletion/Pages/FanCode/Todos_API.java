package com.taskCompletion.Pages.FanCode;

import com.taskCompletion.Constants.APIEndPointConstants;
import com.taskCompletion.CommonLibrary.JSONHelper;
import com.taskCompletion.CommonLibrary.PropertyHandler;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import static com.taskCompletion.CommonLibrary.CommonMethods.callGetApiAndStoreResponse;
import static com.taskCompletion.CommonLibrary.CommonMethods.convertStringToInt;

public class Todos_API {

    private String responseStringBody;

    public void getTodosAPI() {

        responseStringBody = callGetApiAndStoreResponse(APIEndPointConstants.todosAPI);

    }

    public void validateIfAllUsersHaveTodo() {

        int totalTodos = convertStringToInt(JSONHelper.getValueAt(responseStringBody, "$.length()"));

        for (int i = 0; i < totalTodos; i++) {

            if (JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].id") == null || JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].userId") == null) {

                String userIdString = JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].userId");
                Assert.fail("User with userId " + userIdString + " does not have a todo");
            }
        }
    }

    public void validateCompletedTaskPercentage() {

        SoftAssert softAssert = new SoftAssert();

        int totalUsersInFanCodeCity = convertStringToInt(PropertyHandler.readProperty("fanCodeTestData","totalUsersInACity"));
        int totalTodos = convertStringToInt(JSONHelper.getValueAt(responseStringBody, "$.length()"));

        String test = PropertyHandler.readProperty("fanCodeTestData","userIds").replaceAll("[^0-9a-zA-Z, ]", "").replace(" ", "");
        String[] userIdsInFanCodeCity = test.split(",");


        for (int i = 0; i < totalUsersInFanCodeCity; i++) {
            int todoTaskCounter = 0, completedTasksCounter = 0;

            for (int j = 0; j < totalTodos; j++) {

                if (JSONHelper.getValueAt(responseStringBody, "$.[" + j + "].userId").equals(userIdsInFanCodeCity[i])) {
                    todoTaskCounter++;

                    if (JSONHelper.getValueAt(responseStringBody, "$.[" + j + "].completed").equalsIgnoreCase("true")) {
                        completedTasksCounter++;
                    }
                }
            }

            if ((completedTasksCounter * 100 / todoTaskCounter) <= 50) {
                softAssert.fail("\nUser with id " + userIdsInFanCodeCity[i] + " has not completed at least 50% of their tasks.\nCompleted tasks: " + completedTasksCounter + "\nTodo Tasks: " + todoTaskCounter);

            }
        }
        softAssert.assertAll();

    }

}







