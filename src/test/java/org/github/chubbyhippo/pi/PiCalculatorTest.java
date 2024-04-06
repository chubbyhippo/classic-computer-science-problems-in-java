package org.github.chubbyhippo.pi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

class PiCalculatorTest {
    private static final Logger log = LoggerFactory.getLogger(PiCalculatorTest.class);

    @Test
    @DisplayName("should throw illegal state exception when initialized")
    void shouldThrowIllegalStateExceptionWhenInitialized() {
        var constructor = PiCalculator.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (IllegalStateException | InstantiationException | IllegalAccessException |
                 InvocationTargetException exception) {
            assertThat(exception.getCause().getClass()).isEqualTo(IllegalStateException.class);
            assertThat(exception.getCause().getMessage()).isEqualTo("Utility class");
        }
    }

    @Test
    @DisplayName("should return pi calculation result from n terms")
    void shouldReturnPiCalculationResultFromNTerms() {

        var pi = PiCalculator.calculatePi(Integer.MAX_VALUE);
        log.info("Leibniz PI : {}", pi);
        log.info("Math.PI : {}", Math.PI);

        assertThat(pi).isGreaterThan(3.14);
    }


}