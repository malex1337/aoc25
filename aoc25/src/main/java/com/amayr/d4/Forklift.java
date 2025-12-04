package com.amayr.d4;

import java.util.Arrays;

public final class Forklift {
    private static final char PAPER = '@';
    private final char[][] grid;
    private final int rows;
    private final int cols;

    public Forklift(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public int accessibleRolls() {
        int accessibleCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == PAPER && hasFewerThanFourNeighbors(i, j)) {
                    accessibleCount++;
                }
            }
        }

        return accessibleCount;
    }

    public int accessibleRolls2() {
        int accessibleCount = 0;
        int iterations = 0;

        var gridCopy = Arrays.copyOf(grid, rows);
        var nextGrid = Arrays.copyOf(gridCopy, rows);

        var removedPaper = true;
        while (removedPaper) {
            removedPaper = false;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (gridCopy[i][j] == PAPER && hasFewerThanFourNeighbors(i, j)) {
                        accessibleCount++;
                        nextGrid[i][j] = '.';
                        removedPaper = true;
                    }
                }
            }
            iterations++;
            gridCopy = Arrays.copyOf(nextGrid, rows);
        }

        return accessibleCount;
    }

    private boolean hasFewerThanFourNeighbors(int row, int col) {
        int neighbors = 0;

        // north
        if (row > 0 && grid[row - 1][col] == PAPER) {
            neighbors++;
        }

        // northeast
        if (row > 0 && col < cols - 1 && grid[row - 1][col + 1] == PAPER) {
            neighbors++;
        }

        // east
        if (col < cols - 1 && grid[row][col + 1] == PAPER) {
            neighbors++;
        }

        // southeast
        if (row < rows - 1 && col < cols - 1 && grid[row + 1][col + 1] == PAPER) {
            neighbors++;
        }

        // south
        if (row < rows - 1 && grid[row + 1][col] == PAPER) {
            neighbors++;
        }

        // southwest
        if (row < rows - 1 && col > 0 && grid[row + 1][col - 1] == PAPER) {
            neighbors++;
        }

        // west
        if (col > 0 && grid[row][col - 1] == PAPER) {
            neighbors++;
        }

        // northwest
        if (row > 0 && col > 0 && grid[row - 1][col - 1] == PAPER) {
            neighbors++;
        }

        return neighbors < 4;
    }
}