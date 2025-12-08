package com.amayr.d7;

import com.amayr.FileUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

final class ManifoldTest {

    @Test
    void given1() {
        var m = new Manifold();
        var res = m.solve1(FileUtil.parseFile("d7_input_given"));

        assertThat(res).isEqualTo(21);
    }

    @Test
    void task1() {
        var m = new Manifold();
        var res = m.solve1(FileUtil.parseFile("d7_input_task"));

        assertThat(res).isEqualTo(1675L);
    }

    @Test
    void given2() {
        var m = new Manifold();
        var res = m.solve2(FileUtil.parseFile("d7_input_given"));

        assertThat(res).isEqualTo(40);
    }
    
    @Test
    void task2() {
        var m = new Manifold();
        var res = m.solve2(FileUtil.parseFile("d7_input_task"));

        assertThat(res).isEqualTo(187987920774390L);
    }
}