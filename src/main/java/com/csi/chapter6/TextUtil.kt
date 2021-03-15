package com.csi.chapter6

fun refineText(txt: String, vararg options: String): String {
    return maskBannedWords(compactWhiteSpaces(normalizeWhiteSpaces(txt)), options)
}

private fun maskBannedWords(original: String, options: Array<out String>): String {
    return options.fold(original) { sum, element ->
        maskBannedWord(sum, element)
    }
}

private fun maskBannedWord(result: String, bannedWord: String) =
    result.replace(bannedWord, "*".repeat(bannedWord.length))

private fun normalizeWhiteSpaces(source: String): String {
    return source.replace("\t", " ")
}

private fun compactWhiteSpaces(source : String) : String{
    return if(source.indexOf("  ") < 0) {
        source
    } else {
        compactWhiteSpaces(source.replace("  ", " "))
    }
}