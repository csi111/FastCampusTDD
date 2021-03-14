package com.csi.chapter5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RefineTest {
    @ParameterizedTest(name = "{displayName}{index} {arguments}")
    @DisplayName("containsSpaceCharacter")
    @MethodSource("provideSpaceHelloWorldStrings")
    fun replaceWorks(input: String, expected: String) {
        val actual = refineText(input)
        Assertions.assertEquals(expected, actual)
    }


    //TDD Test를 먼저 작성
    @ParameterizedTest(name = "{displayName}{index} {arguments}")
    @DisplayName("containsTabCharacter")
    @MethodSource("provideTabHelloWorldStrings")
    fun containsTabCharacter(input: String, expected: String) {
        val actual = refineText(input)
        Assertions.assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun provideSpaceHelloWorldStrings(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("hello  world", "hello world"),
                Arguments.of("hello   world", "hello world"),
                Arguments.of("hello    world", "hello world"),
                Arguments.of("hello     world", "hello world"),
                Arguments.of("hello      world", "hello world"),
                Arguments.of("hello       world", "hello world")
            )
        }

        @JvmStatic
        fun provideTabHelloWorldStrings(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("hello\t world", "hello world")
            )
        }
    }
}