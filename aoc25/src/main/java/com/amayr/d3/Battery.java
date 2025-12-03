package com.amayr.d3;

import java.util.List;
import java.util.function.ToLongFunction;

public final class Battery {
    private static final char[] DIGITS = "9876543210".toCharArray();

    public long totalJoltage(List<String> lines, ToLongFunction<String> joltageFunction) {
        var totalJoltage = 0L;

        for (String line : lines) {
            totalJoltage += joltageFunction.applyAsLong(line);
        }

        return totalJoltage;
    }

    public static long part1(String line) {
        int maxIndex = -1;
        int secondMaxIndex = -1;

        maxIndex = findMaxIdx(line, 0, line.length() - 1);
        secondMaxIndex = findMaxIdx(line, maxIndex + 1, line.length());

        return Long.valueOf(String.valueOf(line.toCharArray()[maxIndex]) + line.toCharArray()[secondMaxIndex]);
    }

    public static long part2(String line) {
        String nr = "";
        int idx = -1;
        for (int nrsLeft = 11; nrsLeft > -1; nrsLeft--) {
            var maxIdx = findMaxIdx(line, idx + 1, line.length() - nrsLeft);
            idx = maxIdx;
            nr += line.toCharArray()[maxIdx];
        }

        return Long.parseLong(nr);
    }

    private static int findMaxIdx(String line, int offsetStart, int offsetEnd) {
        for (char digit : DIGITS) {
            var idx = line.indexOf(digit, offsetStart, offsetEnd);
            if (idx >= 0) {
                return idx;
            }
        }

        throw new IllegalArgumentException("Invalid line: " + line);
    }
}