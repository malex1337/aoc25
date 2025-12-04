package com.amayr.d4;

import com.amayr.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class ForkliftTest {

    @Test
    void given1() {
        var grid = FileUtil.parseFile("d4_input_given").stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(13, forklift.accessibleRolls());
    }

    @Test
    void task1() {
        var grid = FileUtil.parseFile("d4_input_task").stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(1389, forklift.accessibleRolls());
    }

    @Test
    void given2() {
        var grid = FileUtil.parseFile("d4_input_given").stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(43, forklift.accessibleRolls2());
    }

    @Test
    void task2() {
        var grid = FileUtil.parseFile("d4_input_task").stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var forklift = new Forklift(grid);
        assertEquals(9000, forklift.accessibleRolls2());
    }
}