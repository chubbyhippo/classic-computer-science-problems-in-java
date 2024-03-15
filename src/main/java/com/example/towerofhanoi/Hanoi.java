package com.example.towerofhanoi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class Hanoi {
    private static final Logger log = LoggerFactory.getLogger(Hanoi.class);
    private final int numDiscs;
    private final Stack<Integer> towerA = new Stack<>();
    private final Stack<Integer> towerB = new Stack<>();

    public Stack<Integer> getTowerA() {
        return towerA;
    }

    public Stack<Integer> getTowerB() {
        return towerB;
    }

    public Stack<Integer> getTowerC() {
        return towerC;
    }

    private final Stack<Integer> towerC = new Stack<>();

    public Hanoi(int discs) {
        numDiscs = discs;
        for (int i = 1; i <= discs; i++) {
            towerA.push(i);
        }
    }

    private void move(Stack<Integer> begin, Stack<Integer> end, Stack<Integer> temp, int n) {
        log.info("Tower A: {}", towerA);
        log.info("Tower B: {}", towerB);
        log.info("Tower C: {}", towerC);

        if (n == 1) {
            end.push(begin.pop());
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }

    public void solve() {
        move(towerA, towerC, towerB, numDiscs);
    }
}
