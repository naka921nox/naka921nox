package jp.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }
    public static Properties getProperties(String dbname) {
        String fileName = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            System.out.println("Waiting: " + fileName + " is not found.");
        }
        return prop;
    }

}