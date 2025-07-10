package com.shubham.projects.journal.service;

import com.shubham.projects.journal.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                // we provide streams of arguments
                Arguments.of(User.builder().userName("madan").password("").build()),
                Arguments.of(User.builder().userName("mohan").password("mohan").build())
        );
    }
}
