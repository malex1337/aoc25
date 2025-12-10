package com.amayr;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class LightingsTest {

    @IncludeAOCFile(fileName = "d10_input_given")
    @Test
    void given1(List<String> lines) {
        Measuring.runMeasured("Lightings given1", () -> {
            var l = new Lightings();
            var minPresses = l.task1(lines);
            assertThat(minPresses).isEqualTo(7);
        });
    }

    @IncludeAOCFile(fileName = "d10_input_task")
    @Test
    void given2(List<String> lines) {
        Measuring.runMeasured("Lightings task1", () -> {
            var l = new Lightings();
            var minPresses = l.task1(lines);
            assertThat(minPresses).isEqualTo(432);
        });
    }
}