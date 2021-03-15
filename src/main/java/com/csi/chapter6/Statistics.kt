package com.csi.chapter6

class Statistics {

    fun variance(`data's`: IntArray): String {
        return when {
            `data's`.isEmpty() -> {
                "입력된 데이터가 없습니다."
            }
            `data's`.size == 1 -> {
                "데이터가 부족해 분산을 계산할 수 없습니다. 2개 이상의 데이터를 입력해 주세요."
            }
            else -> {
                val mean = calculateMean(`data's`)

                val sumOfSquares = calculateSumOfSquares(`data's`, mean)

                val variance = sumOfSquares / (`data's`.size - 1)

                "분산 : $variance"
            }
        }
    }

    private fun calculateSumOfSquares(`data's`: IntArray, mean: Double): Double {
        var sumOfSquares = 0.0
        `data's`.forEach {
            sumOfSquares += (it - mean) * (it - mean)
        }
        return sumOfSquares
    }

    private fun calculateMean(`data's`: IntArray): Double {
        val sum = `data's`.sum()
        return sum.toDouble() / `data's`.size
    }


}