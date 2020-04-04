package jp.adapter.extend;

public class Banner {
    private String str;
    public Banner(String str) {
        this.str = str;
    }
    public void showWithParan() {
        System.out.println("(" + str + ")");
    }
    public void showWithAster() {
        System.out.println("*" + str + "*");
    }

}