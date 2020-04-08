package jp.prototype;

import jp.prototype.framework.Product;
import jp.prototype.framework.Manager;

public class Main {
    public static void main(String[] args) {
        // 準備
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manager.registoer("strong message", upen);
        manager.registoer("warning box", mBox);
        manager.registoer("slash box", sBox);
        // 生成
        Product p1 = manager.create("strong message");
        p1.use("Hello world");
        Product p2 = manager.create("warning box");
        p2.use("Hello world");
        Product p3 = manager.create("slash box");
        p3.use("Hello world");
    }
}