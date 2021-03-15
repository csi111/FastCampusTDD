package com.csi.chapter6

class Statistics {

    fun variance(`data's`: IntArray): String {
        if (`data's`.isEmpty()) {
            return "입력된 데이터가 없습니다."
        }

        if (`data's`.size == 1) {
            return "데이터가 부족해 분산을 계산할 수 없습니다. 2개 이상의 데이터를 입력해 주세요."
        }

        val sum = `data's`.sum()
        val mean: Double = (sum / `data's`.size).toDouble()

        var sumOfSquares = 0.0
        `data's`.forEach {
            sumOfSquares += (it - mean) * (it - mean)
        }

        val variance = sumOfSquares / (`data's`.size - 1)


        return "분산 : $variance"


    }
}