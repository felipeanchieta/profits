package io.github.felipeanchieta.profits.core.entities

data class ProfitResult(
        val holdings: List<Holding>,
        val holdingsTotal: Double,
        val availableTotal: Double
) {
    val totalEmployees = holdings.size
    val totalBalance = availableTotal - holdingsTotal
}

data class Holding(
        val employeeId: String,
        val employeeName: String,
        val holding: Double
)