package jp.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton rtnVal1 = Singleton.getinstance();
        Singleton rtnVal2 = Singleton.getinstance();

        if (rtnVal1 == rtnVal2) {
            System.out.println("OK");
        } else {
            System.out.println("NG");
        }
    }
}