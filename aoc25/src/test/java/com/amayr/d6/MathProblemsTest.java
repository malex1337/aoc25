package com.amayr.d6;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class MathProblemsTest {

    @IncludeAOCFile(fileName = "d6_input_given")
    @Test
    void given1(List<String> lines) {
        var grid = lines.stream()
                .limit(lines.size() - 1)
                .map(line -> Arrays.stream(line.split(" ")).filter(i -> !i.isEmpty()))
                .map(a -> a.map(Long::valueOf).toArray(Long[]::new))
                .toArray(Long[][]::new);

        var operations = Arrays.stream(lines.getLast().split(" "))
                .filter(s -> !s.isEmpty())
                .map(s -> s.charAt(0))
                .toArray(Character[]::new);

        var mp = new MathProblems();
        var sum = mp.result(grid, operations);

        assertThat(sum).isEqualTo(4277556L);
    }

    @IncludeAOCFile(fileName = "d6_input_task")
    @Test
    void task1(List<String> lines) {
        var grid = lines.stream()
                .limit(lines.size() - 1)
                .map(line -> Arrays.stream(line.split(" ")).filter(i -> !i.isEmpty()))
                .map(a -> a.map(Long::valueOf).toArray(Long[]::new))
                .toArray(Long[][]::new);

        var operations = Arrays.stream(lines.getLast().split(" "))
                .filter(s -> !s.isEmpty())
                .map(s -> s.charAt(0))
                .toArray(Character[]::new);

        var mp = new MathProblems();
        var sum = mp.result(grid, operations);

        assertThat(sum).isEqualTo(3785892992137L);
    }

    @IncludeAOCFile(fileName = "d6_input_given")
    @Test
    void given2(List<String> lines) {
        var mp = new MathProblems();
        var result = mp.result2(lines);
        assertThat(result).isEqualTo(3263827);
    }

    @IncludeAOCFile(fileName = "d6_input_task")
    @Test
    void task2(List<String> lines) {
        var mp = new MathProblems();
        var result = mp.result2(lines);
        assertThat(result).isEqualTo(7669802156452L);
    }
}