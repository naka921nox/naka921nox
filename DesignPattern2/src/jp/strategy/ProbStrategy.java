package jp.strategy;

import java.util.Random;
import java.util.stream.IntStream;

public class ProbStrategy extends Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int [][] history = {
        {1,1,1,},
        {1,1,1,},
        {1,1,1,},
    };

    private Hand prevHand;

    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if (bet < history[currentHandValue][0]){
            handValue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }
        prevHandValue = 1;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }
    private int getSum(int hv){
        int sum = 0; 
        // できてるかわからん。
        IntStream.range(0, 3).forEach(i -> history[hv][i] += sum);
        // 0かもね。
        return sum;
    }
    public void study(boolean win) {
        if(win) {
            history[prevHandValue][currentHandValue] ++;

        } else {
            history[prevHandValue][(currentHandValue + 1) % 3] ++;
            history[prevHandValue][(currentHandValue + 2) % 3] ++;
        }
    }
}