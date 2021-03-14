package com.csi.chapter5

fun refineText(txt : String) : String{
    return txt.replace("    ", " ").replace("   ", " ").replace("  ", " ")
}