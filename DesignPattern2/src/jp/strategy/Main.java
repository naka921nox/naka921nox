package jp.strategy;

public class Main {
    public static void main (String[] srgs) {
        // 引数もらうところ横着

        Player p1 = new Player("Bob", new WinningStrategy(314));
        Player p2 = new Player("Emmy", new WinningStrategy(15));

        for(int i = 0; i < 10000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();

            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("winner;" + p1);
                p1.win();
                p2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("winner;" + p2);
                p2.win();
                p1.lose();
            } else {
                System.out.println("EVEN");
                p1.even();
                p2.even();
            }
        }
        System.out.println("TOTAL:");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}