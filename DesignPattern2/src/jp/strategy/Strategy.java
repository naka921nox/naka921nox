package jp.strategy;

public abstract class Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}