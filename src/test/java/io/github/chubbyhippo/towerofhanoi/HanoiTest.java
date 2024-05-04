package io.github.chubbyhippo.towerofhanoi;

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

        log.info("Before solving, Tower A: {}", hanoi.getTowerA());
        log.info("Before solving, Tower B: {}", hanoi.getTowerB());
        log.info("Before solving, Tower C: {}", hanoi.getTowerC());

        hanoi.solve();

        log.info("After solving, Tower A: {}", hanoi.getTowerA());
        log.info("After solving, Tower B: {}", hanoi.getTowerB());
        log.info("After solving, Tower C: {}", hanoi.getTowerC());

        assertThat(hanoi.getTowerC()).hasSize(discs);
    }

}