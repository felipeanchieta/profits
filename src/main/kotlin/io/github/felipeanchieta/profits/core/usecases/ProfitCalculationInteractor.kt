package io.github.felipeanchieta.profits.core.usecases

import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.entities.Holding
import io.github.felipeanchieta.profits.core.entities.ProfitHoldingsResult
import org.springframework.stereotype.Component

@Component
class ProfitCalculationInteractor(
        private val gateway: ProfitCalculationGateway
) {

    fun calculateBonus(availableTotal: Double): ProfitHoldingsResult {
        if (availableTotal == 0.0) throw IllegalStateException("will end up diving by zero")

        val employees = gateway.retrieveAllEmployees()

        val expectedHoldingShares = employees.mapIndexed { index, employee -> Pair(index, employee.expectedHoldingShare()) }

        val optimisticHoldingTotal = expectedHoldingShares.sumByDouble { it.second }

        val factor = if (optimisticHoldingTotal > availableTotal) availableTotal / optimisticHoldingTotal else 1.0

        val holdings = expectedHoldingShares.map { (index, originalHoldingShare) ->
            val employee = employees[index]
            Holding(
                    employeeId = employee.id,
                    employeeName = employee.name,
                    value = factor * originalHoldingShare
            )
        }

        return ProfitHoldingsResult(
                holdings = holdings,
                availableTotal = availableTotal
        )
    }

}

interface ProfitCalculationGateway {
    fun retrieveAllEmployees(): List<Employee>
}