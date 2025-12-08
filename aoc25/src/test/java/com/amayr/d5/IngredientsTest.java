package com.amayr.d5;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class IngredientsTest {
    @Test
    void given1() {
        Ingredients.Range[] ranges = {
                new Ingredients.Range(3, 5),
                new Ingredients.Range(10, 14),
                new Ingredients.Range(16, 20),
                new Ingredients.Range(12, 18)
        };

        Long[] numbers = {1L, 5L, 8L, 11L, 17L, 32L};

        var count = new Ingredients().countInRanges(numbers, ranges);
        assertThat(count).isEqualTo(3);
    }

    @IncludeAOCFile(fileName = "d5_input")
    @Test
    void task1(List<String> lines) {
        var ranges = lines.stream()
                .takeWhile(inp -> inp != null && !inp.isBlank())
                .map(inp -> inp.split("-"))
                .map(parts -> new Ingredients.Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])))
                .toArray(Ingredients.Range[]::new);

        var values = lines.stream()
                .dropWhile(inp -> inp != null && !inp.isBlank())
                .skip(1)
                .map(inp -> Long.valueOf(inp))
                .toArray(Long[]::new);

        var count = new Ingredients().countInRanges(values, ranges);
        assertThat(count).isEqualTo(611);
    }

    @Test
    void given2() {
        Ingredients.Range[] ranges = {
                new Ingredients.Range(3, 5),
                new Ingredients.Range(10, 14),
                new Ingredients.Range(16, 20),
                new Ingredients.Range(12, 18)
        };

        var count = new Ingredients().amountIds(ranges);
        assertThat(count).isEqualTo(14);
    }

    @IncludeAOCFile(fileName = "d5_input")
    @Test
    void task2(List<String> lines) {
        var ranges = lines.stream()
                .takeWhile(inp -> inp != null && !inp.isBlank())
                .map(inp -> inp.split("-"))
                .map(parts -> new Ingredients.Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])))
                .toArray(Ingredients.Range[]::new);

        var count = new Ingredients().amountIds(ranges);

        assertThat(count).isEqualTo(345995423801866L);
    }
}