package cn.xpbootcamp.tdd;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> pouredNumbers = new ArrayList<>();

    public void roll(int pouredNumber) {
        pouredNumbers.add(pouredNumber);
    }

    public int scoring() {
        int totalScore = 0;
        int rollIndex = 0;
        for (int round = 0; round < 10; round++) {
            if (isStrike(rollIndex)) {
                totalScore += (10 + getStrikeBonus(rollIndex));
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                totalScore += (10 + getSpareBonus(rollIndex));
                rollIndex += 2;
            } else {
                totalScore += (pouredNumbers.get(rollIndex) + pouredNumbers.get(rollIndex + 1));
                rollIndex += 2;
            }
        }
        return totalScore;
    }

    private int getSpareBonus(int rollIndex) {
        return pouredNumbers.get(rollIndex + 2);
    }

    private int getStrikeBonus(int rollIndex) {
        return pouredNumbers.get(rollIndex + 1) + pouredNumbers.get(rollIndex + 2);
    }

    private boolean isStrike(int rollIndex) {
        return pouredNumbers.get(rollIndex) == 10;
    }

    private boolean isSpare(int rollIndex) {
        return pouredNumbers.get(rollIndex) + pouredNumbers.get(rollIndex + 1) == 10;
    }
}
