package io.github.felipeanchieta.profits.core.entities

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Employee(
        val id: String,
        val name: String,
        val department: Department,
        val position: String,
        val monthlySalary: Double,
        val admittedAt: LocalDate
) {

    val departmentWeight by lazy {
        when (department) {
            Department.GOVERNANCE -> 1
            Department.ACCOUNTING, Department.FINANCE, Department.TECHNOLOGY -> 2
            Department.SERVICES -> 3
            Department.CUSTOMER_EXPERIENCE -> 5
        }
    }

    val salaryRangeWeight by lazy {
        val minimumWage = 954.0
        val factor = Math.floor(monthlySalary / minimumWage).toInt()

        when (factor) {
            in 0..3 -> 1
            in 3..5 -> 2
            in 5..8 -> 3
            else -> 8
        }
    }

    val admissionWeight by lazy {
        val today = LocalDate.now()
        val admissionYears = admittedAt.until(today, ChronoUnit.YEARS)

        when (admissionYears) {
            in 0..1 -> 1
            in 1 until 3 -> 2
            in 3 until 8 -> 3
            else -> 5
        }
    }

    val bonusFactor by lazy {
        (monthlySalary * (admissionWeight + departmentWeight) / salaryRangeWeight) * 12
    }
}