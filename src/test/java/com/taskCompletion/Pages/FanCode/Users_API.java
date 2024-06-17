package com.taskCompletion.Pages.FanCode;

import com.taskCompletion.Constants.APIEndPointConstants;
import com.taskCompletion.CommonLibrary.JSONHelper;
import com.taskCompletion.CommonLibrary.PropertyHandler;

import java.io.IOException;
import java.util.Arrays;

import static com.taskCompletion.CommonLibrary.CommonMethods.*;


public class Users_API {

    private String responseStringBody;
    public void getUserDetailsAPI() {

        responseStringBody = callGetApiAndStoreResponse(APIEndPointConstants.usersAPI);
    }

    public void storeIdsOfUsersStayingInACityWithinCoordinates(int latitudeX,int latitudeY,int longitudeX, int longitudeY)throws IOException  {

        int totalUsers = convertStringToInt(JSONHelper.getValueAt(responseStringBody, "$.length()"));
        int[] userIdArray = new int[totalUsers];

        int totalUsersInCityCounter = 0;

        for (int i = 0; i < totalUsers; i++) {

            float latitudeOfCurrentUser = convertStringToFloat(JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].address.geo.lat"));
            float longitudeOfCurrentUser = convertStringToFloat(JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].address.geo.lng"));

            if (latitudeOfCurrentUser >= latitudeX && latitudeOfCurrentUser <= latitudeY && longitudeOfCurrentUser >= longitudeX && longitudeOfCurrentUser <= longitudeY) {

                int userId = convertStringToInt(JSONHelper.getValueAt(responseStringBody, "$.[" + i + "].id"));

                userIdArray[totalUsersInCityCounter] = userId;
                totalUsersInCityCounter++;

            }

        }

        PropertyHandler.writeProperty("fanCodeTestData","userIds", Arrays.toString(userIdArray));
        PropertyHandler.writeProperty("fanCodeTestData","totalUsersInACity", "" + totalUsersInCityCounter);
    }
}

