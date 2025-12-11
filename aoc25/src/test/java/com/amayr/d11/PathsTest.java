package com.amayr.d11;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class PathsTest {
    @Test
    void given1() {
        var paths = new Paths();

        var result = paths.task1(List.of(
                "aaa: you hhh",
                "you: bbb ccc",
                "bbb: ddd eee",
                "ccc: ddd eee fff",
                "ddd: ggg",
                "eee: out",
                "fff: out",
                "ggg: out",
                "hhh: ccc fff iii",
                "iii: out"));

        assertThat(result).isEqualTo(5);
    }

    @IncludeAOCFile(fileName = "d11_input_task")
    @Test
    void task1(List<String> lines) {
        var paths = new Paths();

        var result = paths.task1(lines);

        assertThat(result).isEqualTo(796);
    }

    @Test
    void given2() {
        var paths = new Paths();

        var result = paths.task2(List.of(
                "svr: aaa bbb",
                "aaa: fft",
                "fft: ccc",
                "bbb: tty",
                "tty: ccc",
                "ccc: ddd eee",
                "ddd: hub",
                "hub: fff",
                "eee: dac",
                "dac: fff",
                "fff: ggg hhh",
                "ggg: out",
                "hhh: out"));

        assertThat(result).isEqualTo(2);
    }

    @IncludeAOCFile(fileName = "d11_input_task2")
    @Test
    void task2(List<String> lines) {
        var paths = new Paths();

        var result = paths.task2(lines);

        assertThat(result).isEqualTo(1);
    }
}