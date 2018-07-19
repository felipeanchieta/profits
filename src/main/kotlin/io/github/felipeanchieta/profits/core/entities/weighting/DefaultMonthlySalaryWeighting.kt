package io.github.felipeanchieta.profits.core.entities.weighting

import io.github.felipeanchieta.profits.core.entities.scorer.MonthlySalaryWeightingStrategy
import org.springframework.stereotype.Component

@Component
class DefaultMonthlySalaryWeighting : MonthlySalaryWeightingStrategy {
    override val minimumWage = 954.0

    override fun calculate(salary: Double): Double {
        val factor = Math.floor(salary / minimumWage)
        return when (factor) {
            in 0 until 3 -> 1
            in 3 until 5 -> 2
            in 5 until 8 -> 3
            else -> 5
        }.toDouble()
    }
}