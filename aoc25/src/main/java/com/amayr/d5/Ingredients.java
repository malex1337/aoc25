package com.amayr.d5;

import java.util.*;
import java.util.stream.LongStream;

public final class Ingredients {
    public int countInRanges(Long[] values, Range... ranges) {
        var ct = 0;

        for (long value : values) {
            for (Range r : ranges) {
                if (r.contains(value)) {
                    ct++;
                    break;
                }
            }
        }

        return ct;
    }

    public long amountIds(Range... ranges) {
        List<Range> sorted = Arrays.stream(ranges)
                .sorted(Comparator.comparingLong(a -> a.from))
                .toList();

        long total = 0;
        long currentStart = -1, currentEnd = -1;

        for (Range r : sorted) {
            if (currentEnd < r.from) {
                if (currentEnd != -1) {
                    total += currentEnd - currentStart + 1;
                }
                currentStart = r.from;
                currentEnd = r.to;
            } else {
                currentEnd = Math.max(currentEnd, r.to);
            }
        }
        if (currentEnd != -1) {
            total += currentEnd - currentStart + 1;
        }
        return total;
    }


    record Range(long from, long to) {
        boolean contains(long value) {
            return value >= from && value <= to;
        }
    }
}