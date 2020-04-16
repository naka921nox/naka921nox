package jp.singleton;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getinstance() {
        return instance;
    }
}