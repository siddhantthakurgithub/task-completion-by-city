package com.taskCompletion.CommonLibrary;

import com.jayway.jsonpath.JsonPath;

public class JSONHelper {

    public static String getValueAt(String json, String path) {
        try {
            return JsonPath.read(json, path).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}