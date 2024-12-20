package be.envano.adventofcode.day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.envano.adventofcode.day01.HistorianHysteria.*;
import static org.assertj.core.api.Assertions.assertThat;

class HistorianHysteriaTest {

    @Test
    @DisplayName("I can pass the written scenario - PART 1")
    void testPassScenarioPart1() {
        Data data = new Data(
            List.of(3, 4, 2, 1, 3, 3),
            List.of(4, 3, 5, 3, 9, 3)
        );

        int result = data.calculateTotalDistance();

        assertThat(result).isEqualTo(11);
    }

    @Test
    @DisplayName("I can pass the written scenario - PART 2")
    void testPassScenarioPart2() {
        Data data = new Data(
            List.of(3, 4, 1, 3, 3),
            List.of(4, 3, 5, 3, 9, 3)
        );

        int result = data.calculateSimilarityScore();

        assertThat(result).isEqualTo(31);
    }

}