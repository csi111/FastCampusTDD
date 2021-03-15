package com.csi.chapter5

import io.github.serpro69.kfaker.Faker
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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

    @ParameterizedTest(name = "{displayName}{index} {arguments}")
    @DisplayName("bannedWordReplaceCharacter")
    @MethodSource("provideBannedWordsHelloWorldStrings")
    fun bannedWordReplaceCharacter(input: String, bannedWords : Array<String>, expected: String) {
        val actual = refineText(input)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    @DisplayName("givenBannedWordReplaceCharacter")
    fun givenBannedWordReplaceCharacter() {
        //Given
        val bannedWord = Faker().lorem.words()
        val source = "hello $bannedWord"

        //When
        val actual = refineText(source)

        val expected = "hello ${"*".repeat(bannedWord.length)}"
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
                Arguments.of("hello\t world", "hello world"),
                Arguments.of("hello \tworld", "hello world")
            )
        }

        @JvmStatic
        fun provideBannedWordsHelloWorldStrings(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("hello mockist", arrayOf("mockist", "purist"), "hello *******"),
                Arguments.of("hello purist", arrayOf("mockist", "purist"), "hello ******")
            )
        }
    }
}