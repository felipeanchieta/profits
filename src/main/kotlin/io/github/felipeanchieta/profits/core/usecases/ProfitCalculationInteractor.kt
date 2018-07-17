package io.github.felipeanchieta.profits.core.usecases

import io.github.felipeanchieta.profits.core.entities.Employee
import org.springframework.stereotype.Component

@Component
class ProfitCalculationInteractor(
        private val gateway: ProfitCalculationGateway
) {

    fun calculateBonus(distributableProfits: Double): List<Double> {
        gateway.retrieveEmployees()
        return emptyList()
    }

}

interface ProfitCalculationGateway {
    fun retrieveEmployees(): List<Employee>
}