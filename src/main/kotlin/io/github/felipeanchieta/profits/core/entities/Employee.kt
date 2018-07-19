package io.github.felipeanchieta.profits.core.entities

import java.time.LocalDate

data class Employee(
        val id: String,
        val name: String,
        val department: Department,
        val position: String,
        val monthlySalary: Double,
        val admittedAt: LocalDate
)