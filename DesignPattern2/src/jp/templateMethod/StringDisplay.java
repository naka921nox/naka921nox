package jp.templateMethod;

import java.util.stream.IntStream;

public class StringDisplay extends AbstractDisplay {
    
    private String str;
    private int width;

    public StringDisplay(String str) {
        this.str = str;
        this.width = str.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println("+");
    }
}
