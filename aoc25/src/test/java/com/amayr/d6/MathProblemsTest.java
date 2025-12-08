package com.amayr.d6;

import com.amayr.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

final class MathProblemsTest {

    @Test
    void given1() {
        var lines = FileUtil.parseFile("d6_input_given");

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

    @Test
    void task1() {
        var lines = FileUtil.parseFile("d6_input_task");

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

    @Test
    void given2() {
        var mp = new MathProblems();
        var result = mp.result2(FileUtil.parseFile("d6_input_given"));
        assertThat(result).isEqualTo(3263827);
    }

    @Test
    void task2() {
        var mp = new MathProblems();
        var result = mp.result2(FileUtil.parseFile("d6_input_task"));
        assertThat(result).isEqualTo(7669802156452L);
    }
}