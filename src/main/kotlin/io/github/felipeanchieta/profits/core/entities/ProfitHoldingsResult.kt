package io.github.felipeanchieta.profits.core.entities

data class ProfitHoldingsResult(
        val holdings: List<Holding>,
        val availableTotal: Double
) {
    val holdingsTotal = holdings.sumByDouble { it.value }
    val totalEmployees = holdings.size
    val totalBalance = availableTotal - holdingsTotal
}

data class Holding(
        val employeeId: String,
        val employeeName: String,
        val value: Double
)