package io.github.felipeanchieta.profits.core.entities

import java.time.LocalDate
import java.time.temporal.ChronoUnit

internal const val MINIMUM_WAGE = 954.0

data class Employee(
        val id: String,
        val name: String,
        val department: Department,
        val position: String,
        val monthlySalary: Double,
        val admittedAt: LocalDate
) {

    private fun departmentWeight() =
            when (department) {
                Department.GOVERNANCE -> 1
                Department.ACCOUNTING, Department.FINANCE, Department.TECHNOLOGY -> 2
                Department.SERVICES -> 3
                Department.CUSTOMER_EXPERIENCE -> 5
            }.toDouble()

    private fun salaryFactor() = Math.floor(monthlySalary / MINIMUM_WAGE).toInt()

    private fun salaryRangeWeight() = when (salaryFactor()) {
        in 0..3 -> 1
        in 3..5 -> 2
        in 5..8 -> 3
        else -> 8
    }.toDouble()

    private fun admissionWeight() = when (admittedAt.until(LocalDate.now(), ChronoUnit.YEARS)) {
        in 0..1 -> 1
        in 1 until 3 -> 2
        in 3 until 8 -> 3
        else -> 5
    }.toDouble()

    fun expectedHoldingShare() = ((monthlySalary * (admissionWeight() + departmentWeight())) / salaryRangeWeight()) * 12.0
}