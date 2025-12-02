package com.amayr.d2;

import java.util.function.ToLongFunction;

public final class Ids {

    public long sumInvalids(ToLongFunction<IdRange> invalidIdFunction, IdRange... ranges) {
        var sum = 0L;

        for (var range : ranges) {
            sum += invalidIdFunction.applyAsLong(range);
        }

        return sum;
    }

    public static long invalidIdsPart1(IdRange range) {
        var sum = 0L;
        for (var id = range.start; id <= range.end; id++) {
            var idString = "" + id;

            if (idString.length() % 2 != 0) {
                continue;
            }

            var halfLength = idString.length() / 2;
            if (idString.substring(0, halfLength).equals(idString.substring(halfLength))) {
                sum += id;
            }
        }
        return sum;
    }

    public static long invalidIdsPart2(IdRange range) {
        var sum = 0L;

        for (var id = range.start; id <= range.end; id++) {
            String idString = "" + id;
            int idLength = idString.length();

            for (int k = 1; k <= idLength / 2; k++) {
                if (idLength % k == 0) {
                    boolean equal = true;
                    var first = idString.substring(0, k);
                    for (int i = 1; equal && i < idLength / k; i++) {
                        equal = first.equals(idString.substring(i * k, (i + 1) * k));
                    }
                    if (equal) {
                        sum += id;
                        break;
                    }
                }
            }
        }

        return sum;
    }

    public record IdRange(long start, long end) {
        public static IdRange of(String str) {
            var split = str.split("-");
            return new IdRange(Long.parseLong(split[0]), Long.parseLong(split[1]));
        }
    }
}