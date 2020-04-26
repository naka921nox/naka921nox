package jp.chainOfResponsibility;

public class OddSupport extends Support {
    public OddSupport (String name) {
        super(name);
    }
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }else {
            return false;
        }
    }
}