package jp.chainOfResponsibility;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support maiko = new SpecialSupport("Maiko", 429);
        Support shiori = new LimitSupport("Shiori", 200);
        Support diana = new OddSupport("diana");
        Support miho = new LimitSupport("Miho", 300);
        alice.setNext(bob).setNext(maiko).setNext(shiori).setNext(diana).setNext(miho);
        // 連鎖の形成
        Random intRandom = new Random(100);
        intRandom.ints(10, 1, 500).forEach( i -> alice.support(new Trouble(i)));
    }
}