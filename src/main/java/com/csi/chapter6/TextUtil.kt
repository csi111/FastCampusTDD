package com.csi.chapter6

fun refineText(txt : String, vararg options: String) : String{
    return txt
        .replace("    ", " ")
        .replace("\t", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("mockist", "*******")
        .replace("purist", "******")
        .let { original ->
            var result = original
            options.forEach { bannedWord ->
                result = result.replace(bannedWord, "*".repeat(bannedWord.length))
            }
            result
        }

}