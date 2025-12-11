package com.amayr.d11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public final class Paths {
    private static final Pattern NODE_PATTERN = Pattern.compile("^(\\w*): (.*)$");

    public long task1(List<String> lines) {
        var nodes = parseNodes(lines);
        return walk("out", "you", nodes);
    }

    public long walk(String toFind, String node, Map<String, List<String>> nodes) {
        if (node.equals(toFind)) {
            return 1;
        }

        AtomicLong ways = new AtomicLong();
        nodes.get(node).forEach(child -> ways.getAndAdd(walk(toFind, child, nodes)));
        return ways.get();
    }

    public long task2(List<String> lines) {
        var nodes = parseNodes(lines);
        return walk2("out", "svr", nodes, false, false);
    }

    public long walk2(String toFind, String node, Map<String, List<String>> nodes, boolean dacVisited, boolean fftVisited) {
        if (node.equals(toFind)) {
            if (dacVisited && fftVisited) {
                return 1;
            }
            return 0;
        }

        AtomicLong ways = new AtomicLong();
        nodes.get(node).forEach(child -> ways.getAndAdd(walk2(toFind, child, nodes, dacVisited || child.equals("dac"), fftVisited || child.equals("fft"))));
        return ways.get();
    }

    private Map<String, List<String>> parseNodes(List<String> lines) {
        var nodes = new HashMap<String, List<String>>();

        for (String line : lines) {
            var matcher = NODE_PATTERN.matcher(line);
            if (matcher.find()) {
                var children = matcher.group(2).split(" ");
                nodes.put(matcher.group(1), List.of(children));
            }
        }

        return nodes;
    }
}