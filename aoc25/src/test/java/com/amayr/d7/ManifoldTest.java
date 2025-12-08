package com.amayr.d7;

import com.amayr.IncludeAOCFile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class ManifoldTest {

    @IncludeAOCFile(fileName = "d7_input_given")
    @Test
    void given1(List<String> lines) {
        var m = new Manifold();
        var res = m.solve1(lines);

        assertThat(res).isEqualTo(21);
    }

    @IncludeAOCFile(fileName = "d7_input_task")
    @Test
    void task1(List<String> lines) {
        var m = new Manifold();
        var res = m.solve1(lines);

        assertThat(res).isEqualTo(1675L);
    }

    @IncludeAOCFile(fileName = "d7_input_given")
    @Test
    void given2(List<String> lines) {
        var m = new Manifold();
        var res = m.solve2(lines);

        assertThat(res).isEqualTo(40);
    }

    @IncludeAOCFile(fileName = "d7_input_task")
    @Test
    void task2(List<String> lines) {
        var m = new Manifold();
        var res = m.solve2(lines);

        assertThat(res).isEqualTo(187987920774390L);
    }
}