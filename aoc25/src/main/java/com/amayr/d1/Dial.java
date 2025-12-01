package com.amayr.d1;

import java.util.List;

public final class Dial {
    private int position;
    protected int zeroCounters;

    public Dial() {
        this.position = 50;
    }

    public void dial(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            var direction = instruction.direction() == Direction.LEFT ? -1 : 1;
            var distance = instruction.ticks();

            position += (direction * distance);
            position %= 100;

            if (position == 0) {
                zeroCounters++;
            }
        }
    }

    public void dial2(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            var direction = instruction.direction() == Direction.LEFT ? -1 : 1;
            var distance = instruction.ticks();

            // calc full rotations
            var fullRotations = distance / 100;
            zeroCounters += fullRotations;

            var startPosition = position;

            position += direction * (distance % 100);

            // if we started not on zero but passed it (not full rotation)
            if (startPosition != 0 && (position < 0 || position > 100)) {
                zeroCounters++;
            }

            position %= 100;

            if (position < 0) {
                position += 100;
            }

            if (startPosition != 0 && position == 0) {
                zeroCounters++;
            }
        }
    }

    public record Instruction(Direction direction, int ticks) {
        static Instruction from(String s) {
            return new Instruction(Direction.from(s.charAt(0)), Integer.parseInt(s.substring(1)));
        }
    }

    enum Direction {
        LEFT,
        RIGHT;

        static Direction from(char c) {
            return c == 'L' ? LEFT : RIGHT;
        }
    }
}