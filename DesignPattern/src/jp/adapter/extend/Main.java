package jp.adapter.extend;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("HelloWorld!");
        p.printWeak();
        p.printStrong();
    }
}