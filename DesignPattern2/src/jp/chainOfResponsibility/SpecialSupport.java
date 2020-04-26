package jp.chainOfResponsibility;

public class SpecialSupport extends Support {
    private int number;
    public SpecialSupport (String name, int number) {
        super(name);
        this.number = number;
    }
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        }else {
            return false;
        }
    }
}