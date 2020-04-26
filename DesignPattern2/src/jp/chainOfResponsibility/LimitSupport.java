package jp.chainOfResponsibility;

public class LimitSupport extends Support {
    private int limit;

    public LimitSupport (String name, int limit) {
        super(name);
        this.limit = limit;
    }
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }else {
            return false;
        }
    }
}