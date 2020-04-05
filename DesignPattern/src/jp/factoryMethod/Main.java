package jp.factoryMethod;

import jp.factoryMethod.framework.Factory;
import jp.factoryMethod.framework.Product;
import jp.factoryMethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("ユーザ1");
        Product card2 = factory.create("ユーザ2");
        Product card3 = factory.create("ユーザ3");
        card1.use(); 
        card2.use();
        card3.use();
    }

}