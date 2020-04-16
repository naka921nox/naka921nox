package jp.adapter.practice;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            FileIO f = new FileProperties();
            f.readFromFile("input.txt");
            f.setValue("year", "2004");
            f.setValue("month", "1");
            f.setValue("day", "10");
            f.writeFromFile("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
