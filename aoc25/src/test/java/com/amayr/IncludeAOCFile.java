package com.amayr;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(AOCFileParameterResolver.class)
public @interface IncludeAOCFile {
    String fileName();
}