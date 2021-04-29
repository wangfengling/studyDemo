package com.chuxin.study.anotation;


import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ArgumentsSource(ParamsFileProvider.class)
public @interface ParamsFromFile {

    String[] fileName() default {};
}
