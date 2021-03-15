package com.csi.chapter5

fun refineText(txt : String) : String{
    return txt
        .replace("    ", " ")
        .replace("\t", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("mockist", "*******")
        .replace("purist", "******")
}