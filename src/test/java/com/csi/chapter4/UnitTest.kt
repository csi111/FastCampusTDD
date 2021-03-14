package com.csi.chapter4

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UnitTest {

//    @Test
//    fun twoSpaceReplaceTest() {
//        val actual = refineText("hello  world")
//        Assertions.assertEquals("hello world", actual)
//    }
//
//    @Test
//    fun fourSpaceReplaceTest() {
//        val actual = refineText("hello    world")
//        Assertions.assertEquals("hello world", actual)
//    }
//
//    @Test
//    fun threeSpaceReplaceTest() {
//        val actual = refineText("hello   world")
//        Assertions.assertEquals("hello world", actual)
//    }

//    @Test
//    fun correctlyWorks() {
//        arrayOf("hello  world", "hello    world", "hello   world").forEach {
//            val actual = refineText(it)
//            Assertions.assertEquals("hello world", actual)
//        }
//    }

    @ParameterizedTest
    @ValueSource(strings = ["hello  world", "hello   world", "hello    world"])
    fun replaceWorks(input: String) {
        println(input)
        val actual = refineText(input)
        Assertions.assertEquals("hello world", actual)
    }
}