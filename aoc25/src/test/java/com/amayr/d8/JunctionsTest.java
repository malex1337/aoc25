package com.amayr.d8;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class JunctionsTest {

    @IncludeAOCFile(fileName = "d8_input_task")
    @Test
    void task1(List<String> lines) {
        Junctions junctions = new Junctions();
        var result = junctions.task(lines, true);
        assertEquals(133574, result);
    }

    @IncludeAOCFile(fileName = "d8_input_task")
    @Test
    void task2(List<String> lines) {
        Junctions junctions = new Junctions();
        var result = junctions.task(lines, false);
        assertEquals(2435100380L, result);
    }
}