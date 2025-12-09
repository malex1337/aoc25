package com.amayr.util;

/**
 * A simple generic pair record to hold two values of the same type.
 *
 * @param <T> the type of the values in the pair
 */
public record Pair<T>(
        T a,
        T b
) {
}