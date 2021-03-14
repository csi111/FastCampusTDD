package com.csi.chapter4

fun refineText(txt : String) : String{
    return txt.replace("    ", " ").replace("  ", " ")
}