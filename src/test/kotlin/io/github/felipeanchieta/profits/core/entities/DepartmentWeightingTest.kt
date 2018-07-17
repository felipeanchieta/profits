package io.github.felipeanchieta.profits.core.entities

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class DepartmentWeightingTest : WeightingsTest() {

    @Test
    fun `GOVERNANCE should weight 1`() {
        assertEquals(1, DepartmentAdapter(Department.GOVERNANCE).getWeight())
    }

    @Test
    fun `ACCOUNTING should weight 2`() {
        assertEquals(2, DepartmentAdapter(Department.ACCOUNTING).getWeight())
    }

    @Test
    fun `FINANCE should weight 2`() {
        assertEquals(2, DepartmentAdapter(Department.FINANCE).getWeight())
    }

    @Test
    fun `TECHNOLOGY should weight 2`() {
        assertEquals(2, DepartmentAdapter(Department.TECHNOLOGY).getWeight())
    }

    @Test
    fun `SERVICES should weight 3`() {
        assertEquals(3, DepartmentAdapter(Department.SERVICES).getWeight())
    }

    @Test
    fun `CUSTOMER EXPERIENCE should weight 5`() {
        assertEquals(5, DepartmentAdapter(Department.CUSTOMER_EXPERIENCE).getWeight())
    }

    private class DepartmentAdapter(private val department: Department) : Weighable {
        override fun getWeight() =
                Employee(id = "whatever",
                        name = "whatever",
                        department = department,
                        position = "whatever",
                        monthlySalary = 0.0,
                        admittedAt = LocalDate.now()
                ).departmentWeight
    }

}
