package com.amayr;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class FileUtil {

    public static List<String> parseFile(String filename) {
        InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(filename);

        if (is == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}