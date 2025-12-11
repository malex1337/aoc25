package com.amayr.d10;

import java.util.*;
import java.util.regex.Pattern;

public final class Lightings {
    private final Pattern lights = Pattern.compile("^\\s*\\[([.#]+)\\]");
    private final Pattern buttons = Pattern.compile("\\(\\s*(\\d+(?:\\s*,\\s*\\d+)*)\\s*\\)");

    public int task1(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            String lightsString = lightsString(line);
            int lightsMask = parseLights(lightsString);
            List<int[]> buttons = parseButtons(line);

            Machine m = new Machine(lightsString.length(), lightsMask, buttons);

            var minPresses = bfs(m);
            sum += minPresses.size();
        }

        return sum;
    }

    private String lightsString(String line) {
        var lightsMatcher = lights.matcher(line);
        return lightsMatcher.find() ? lightsMatcher.group(1) : null;
    }

    private int parseLights(String lightsString) {
        int lightsMask = 0;
        for (int i = 0; i < lightsString.length(); i++) {
            char c = lightsString.charAt(i);
            if (c == '#') {
                lightsMask |= (1 << i);
            } else if (c == '.') {
                // off -> 0
            }
        }

        return lightsMask;
    }

    private List<int[]> parseButtons(String line) {
        var buttonsMatcher = buttons.matcher(line);

        List<int[]> buttonList = new ArrayList<>();
        while (buttonsMatcher.find()) {
            String[] parts = buttonsMatcher.group(1).split("\\s*,\\s*");
            int[] button = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                button[i] = Integer.parseInt(parts[i]);
            }
            buttonList.add(button);
        }

        return buttonList;
    }

    private List<Integer> bfs(Machine m) {
        int nStates = 1 << m.n;
        int start = 0;
        int target = m.targetMask;

        if (start == target) {
            return Collections.emptyList();
        }

        int[] prevState = new int[nStates];
        Arrays.fill(prevState, -1);
        int[] prevButton = new int[nStates];
        Arrays.fill(prevButton, -1);
        boolean[] visited = new boolean[nStates];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int b = 0; b < m.buttonMasks.length; b++) {
                int next = curr ^ m.buttonMasks[b];
                if (!visited[next]) {

                    visited[next] = true;
                    prevState[next] = curr;
                    prevButton[next] = b;

                    if (next == target) {
                        return reconstructPath(prevState, prevButton, target);
                    }
                    q.add(next);

                }
            }
        }
        return null;
    }

    private static List<Integer> reconstructPath(int[] prevState, int[] prevButton, int target) {
        List<Integer> pathButtons = new ArrayList<>();
        int cur = target;
        while (prevState[cur] != -1) {
            int btn = prevButton[cur];
            pathButtons.add(btn);
            cur = prevState[cur];
        }
        Collections.reverse(pathButtons); // now in press order
        return pathButtons;
    }

    static class Machine {
        int n; // nr of lights
        int targetMask; // target state bitmask 
        List<int[]> buttonList; // lsit of buttons
        int[] buttonMasks; // precomputed bitmask for each button

        public Machine(int n, int targetMask, List<int[]> buttonList) {
            this.n = n;
            this.targetMask = targetMask;
            this.buttonList = buttonList;
            this.buttonMasks = new int[buttonList.size()];

            // Precompute button masks
            for (int i = 0; i < buttonList.size(); i++) {
                int mask = 0;
                for (int idx : buttonList.get(i)) {
                    mask |= (1 << idx);
                }
                buttonMasks[i] = mask;
            }
        }
    }
}