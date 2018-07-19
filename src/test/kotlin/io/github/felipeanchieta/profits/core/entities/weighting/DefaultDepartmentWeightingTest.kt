package io.github.felipeanchieta.profits.core.entities.weighting

import io.github.felipeanchieta.profits.core.entities.Department
import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultDepartmentWeightingTest {

    private val departmentWeighting = DefaultDepartmentWeighting()

    @Test
    fun `GOVERNANCE should weight 1`() {
        assertEquals(1, departmentWeighting.calculate(Department.GOVERNANCE).toInt())
    }

    @Test
    fun `ACCOUNTING should weight 2`() {
        assertEquals(2, departmentWeighting.calculate(Department.ACCOUNTING).toInt())
    }

    @Test
    fun `FINANCE should weight 2`() {
        assertEquals(2, departmentWeighting.calculate(Department.FINANCE).toInt())
    }

    @Test
    fun `TECHNOLOGY should weight 2`() {
        assertEquals(2, departmentWeighting.calculate(Department.TECHNOLOGY).toInt())
    }

    @Test
    fun `SERVICES should weight 3`() {
        assertEquals(3, departmentWeighting.calculate(Department.SERVICES).toInt())
    }

    @Test
    fun `CUSTOMER EXPERIENCE should weight 5`() {
        assertEquals(5, departmentWeighting.calculate(Department.CUSTOMER_EXPERIENCE).toInt())
    }

}