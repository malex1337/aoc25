package com.amayr;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

public class AOCFileParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Method method = extensionContext.getTestMethod().orElse(null);

        if (method != null) {
            IncludeAOCFile annotation = method.getAnnotation(IncludeAOCFile.class);

            if (!List.class.equals(parameterContext.getParameter().getType())) {
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Method method = extensionContext.getTestMethod().orElseThrow();
        IncludeAOCFile annotation = method.getAnnotation(IncludeAOCFile.class);


        InputStream is = AOCFileParameterResolver.class.getClassLoader().getResourceAsStream(annotation.fileName());

        if (is == null) {
            throw new IllegalArgumentException("File not found: " + annotation.fileName());
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}