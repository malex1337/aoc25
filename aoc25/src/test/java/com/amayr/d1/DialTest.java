package com.amayr.d1;

import com.amayr.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class DialTest {

    @Test
    void given1() {
        Dial dial = new Dial();
        dial.dial(List.of(
                new Dial.Instruction(Dial.Direction.LEFT, 68),
                new Dial.Instruction(Dial.Direction.LEFT, 30),
                new Dial.Instruction(Dial.Direction.RIGHT, 48),
                new Dial.Instruction(Dial.Direction.LEFT, 5),
                new Dial.Instruction(Dial.Direction.RIGHT, 60),
                new Dial.Instruction(Dial.Direction.LEFT, 55),
                new Dial.Instruction(Dial.Direction.LEFT, 1),
                new Dial.Instruction(Dial.Direction.LEFT, 99),
                new Dial.Instruction(Dial.Direction.RIGHT, 14),
                new Dial.Instruction(Dial.Direction.LEFT, 82)
        ));

        assertThat(dial.zeroCounters).isEqualTo(3);
    }

    @Test
    void task1() {
        var dial = new Dial();
        dial.dial(FileUtil.parseFile("d1_input").stream()
                .map(Dial.Instruction::from)
                .toList());

        System.out.println(dial.zeroCounters);
    }

    @Test
    void given2() {
        Dial dial = new Dial();
        dial.dial2(List.of(
                new Dial.Instruction(Dial.Direction.LEFT, 68),
                new Dial.Instruction(Dial.Direction.LEFT, 30),
                new Dial.Instruction(Dial.Direction.RIGHT, 48),
                new Dial.Instruction(Dial.Direction.LEFT, 5),
                new Dial.Instruction(Dial.Direction.RIGHT, 60),
                new Dial.Instruction(Dial.Direction.LEFT, 55),
                new Dial.Instruction(Dial.Direction.LEFT, 1),
                new Dial.Instruction(Dial.Direction.LEFT, 99),
                new Dial.Instruction(Dial.Direction.RIGHT, 14),
                new Dial.Instruction(Dial.Direction.LEFT, 82)
        ));

        assertThat(dial.zeroCounters).isEqualTo(6);
    }

    @Test
    void task2() {
        var dial = new Dial();
        dial.dial2(FileUtil.parseFile("d1_input").stream()
                .map(Dial.Instruction::from)
                .toList());

        System.out.println(dial.zeroCounters);
    }
}