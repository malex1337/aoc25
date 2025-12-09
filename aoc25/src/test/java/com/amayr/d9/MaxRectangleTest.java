package com.amayr.d9;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class MaxRectangleTest {

    @IncludeAOCFile(fileName = "d9_input_given")
    @Test
    void given1(List<String> lines) {
        var mr = new MaxRectangle();
        var result = mr.calculate(lines);
        assertThat(result).isEqualTo(50L);
    }

    @IncludeAOCFile(fileName = "d9_input_task")
    @Test
    void task1(List<String> lines) {
        var mr = new MaxRectangle();
        var result = mr.calculate(lines);
        assertThat(result).isEqualTo(4777824480L);
    }
}