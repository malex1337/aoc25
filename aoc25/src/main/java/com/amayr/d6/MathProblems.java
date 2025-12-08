package com.amayr.d6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MathProblems {
    private static final char PLUS = '+';
    private static final char MULT = '*';

    public long result(Long[][] grid, Character[] operations) {
        var cols = grid[0].length;

        var intermediates = new Long[cols];
        System.arraycopy(grid[0], 0, intermediates, 0, cols);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                intermediates[j] = applyOperation(intermediates[j], grid[i][j], operations[j]);
            }
        }

        return Arrays.stream(intermediates).mapToLong(Long::longValue).sum();
    }

    public long result2(List<String> lines) {
        int length = lines.getFirst().length();
        int numLines = lines.size();
        long res = 0;

        List<Long> numbers = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            long currNr = 0;
            for (int j = 0; j < numLines - 1; j++) {
                char curr = lines.get(j).charAt(i);
                if (Character.isDigit(curr)) {
                    currNr = (currNr * 10) + (curr - '0');
                }
            }
            if (currNr != 0) {
                numbers.add(currNr);
            }

            if (i < lines.getLast().length()) {
                char curr = lines.getLast().charAt(i);
                if (curr == PLUS) {
                    res += numbers.stream().mapToLong(n -> n).sum();
                    numbers.clear();
                } else if (curr == MULT) {
                    res += numbers.stream().mapToLong(n -> n).reduce(1, (n, p) -> n * p);
                    numbers.clear();
                }
            }
        }

        return res;
    }

    private long applyOperation(long a, long b, char operation) {
        return switch (operation) {
            case PLUS -> a + b;
            case MULT -> a * b;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}