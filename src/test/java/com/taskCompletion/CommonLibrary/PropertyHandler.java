package com.taskCompletion.CommonLibrary;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

    public static String readProperty(String testDataFileName,String key){
        FileReader reader= null;
        Properties properties= null;
        String value = null;
        try{
            reader=new FileReader("src/test/resources/TestData/"+testDataFileName+".properties");
            properties =new Properties();
            properties.load(reader);
            value = properties.getProperty(key);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return value;
    }


    public static void writeProperty (String testDataFileName,String key,String value) throws IOException {

        FileReader reader= null;
        Properties properties= null;
        FileOutputStream fileOutputStream = null;
        try{
            reader=new FileReader("src/test/resources/TestData/"+testDataFileName+".properties");
            properties =new Properties();
            properties.load(reader);
            properties.setProperty(key,value);
            fileOutputStream = new FileOutputStream("src/test/resources/TestData/"+testDataFileName+".properties");
            properties.store(fileOutputStream,"");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }

    }

}
