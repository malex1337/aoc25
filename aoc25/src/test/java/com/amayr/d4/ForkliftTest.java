package com.amayr.d4;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class ForkliftTest {

    @IncludeAOCFile(fileName = "d4_input_given")
    @Test
    void given1(List<String> lines) {
        var grid = lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(13, forklift.accessibleRolls());
    }

    @IncludeAOCFile(fileName = "d4_input_task")
    @Test
    void task1(List<String> lines) {
        var grid = lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(1389, forklift.accessibleRolls());
    }

    @IncludeAOCFile(fileName = "d4_input_given")
    @Test
    void given2(List<String> lines) {
        var grid = lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(43, forklift.accessibleRolls2());
    }

    @IncludeAOCFile(fileName = "d4_input_task")
    @Test
    void task2(List<String> lines) {
        var grid = lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(9000, forklift.accessibleRolls2());
    }
}