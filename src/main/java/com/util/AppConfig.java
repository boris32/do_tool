package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Boris Sabados on 12/14/2016.
 */
public class AppConfig {

    private String filePath;

    public AppConfig (String filePath) {
        this.filePath = filePath;
    }

    public String readProperty (String propKey) {
        String propValue="";
        try
        {
            int check = 0;
            while(check==0)
            {
                check= 1;
                File cfgFile = new File(filePath);
                if (cfgFile.exists()) {
                    Properties props = new Properties();
                    FileInputStream propin = new FileInputStream(cfgFile);
                    props.load(propin);
                    propValue=props.getProperty(propKey);
                }
                else
                    check = 0;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return propValue;
    }
}
