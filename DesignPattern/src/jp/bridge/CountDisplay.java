package jp.bridge;

public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
        // TODO Auto-generated constructor stub
    }
    public void multiDisplay(int time) {
        open();
        for (int i = 0; i < time; i++) {
            print();
        }
        close();
    }

}

