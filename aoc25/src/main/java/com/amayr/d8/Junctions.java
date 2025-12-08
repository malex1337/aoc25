package com.amayr.d8;

import java.util.*;

public final class Junctions {

    public long task(List<String> lines, boolean part1) {
        List<Box> boxes = new ArrayList<>();

        for (String line : lines) {
            var split = line.split(",");
            boxes.add(new Box(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        UnionFind uf = new UnionFind(boxes.size());

        List<Edge> edges = getEdges(boxes);
        Collections.sort(edges);

        int applies = 0;
        int maxTries = part1 ? 1000 : 1000000;

        for (Edge edge : edges) {
            if (uf.union(edge.a, edge.b)) {
                applies++;
                if (applies == 999 && !part1) {
                    return ((long) boxes.get(edge.a).x * boxes.get(edge.b).x);
                }
            }
            maxTries--;
            if (maxTries < 0) {
                break;
            }
        }

        Map<Integer, Integer> cycles = new HashMap<>();
        for (int i = 0; i < boxes.size(); i++) {
            int root = uf.find(i);
            cycles.put(root, cycles.getOrDefault(root, 0) + 1);
        }

        List<Integer> c = new ArrayList<>(cycles.values());
        c.sort(Collections.reverseOrder());

        System.out.println((c.get(0) * c.get(1) * c.get(2)) + "");
        return (c.get(0) * c.get(1) * c.get(2));
    }

    private static List<Edge> getEdges(List<Box> boxes) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = i + 1; j < boxes.size(); j++) {
                Box box1 = boxes.get(i);
                Box box2 = boxes.get(j);
                long dist = ((long) (box1.x - box2.x) * (box1.x - box2.x))
                        + ((long) (box1.y - box2.y) * (box1.y - box2.y))
                        + ((long) (box1.z - box2.z) * (box1.z - box2.z));
                edges.add(new Edge(i, j, dist));
            }
        }
        return edges;
    }

    record Box(
            int x,
            int y,
            int z) {
    }

    record Edge(
            int a,
            int b,
            long dist
    ) implements Comparable<Edge> {

        @Override
        public int compareTo(Edge o) {
            return Long.compare(dist, o.dist);
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
}