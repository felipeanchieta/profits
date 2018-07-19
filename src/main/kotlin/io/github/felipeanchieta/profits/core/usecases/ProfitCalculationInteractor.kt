package io.github.felipeanchieta.profits.core.usecases

import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.entities.scorer.EmployeeHoldingShareScorer
import io.github.felipeanchieta.profits.core.entities.ProfitHoldingsResult
import io.github.felipeanchieta.profits.core.entities.scorer.NormalizedHoldingScorer
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class ProfitCalculationInteractor(
        private val gateway: ProfitCalculationGateway,
        private val employeeHoldingShareScorer: EmployeeHoldingShareScorer,
        private val normalizedHoldingScorer: NormalizedHoldingScorer
) {

    fun calculateBonus(availableAmount: Double): ProfitHoldingsResult {
        val employees = gateway.retrieveAllEmployees()

        val employeesShares = employees
                .parallelStream()
                .map { employee -> Pair(employee, employeeHoldingShareScorer.scoreEmployee(employee)) }
                .toList()

        val holdings = normalizedHoldingScorer.normalizeHolding(availableAmount, employeesShares)

        return ProfitHoldingsResult(
                holdings = holdings,
                availableTotal = availableAmount
        )
    }

}

interface ProfitCalculationGateway {
    fun retrieveAllEmployees(): List<Employee>
}