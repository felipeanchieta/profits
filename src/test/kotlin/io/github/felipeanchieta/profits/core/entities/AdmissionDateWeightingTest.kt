package io.github.felipeanchieta.profits.core.entities

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate
import java.time.Month
import java.time.temporal.Temporal

class AdmissionDateWeightingTest : WeightingsTest() {

    @Test
    fun `should weight 1 when no more than one year in the company`() {
        assertEquals(1, AdmissionDateAdapter(LocalDate.of(2017, Month.JULY, 14)).getWeight())
    }

    @Test
    fun `should weight 2 when no more one year in the company but less than three`() {
        assertEquals(2, AdmissionDateAdapter(LocalDate.of(2017, Month.JULY, 13)).getWeight())
    }

    private class AdmissionDateAdapter(private val admissionDate: Temporal) : Weighable {
        override fun getWeight() =
                Employee(id = "whatever",
                        name = "whatever",
                        department = Department.ACCOUNTING,
                        position = "whatever",
                        monthlySalary = 0.0,
                        admittedAt = admissionDate
                ).admissionWeight
    }

}