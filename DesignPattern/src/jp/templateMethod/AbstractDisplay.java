package jp.templateMethod;

import java.util.stream.IntStream;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display() {
        open();
        IntStream.range(0, 4).forEach(i -> print());
        close();
    }

 
}