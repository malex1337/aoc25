package com.amayr.d9;

import com.amayr.util.Pair;

import java.util.List;

public final class MaxRectangle {
    public long calculate(List<String> lines) {
        var pairs = lines.stream()
                .map(line -> {
                    var parts = line.split(",");
                    return new Pair<>(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
                })
                .toList();

        long maxArea = 0;
        for (int i = 0; i < pairs.size() - 1; i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                Pair<Long> p1 = pairs.get(i);
                Pair<Long> p2 = pairs.get(j);

                long x = Math.max(p1.a(), p2.a()) - Math.min(p1.a(), p2.a()) + 1;
                long y = Math.max(p1.b(), p2.b()) - Math.min(p1.b(), p2.b()) + 1;
                long possibleNewMaxArea = x * y;

                if (possibleNewMaxArea > maxArea) {
                    maxArea = possibleNewMaxArea;
                }
            }
        }

        return maxArea;
    }

}