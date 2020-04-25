package jp.visitor;

public interface Element {
    public abstract void accept(Visitor v);
}