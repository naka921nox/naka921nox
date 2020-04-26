package jp.chainOfResponsibility;

public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }
    public boolean resolve(Trouble trouble) {
        return false;
    }
}