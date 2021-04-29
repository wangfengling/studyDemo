package com.chuxin.study.anotation;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.util.Preconditions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

public class ParamsFileProvider implements ArgumentsProvider, AnnotationConsumer<ParamsFromFile> {
    private String[] resources;

    @Override
    public void accept(ParamsFromFile valueSource) {
        resources = valueSource.fileName();
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Arrays.stream(this.resources).map((resource) -> {
            return this.openInputStream(extensionContext, resource);
        }).map(this::toJSONString).flatMap(this::toStream);
    }

    private InputStream openInputStream(ExtensionContext context, String resource) {
        Preconditions.notBlank(resource, "Classpath resource [" + resource + "] must not be null or blank");
        ClassPathResource classPathResource = new ClassPathResource(resource);
        try {
            return classPathResource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String toJSONString(InputStream inputStream) {
        try{
            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }catch (Exception e){
            return null;
        }
    }

    private Stream<Arguments> toStream(String ss) {
        return Stream.of(ss).map((xva$0) -> Arguments.of(new Object[]{xva$0}));
    }
}
