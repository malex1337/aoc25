package com.amayr.d3;

import com.amayr.IncludeAOCFile;
import com.amayr.Measuring;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class BatteryTest {
    @Test
    void given1() {
        var battery = new Battery();

        Measuring.runMeasured("Given1", () -> {
            var result = battery.totalJoltage(
                    List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111"),
                    Battery::part1
            );
            assertThat(result).isEqualTo(357);
        });
    }

    @IncludeAOCFile(fileName = "d3_input")
    @Test
    void task1(List<String> lines) {
        var battery = new Battery();

        Measuring.runMeasured("Task1", () -> {
            var result = battery.totalJoltage(
                    lines.stream()
                            .toList(),
                    Battery::part1
            );

            assertThat(result).isEqualTo(17443);
        });
    }

    @Test
    void given2() {
        var battery = new Battery();

        Measuring.runMeasured("Given2", () -> {
            var result = battery.totalJoltage(
                    List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111"),
                    Battery::part2
            );
            assertThat(result).isEqualTo(3121910778619L);
        });
    }

    @IncludeAOCFile(fileName = "d3_input")
    @Test
    void task2(List<String> lines) {
        var battery = new Battery();

        Measuring.runMeasured("Task2", () -> {
            var result = battery.totalJoltage(
                    lines.stream()
                            .toList(),
                    Battery::part2
            );

            assertThat(result).isEqualTo(172167155440541L);
        });
    }
}