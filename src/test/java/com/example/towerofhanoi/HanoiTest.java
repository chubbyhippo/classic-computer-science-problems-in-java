package com.example.towerofhanoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

class HanoiTest {
    private static final Logger log = LoggerFactory.getLogger(HanoiTest.class);

    @Test
    @DisplayName("should solve tower of hanoi puzzle")
    void shouldSolveTowerOfHanoiPuzzle() {

        int discs = 3;
        var hanoi = new Hanoi(discs);
        hanoi.solve();

        log.info("Tower A: {}", hanoi.getTowerA());
        log.info("Tower B: {}", hanoi.getTowerB());
        log.info("Tower C: {}", hanoi.getTowerC());

        assertThat(hanoi.getTowerC()).hasSize(discs);
    }

}