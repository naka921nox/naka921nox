package jp.bridge;

public class Display {
    private DisplayImpl impl = null;
    public Display (DisplayImpl impl) {
        this.impl = impl;
    }
    public void open() {
        impl.rawOpen();        
    }
    public void print() {
        impl.rawPrint();        
    }
    public void close() {
        impl.rawClose();        
    }
    public final void display(){
        open();
        print();
        close();
    }
}