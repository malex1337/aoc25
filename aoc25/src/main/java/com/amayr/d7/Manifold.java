package com.amayr.d7;

import java.util.Arrays;
import java.util.List;

public final class Manifold {
    long[] beams;

    public int solve1(List<String> input) {
        int width = input.getFirst().length();
        beams = new long[width];
        int splitCount = 0;
        beams[input.getFirst().indexOf('S')] = 1;

        for (int rowNr = 1; rowNr < input.size(); rowNr++) {
            String row = input.get(rowNr);

            for (int col = 0; col < width; col++) {
                if (row.charAt(col) == '^') {
                    if (beams[col] > 0) {
                        splitCount++;
                        beams[col - 1] += beams[col];
                        beams[col + 1] += beams[col];
                        beams[col] = 0;
                    }
                }
            }
        }

        return splitCount;
    }
    
    long solve2(List<String> input) {
        solve1(input);
        return Arrays.stream(beams).sum();
    }
}