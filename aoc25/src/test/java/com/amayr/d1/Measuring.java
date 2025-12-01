package com.amayr.d1;

import org.apache.commons.lang3.time.StopWatch;

public final class Measuring {
    private static int TOTAL_WIDTH = 50;

    public static void runMeasured(String taskName, Runnable runnable) {
        String title = " " + taskName + " ";
        int pad = (TOTAL_WIDTH - title.length()) / 2;
        int padRight = TOTAL_WIDTH - title.length() - pad;

        StopWatch stopWatch = StopWatch.create();

        String header = "=".repeat(pad) + title + "=".repeat(padRight);
        System.out.println("\n" + header);

        stopWatch.start();
        runnable.run();
        stopWatch.stop();

        System.out.println("\nTime taken: " + stopWatch + "\n");
        System.out.println("=".repeat(TOTAL_WIDTH));
    }
}