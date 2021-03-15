package com.csi.chapter6

class Statistics {

    fun varianceOutput(`data's`: IntArray): String {
        return when {
            `data's`.isEmpty() -> {
                "입력된 데이터가 없습니다."
            }
            `data's`.size == 1 -> {
                "데이터가 부족해 분산을 계산할 수 없습니다. 2개 이상의 데이터를 입력해 주세요."
            }
            else -> {
                "분산 : ${getVariance(`data's`)}"
            }
        }
    }

    private fun getVariance(`data's`: IntArray): Double {
        val mean = calculateMean(`data's`)
        val sumOfSquares = calculateSumOfSquares(`data's`, mean)
        return sumOfSquares / (`data's`.size - 1)
    }

    private fun calculateSumOfSquares(`data's`: IntArray, mean: Double): Double {
        return `data's`.map { it - mean }.map { it * it }.sum()
    }

    private fun calculateMean(`data's`: IntArray): Double {
        return `data's`.average()
    }


}