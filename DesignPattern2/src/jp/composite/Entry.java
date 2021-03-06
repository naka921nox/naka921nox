package jp.composite;

import jp.visitor.Element;

public abstract class Entry implements Element {
    protected abstract String getName();
    protected abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);

    public String toString(){
        return getName() + "(" + getSize() + ")";
    }
}