package io.github.felipeanchieta.profits.core.entities.scorer

import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.entities.Holding
import org.springframework.stereotype.Component

@Component
class NormalizedHoldingScorer {

    fun normalizeHolding(availableAmount: Double, employeesShares: List<Pair<Employee, Double>>): List<Holding> {
        val optimisticHoldingTotal = employeesShares.sumByDouble { it.second }

        val factor = if (optimisticHoldingTotal > availableAmount) availableAmount / optimisticHoldingTotal else 1.0

        return employeesShares.map { (employee, originalHoldingShare) ->
            Holding(
                    employeeId = employee.id,
                    employeeName = employee.name,
                    value = factor * originalHoldingShare
            )
        }
    }

}