package jp.prototype;

import java.util.stream.IntStream;

import jp.prototype.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;
    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        // TODO Auto-generated method stub
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");        
        IntStream.range(0, length).forEach(i -> System.out.print(ulchar));       
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
