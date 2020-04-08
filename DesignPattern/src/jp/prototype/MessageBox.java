package jp.prototype;

import java.util.stream.IntStream;

import jp.prototype.framework.Product;

public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        // TODO Auto-generated method stub
        int length = s.getBytes().length;
        IntStream.range(0, length + 4).forEach( i-> System.out.print(decochar));
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        IntStream.range(0, length + 4).forEach( i-> System.out.print(decochar));
        System.out.println("");
    }

    @Override
    public Product createClone() {
        // TODO Auto-generated method stub
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e){
            e.getStackTrace();
        }
        return p;
    }
} 
