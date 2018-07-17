package io.github.felipeanchieta.profits.core.entities

import org.junit.Assert.assertFalse
import org.junit.Test
import java.time.LocalDate

class SalaryRangeWeightingTest : WeightingsTest() {

    @Test
    fun `assert false`() {
        assertFalse(true)
    }

    private class SalaryAdapter(private val salary: Double) : Weighable {
        override fun getWeight() = Employee(
                id = "whatever",
                name = "whatever",
                department = Department.ACCOUNTING,
                position = "whatever",
                monthlySalary = salary,
                admittedAt = LocalDate.now()
        ).salaryRangeWeight
    }

}